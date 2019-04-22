package main.java.com.rss.amazon;

import java.util.Scanner;

public class RowWithMax1s {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int k = 0; k < t; k++) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			int[][] arr = new int[m][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = scn.nextInt();
				}
			}
			System.out.println(findMax1IndexTraverse(arr, n, m));
		}
		scn.close();
	}

	public static int findMax1IndexTraverse(int[][] arr, int row, int column) {
		int result = 0, i, j;
		for (i = 0, j = column - 1; i < row; i++) {
			while (j >= 0 && arr[i][j] == 1) {
				result = i;
				j--;
			}
		}
		return result;
	}
}

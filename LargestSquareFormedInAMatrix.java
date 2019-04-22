package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestSquareFormedInAMatrix {

	public static void main(String[] args) {
		int testCases, row, column;
		String[] tempData;
		int[][] arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				tempData = br.readLine().split("\\s+");
				row = Integer.parseInt(tempData[0]);
				column = Integer.parseInt(tempData[1]);
				tempData = br.readLine().split("\\s+");
				arr = new int[row][column];
				for(int i=0; i<row; i++)
					for(int j=0; j<column; j++)
						arr[i][j] = Integer.parseInt(tempData[i * column + j]);
				System.out.println(findLargestSquare(arr, row, column));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int findLargestSquare(int[][] arr, int row, int column) {
		int resultMax = 0;
		int[][] resultArr = new int[row+1][column+1];
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=column; j++) {
				if(arr[i-1][j-1] != 0) {
					resultArr[i][j] = 1 + Math.min(resultArr[i][j-1], 
							Math.min(resultArr[i-1][j-1], resultArr[i-1][j]));
					if(resultMax < resultArr[i][j])
						resultMax = resultArr[i][j];
				}
			}
		}
		return resultMax;
	}

}

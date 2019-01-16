package main.java.com.rss.gfg.amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindWhetherPathExist {

	public static void main(String[] args) {
		int testcases, rowCol;
		int[][] matrix;
		Scanner scan = new Scanner(System.in);
		testcases = scan.nextInt();
		while(testcases-- != 0) {
			rowCol = scan.nextInt();
			matrix = new int[rowCol][rowCol];
			for(int i=0; i<rowCol; i++)
				for(int j=0; j<rowCol; j++)
					matrix[i][j] = scan.nextInt();
			if(pathExistence(matrix, rowCol))
				System.out.println("1");
			else
				System.out.println("0");
		}
		scan.close();
	}
	
	private static boolean pathExistence(int[][] matrix, int rowCol) {
		class Coordinate {
			int x;
			int y;
			public Coordinate(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		boolean result = false;
		Coordinate node;
		int[] xPath = new int[]{-1, 0, 1, 0};
		int[] yPath = new int[]{0, 1, 0, -1};
		boolean[][] visited = new boolean[rowCol][rowCol];
		Queue<Coordinate> bfsQueue = new LinkedList<>();
		for(int i=0; i<rowCol; i++) {
			for(int j=0; j<rowCol; j++) {
				if(matrix[i][j] == 1) {
					bfsQueue.add(new Coordinate(i, j));
					while(!bfsQueue.isEmpty()) {
						node = bfsQueue.poll();
						for(int k=0; k<4; k++) {
							if(node.x + xPath[k] >= 0 && node.x + xPath[k] < rowCol 
									&& node.y + yPath[k] >= 0 && node.y + yPath[k] < rowCol 
									&& visited[node.x + xPath[k]][node.y + yPath[k]] == false) {
								if(matrix[node.x + xPath[k]][node.y + yPath[k]] == 2) {
									result = true;
									break;
								}
								if(matrix[node.x + xPath[k]][node.y + yPath[k]] == 3)
									bfsQueue.add(new Coordinate(node.x + xPath[k], node.y + yPath[k]));
							}
						}
						if(result)
							break;
						visited[node.x][node.y] = true;
					}
					break;
				}
			}
		}
		return result;
	}

}

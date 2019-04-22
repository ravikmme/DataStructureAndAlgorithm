package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathInMatrix {
	
	static class Cell {
		int xCoordinate;
		int yCoordinate;
		long pathSum;
		public Cell(int xCoordinate, int yCoordinate, long pathSum) {
			super();
			this.xCoordinate = xCoordinate;
			this.yCoordinate = yCoordinate;
			this.pathSum = pathSum;
		}
	}

	public static void main(String[] args) {
		int testCases, noOfElements;
		int[][] arr;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				noOfElements = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				arr = new int[noOfElements][noOfElements];
				for(int i=0; i<noOfElements; i++)
					for(int j=0; j<noOfElements; j++)
						arr[i][j] = Integer.parseInt(tempData[i * noOfElements + j]);
				System.out.println(findMaxPath_Dp(arr, noOfElements));
//				System.out.println(findMaxPath_Bfs(arr, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static long findMaxPath_Dp(int[][] arr, int noOfElements) {
		long[][] resultArr = new long[noOfElements][noOfElements];
		for(int i=0; i<noOfElements; i++)
			resultArr[0][i] = arr[0][i];
		for(int i=1; i<noOfElements; i++) {
			for(int j=0; j<noOfElements; j++) {
				if(j == 0)
					resultArr[i][j] = arr[i][j] + Math.max(resultArr[i - 1][j], resultArr[i - 1][j + 1]);
				else if(j == noOfElements - 1)
					resultArr[i][j] = arr[i][j] + Math.max(resultArr[i - 1][j], resultArr[i - 1][j - 1]);
				else
					resultArr[i][j] = arr[i][j] + Math.max(resultArr[i - 1][j - 1], Math.max(resultArr[i - 1][j], resultArr[i - 1][j + 1]));
			}
		}
		return Arrays.stream(resultArr[noOfElements - 1]).max().getAsLong();
	}
	
	public static long findMaxPath_Bfs(int[][] arr, int noOfElements) {
		long currentSum;
		long maxSum = Long.MIN_VALUE;
		for(int i=0; i<noOfElements; i++) {
			currentSum = findMaxPathUtil_Bfs(arr, noOfElements, new Cell(0, i, arr[0][i]));
			if(currentSum > maxSum)
				maxSum = currentSum;
		}
		return maxSum;
	}
	
	public static long findMaxPathUtil_Bfs(int[][] arr, int noOfElements, Cell startCell) {
		int x, y;
		long sumTillNow;
		long maxSum = Long.MIN_VALUE;
		Queue<Cell> objQueue = new LinkedList<>();
		objQueue.add(startCell);
		while(!objQueue.isEmpty()) {
			Cell presentCell = objQueue.poll();
			x = presentCell.xCoordinate;
			y = presentCell.yCoordinate;
			sumTillNow = presentCell.pathSum;
			if (x == noOfElements - 1) {
				if(sumTillNow > maxSum)
					maxSum = sumTillNow;
			}
			else {
				if(x + 1 < noOfElements) {
					objQueue.add(new Cell(x + 1, y, sumTillNow + arr[x + 1][y]));
					if(y - 1 >= 0)
						objQueue.add(new Cell(x + 1, y - 1, sumTillNow + arr[x + 1][y - 1]));
					if(y + 1 < noOfElements)
						objQueue.add(new Cell(x + 1, y + 1, sumTillNow + arr[x + 1][y + 1]));
				}
			}
		}
		return maxSum;
	}

}

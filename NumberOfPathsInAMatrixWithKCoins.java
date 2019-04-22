package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfPathsInAMatrixWithKCoins {
	
	static class Count{
		int i = 0;
	}

	public static void main(String[] args) {
		int testCases, noOfElements, totalCoinRequired;
		String[] tempData;
		int[][] arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				totalCoinRequired = Integer.parseInt(br.readLine());
				noOfElements = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				arr = new int[noOfElements][noOfElements];
				for(int i=0; i<noOfElements; i++)
					for(int j=0; j<noOfElements; j++)
						arr[i][j] = Integer.parseInt(tempData[i * noOfElements + j]);
//				System.out.println(findPath(arr, noOfElements, totalCoinRequired));
				System.out.println(findPathBfs(arr, noOfElements, totalCoinRequired));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int findPath(int[][] arr, int noOfElements, int totalCoinRequired) {
		Count objCount = new Count();
		findPathUtil(arr, noOfElements, totalCoinRequired, Arrays.asList(0, 0), 0, objCount);
		return objCount.i;
    }
	
	public static int findPathBfs(int[][] arr, int noOfElements, int totalCoinRequired) {
		class Cell{
			int x;
			int y;
			int currentSum;
			public Cell(int x, int y, int currentSum) {
				this.x = x;
				this.y = y;
				this.currentSum = currentSum;
			}
		}
		int count = 0;
		Cell objCell;
		Queue<Cell> objBfs = new LinkedList<>();
		objBfs.add(new Cell(0, 0, 0));
		while(!objBfs.isEmpty()) {
			objCell = objBfs.poll();
			if(objCell.x == noOfElements - 1 && objCell.y == noOfElements - 1) {
				if(objCell.currentSum + arr[objCell.x][objCell.y] == totalCoinRequired)
					++count;
			}
			else {
				if(objCell.x + 1 < noOfElements)
					objBfs.add(new Cell(objCell.x + 1, objCell.y, objCell.currentSum + arr[objCell.x][objCell.y]));
				if(objCell.y + 1 < noOfElements)
					objBfs.add(new Cell(objCell.x, objCell.y + 1, objCell.currentSum + arr[objCell.x][objCell.y]));
			}
			
		}
		return count;
	}
	
	public static void findPathUtil(int[][] arr, int noOfElements, int totalCoinRequired, List<Integer> objIntList, int coinSum, Count finalCount) {
		int xCoordinate = objIntList.get(0);
		int yCoordinate = objIntList.get(1);
		if(xCoordinate == noOfElements-1 && yCoordinate == noOfElements - 1) {
			if(coinSum + arr[xCoordinate][yCoordinate] == totalCoinRequired) {
				finalCount.i++;
			}
			return;
		}
		if(xCoordinate + 1 < noOfElements)
			findPathUtil(arr, noOfElements, totalCoinRequired, Arrays.asList(xCoordinate + 1, yCoordinate), coinSum + arr[xCoordinate][yCoordinate], finalCount);
		if(yCoordinate + 1 < noOfElements)
			findPathUtil(arr, noOfElements, totalCoinRequired, Arrays.asList(xCoordinate, yCoordinate + 1), coinSum + arr[xCoordinate][yCoordinate], finalCount);
	}

}

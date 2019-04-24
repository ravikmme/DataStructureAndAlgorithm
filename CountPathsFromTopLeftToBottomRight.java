package main.java.com.rss.walmart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountPathsFromTopLeftToBottomRight {
	
	static class PathCount {
		int noOfPaths = 0;
	}

	public static void main(String[] args) {
		int testCases, row, column;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				tempData = br.readLine().split("\\s+");
				row =Integer.parseInt(tempData[0]);
				column =Integer.parseInt(tempData[1]);
				System.out.println(possiblePaths(row, column));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static int possiblePaths(int row, int column) {
		PathCount objPathCount = new PathCount();
		possiblePathsUtil(0, 0, row, column, objPathCount);
		return objPathCount.noOfPaths;
	}

	public static void possiblePathsUtil(int presentRow, int presentColumn, int row, int column, PathCount objPathCount) {
		if(presentRow == row - 1 && presentColumn == column - 1) {
			objPathCount.noOfPaths++;
			return;
		}
		if(presentColumn + 1 < column)
			possiblePathsUtil(presentRow, presentColumn + 1, row, column, objPathCount);
		if(presentRow + 1 < row)
			possiblePathsUtil(presentRow + 1, presentColumn, row, column, objPathCount);
	}
}

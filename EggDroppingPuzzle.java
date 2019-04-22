package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EggDroppingPuzzle {

	public static void main(String[] args) {
		int testCases, noOfEggs, noOfFloors;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				tempData = br.readLine().split("\\s+");
				noOfEggs = Integer.parseInt(tempData[0]);
				noOfFloors = Integer.parseInt(tempData[1]);
				System.out.println(minAttemptRequired(noOfEggs, noOfFloors));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int minAttemptRequired(int noOfEggs, int noOfFloors) {
		int maxNum, minNum = 0;
		int[][] resultArr = new int[noOfEggs][noOfFloors];
		for(int i=0; i<noOfEggs; i++) {
			for(int j=0; j<noOfFloors; j++) {
				if(i == 0)
					resultArr[i][j] = j + 1;
				else if(j < i)
					resultArr[i][j] = resultArr[i - 1][j];
				else {
					for(int k=0; k<=j; k++) {
						if(k == 0) {
							maxNum = resultArr[i][j-1];
							minNum = maxNum;
						}
						else if (k == j)
							maxNum = resultArr[i-1][j-1];
						else
							maxNum = Math.max(resultArr[i-1][k-1], resultArr[i][j-k-1]);
						if(maxNum < minNum)
							minNum = maxNum;
					}
					resultArr[i][j] = 1 + minNum;
				}
			}
		}
		return resultArr[noOfEggs-1][noOfFloors-1];
	}

}

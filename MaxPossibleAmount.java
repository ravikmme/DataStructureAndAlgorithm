package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxPossibleAmount {
	
	static class GamePoint {
		int firstPlayerPoint;
		int secondPlayerPoint;
		public GamePoint(int firstPlayerPoint, int secondPlayerPoint) {
			this.firstPlayerPoint = firstPlayerPoint;
			this.secondPlayerPoint = secondPlayerPoint;
		}
	}

	public static void main(String[] args) {
		int testCases, noOfElements;
		String[] tempData;
		int[] arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				noOfElements = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				arr = new int[noOfElements];
				for(int i=0; i<noOfElements; i++)
					arr[i] = Integer.parseInt(tempData[i]);
				System.out.println(findMaxPossibleAmount(arr, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int findMaxPossibleAmount(int[] arr, int noOfElements) {
		int firstChoice, secondChoice;
		GamePoint[][] result = new GamePoint[noOfElements][noOfElements];
		for(int i=0; i<noOfElements; i++)
			result[i][i] = new GamePoint(arr[i], 0);
		for(int gap=1; gap<noOfElements; gap++) {
			for(int i=0, j=gap; j<noOfElements; i++, j++) {
				firstChoice = arr[i] + result[i+1][j].secondPlayerPoint;
				secondChoice = arr[j] + result[i][j-1].secondPlayerPoint;
				if(firstChoice >= secondChoice)
					result[i][j] = new GamePoint(firstChoice, result[i+1][j].firstPlayerPoint);
				else
					result[i][j] = new GamePoint(secondChoice, result[i][j-1].firstPlayerPoint);
			}
		}
		return result[0][noOfElements-1].firstPlayerPoint;
	}

}
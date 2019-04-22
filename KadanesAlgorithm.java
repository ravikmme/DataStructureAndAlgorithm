package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		int testCases, noOfElements;
		int[] arr;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				noOfElements = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				arr = new int[noOfElements];
				for(int i=0; i<noOfElements; i++)
					arr[i] = Integer.parseInt(tempData[i]);
				System.out.println(findMaxContinguousSum(arr, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	private static int findMaxContinguousSum(int[] arr, int noOfElements) {
		int maxSum = Integer.MIN_VALUE;
		int sumTillNow = 0;
		for(int i=0; i<noOfElements; i++) {
			if(arr[i] + sumTillNow > maxSum)
				maxSum = arr[i] + sumTillNow;
			if(arr[i] + sumTillNow < 0)
				sumTillNow = 0;
			else
				sumTillNow += arr[i];

		}
		return maxSum;
	}

}

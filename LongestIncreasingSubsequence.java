package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestIncreasingSubsequence {

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
				System.out.println(findLongestIncreaseSubseq(arr, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int findLongestIncreaseSubseq(int[] arr, int noOfElements) {
		int i, max =0;
		int[] resultArr = new int[noOfElements];
		for(i=0; i<noOfElements; i++)
			resultArr[i] = 1;
		for(i=1; i<noOfElements; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && resultArr[j] + 1 > resultArr[i])
					resultArr[i] = 1 + resultArr[j];
			}
			if(max < resultArr[i])
				max = resultArr[i];
		}
		return max;
	}

}

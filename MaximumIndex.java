package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumIndex {

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
				System.out.println(findMaxDiffIndex(arr, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int findMaxDiffIndex(int[] arr, int noOfElements) {
		int i, j, maxDiff = -1;
		int minArr[] = new int[noOfElements];
		int maxArr[] = new int[noOfElements];
		minArr[0] = arr[0];
		for(i=1; i<noOfElements; i++)
			minArr[i] = Math.min(arr[i], minArr[i-1]);
		maxArr[noOfElements - 1] = arr[noOfElements - 1];
		for(i=noOfElements-2; i>=0; i--)
			maxArr[i] = Math.max(arr[i], maxArr[i+1]);
		i = 0;
		j = 0;
		while(i < noOfElements && j < noOfElements) {
			if(minArr[i] <= maxArr[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j++;
			}
			else
				i++;
		}
		return maxDiff;
	}
}

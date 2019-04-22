package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubsetSumProblem {

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
				System.out.println(findPossibleEqualSubset_Dp(arr, noOfElements));
//				System.out.println(findPossibleEqualSubset_Rec(arr, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String findPossibleEqualSubset_Dp(int[] arr, int noOfElements) {
		int totalSum = 0;
		for(int i=0; i<noOfElements; i++)
			totalSum += arr[i];
		if(totalSum % 2 != 0)
			return "NO";
		if(isSumPossible_Dp(arr, noOfElements, totalSum/2))
			return "YES";
		return "NO";
	}
	
	public static boolean isSumPossible_Dp(int[] arr, int noOfElements, int sum) {
		boolean[][] result = new boolean[noOfElements][sum + 1];
		Arrays.sort(arr);
		for(int i=0; i<noOfElements; i++)
			result[i][0] = true;
		result[0][arr[0]] = true;
		for(int i=1; i<noOfElements; i++) {
			for(int j=1; j<=sum; j++) {
				if(j-arr[i] >= 0)
					result[i][j] = result[i-1][j] || result[i-1][j-arr[i]];
				else
					result[i][j] = result[i-1][j];
			}
			
			if(result[i][sum])
				return true;
		}
		return result[noOfElements -1][sum];
	}
	
	public static String findPossibleEqualSubset_Rec(int[] arr, int noOfElements) {
		int totalSum = 0;
		for(int i=0; i<noOfElements; i++)
			totalSum += arr[i];
		for(int i=1; i<=noOfElements; i++) {
			if(findCombination_Rec(arr, noOfElements, 0, i, 0, totalSum))
				return "YES";
		}
		return "NO";
	}
	
	public static boolean findCombination_Rec(int[] arr, int noOfElements, int pos, int requiredElements, int currentSum, int totalSum) {
		if(requiredElements == 0) {
			if(totalSum - currentSum == currentSum)
				return true;
			return false;
		}
		if(pos >= noOfElements)
			return false;
		for(int i=pos; i<noOfElements; i++) {
			if(findCombination_Rec(arr, noOfElements, pos + 1, requiredElements - 1, currentSum + arr[i], totalSum) ||
					findCombination_Rec(arr, noOfElements, pos + 1, requiredElements, currentSum, totalSum))
				return true;
		}
		return false;
	}
	

}

package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountWaysToNthStair {

	public static void main(String[] args) {
		int testCases, noOfStair;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				noOfStair = Integer.parseInt(br.readLine());
//				System.out.println(findWaysUtil(noOfStair));
				System.out.println(findWaysUtil_Dp(noOfStair));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * public static int findWays(int noOfStair) {
	 * 
	 * }
	 */

	public static long findWaysUtil(int noOfStair) {
		long count = 0l;
		if(noOfStair == 0)
			return 1;
		if(noOfStair < 0)
			return 0;
		for(int i=1; i<=2; i++) {
			count += findWaysUtil(noOfStair - i);
		}
		return count;
	}
	
	public static long findWaysUtil_Dp(int noOfStair) {
		long[] resultArr = new long[noOfStair + 1];
		resultArr[0] = 1;
		resultArr[1] = 1;
		for(int i=2; i<=noOfStair; i++)
			resultArr[i] = 1 + resultArr[i-2];
		return resultArr[noOfStair];
	}

}

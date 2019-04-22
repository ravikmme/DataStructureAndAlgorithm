package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountOfNDigitNumbersWithSum {
	
	private static int[][] memResult = new int[101][1001];

	public static void main(String[] args) {
		int testCases, noOfDigits, sum;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				tempData = br.readLine().split("\\s+");
				noOfDigits = Integer.parseInt(tempData[0]);
				sum = Integer.parseInt(tempData[1]);
				System.out.println(findCount(noOfDigits, sum));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static int findCount(int noOfDigits, int sum) {
		int count = 0;
		for(int i=0; i<101; i++)
			for(int j=0; j<1001; j++)
				memResult[i][j] = -1;
		for(int i=1; i<=9; i++) {
			if(sum - i >= 0) {
				count += findCountUtil(noOfDigits - 1, sum - i);
			}
				
		}
		return count == 0 ? -1 : count;
	}
	
	public static int findCountUtil(int noOfDigits, int sum) {
		int count = 0;
		if(sum == 0)
			return 1;
		if(noOfDigits == 0 || sum <= 0) {
			if(sum == 0)
				return 1;
			return 0;
		}
		if(memResult[noOfDigits][sum] != -1)
			return memResult[noOfDigits][sum];
		for(int i=0; i<=9; i++) {
			if(sum >= 0)
				count += findCountUtil(noOfDigits - 1, sum - i);
			if(count > 1000000006)
				count = count % 1000000007;
		}
		return memResult[noOfDigits][sum] = count;
	}
}

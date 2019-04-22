package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfCoins {

	public static void main(String[] args) {
		int testCases, noOfCoins, coinSum;
		int[] coinArr;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				tempData = br.readLine().split("\\s+");
				coinSum = Integer.parseInt(tempData[0]);
				noOfCoins = Integer.parseInt(tempData[1]);
				tempData = br.readLine().split("\\s+");
				coinArr = new int[noOfCoins];
				for(int i=0; i<noOfCoins; i++)
					coinArr[i] = Integer.parseInt(tempData[i]);
				System.out.println(findNoOfCoins(coinArr, noOfCoins, coinSum));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static int findNoOfCoins(int[] coinArr, int noOfCoins, int coinSum) {
		int max = coinSum + 1;
		int[] result = new int[coinSum + 1];
		Arrays.sort(coinArr);
		for(int i=1; i<=coinSum; i++)
			result[i] = max;
		for(int i=0; i<noOfCoins; i++)
			for(int j=coinArr[i]; j<=coinSum; j++)
				result[j] = Math.min(result[j], 1 + result[j-coinArr[i]]);
		return result[coinSum] == coinSum + 1 ? -1 : result[coinSum];
	}

}

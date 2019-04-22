package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BettingGame {

	public static void main(String[] args) {
		int testCases;
		String result;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				result = br.readLine();
				System.out.println(findBalance(result.toCharArray(), 4));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int findBalance(char[] result, int initialAmount) {
		int balanceLeft = initialAmount, bidAmount = 1;
		char outcome;
		for(int i=0; i<result.length; i++) {
			outcome = result[i];
			if(outcome == 'W') {
				balanceLeft += bidAmount;
				bidAmount = 1;
			}
			else {
				balanceLeft -= bidAmount;
				bidAmount *= 2;
			}
			if(i < result.length - 1 && balanceLeft < bidAmount)
				return -1;
		}
		return balanceLeft;
	}

}

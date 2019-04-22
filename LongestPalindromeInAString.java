package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestPalindromeInAString {

	public static void main(String[] args) {
		int testCases;
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while (testCases-- > 0) {
				str = br.readLine().trim();
				System.out.println(findLongestPalin(str.toCharArray()));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * public static String findLongestPalin(char[] charArr) { int maxPalinLength =
	 * 1, strLength, startPoint = 0; int[][] resultArr; strLength = charArr.length;
	 * resultArr = new int[strLength][strLength]; for(int i=0; i<strLength; i++)
	 * resultArr[i][i] = 1;
	 * 
	 * for(int i=1; i<strLength; i++) { for(int j=i; j<strLength; j++) {
	 * if(charArr[j-i] == charArr[j]) { resultArr[j-i][j] = resultArr[j-i+1][j-1] +
	 * 2; if(maxPalinLength < resultArr[j-i][j]) { maxPalinLength =
	 * resultArr[j-i][j]; startPoint = j - maxPalinLength + 1; } } else
	 * resultArr[j-i][j] = Math.max(resultArr[j-i][j-1], resultArr[j-i+1][j]); } }
	 * 
	 * for(int i=1; i<strLength; i++) { for(int j=0; j<strLength-i; j++) {
	 * if(charArr[j] == charArr[j+i]) { resultArr[j][j+i] = 2 +
	 * resultArr[j+1][j+i-1]; if(maxPalinLength < resultArr[j][j+i]) {
	 * maxPalinLength = resultArr[j][j+i]; startPoint = j + i - maxPalinLength + 1;
	 * } } else resultArr[j][j+i] = Math.max(resultArr[j][j+i-1],
	 * resultArr[j+1][j+i]); } } return String.valueOf(Arrays.copyOfRange(charArr,
	 * startPoint, startPoint + maxPalinLength)); }
	 */
	
	public static String findLongestPalin(char[] charArr) {
		int maxPalinLength = 1, strLength, startPoint = 0;
		boolean[][] resultArr;
		strLength = charArr.length;
		resultArr = new boolean[strLength][strLength];
		for(int i=0; i<strLength; i++)
			resultArr[i][i] = true;
		for(int i=1; i<strLength; i++) {
			for(int j=0; j<strLength-i; j++) {
				if((charArr[j] == charArr[j+i]) && (i == 1 ? true : resultArr[j+1][j+i-1])) {
					resultArr[j][j+i] = true;
					if(maxPalinLength < i + 1) {
						maxPalinLength = i + 1;
						startPoint = j;
					}
				}
			}
		}
		return String.valueOf(Arrays.copyOfRange(charArr, startPoint, startPoint + maxPalinLength));
	}

}

package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		int testCases, strLen1, strLen2;
		String str1, str2;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				tempData = br.readLine().split("\\s+");
				strLen1 = Integer.parseInt(tempData[0]);
				strLen2 = Integer.parseInt(tempData[1]);
				str1 = br.readLine().trim();
				str2 = br.readLine().trim();
				System.out.println(findLongestCommonSubseq(str1, strLen1, str2, strLen2));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int findLongestCommonSubseq(String str1, int strLen1, String str2, int strLen2) {
		int[][] resultArr = new int[strLen1 + 1][strLen2 + 1];
		for(int i=1; i<=strLen1; i++) {
			for(int j=1; j<=strLen2; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1))
					resultArr[i][j] = 1 + resultArr[i - 1][j - 1];
				else
					resultArr[i][j] = Math.max(resultArr[i - 1][j], resultArr[i][j - 1]);
			}
		}
		return resultArr[strLen1][strLen2];
	}

}

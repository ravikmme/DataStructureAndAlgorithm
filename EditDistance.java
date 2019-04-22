package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {

	public static void main(String[] args) {
		int testCases, len1, len2;
		String str1, str2;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				tempData = br.readLine().split("\\s+");
				len1 = Integer.parseInt(tempData[0]);
				len2 = Integer.parseInt(tempData[1]);
				tempData = br.readLine().split("\\s+");
				str1 = tempData[0];
				str2 = tempData[1];
				System.out.println(changesRequired(str1, len1, str2, len2));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int changesRequired(String str1, int len1, String str2, int len2) {
		int[][] resultArr = new int[len1 + 1][len2 + 1];
		for(int i=0; i<=len1; i++) {
			for(int j=0; j<=len2; j++) {
				if(i == 0)
					resultArr[i][j] = j;
				else if(j == 0)
					resultArr[i][j] = i;
				else if(str1.charAt(i - 1) == str2.charAt(j - 1))
					resultArr[i][j] = resultArr[i-1][j-1];
				else
					resultArr[i][j] = 1 + Math.min(resultArr[i][j-1], Math.min(resultArr[i-1][j], resultArr[i-1][j-1]));	//insert, remove, replace
			}
		}
		return resultArr[len1][len2];
	}

}

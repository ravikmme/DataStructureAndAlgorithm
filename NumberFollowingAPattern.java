package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberFollowingAPattern {

	public static void main(String[] args) {
		int testCases;
		String pattern;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				pattern = br.readLine().trim();
				System.out.println(printPattern(pattern.toCharArray()));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String printPattern(char[] charArr) {
		int start = 1;
		int length = charArr.length;
		char[] result = new char[length + 1];
		for(int i=0; i<=length; i++) {
			if(i == length || charArr[i] == 'I') {
				for(int j=i-1 ; j>=-1; j--) {
					result[j+1] = (char) (start++ + '0');
					if (j == -1 || charArr[j] == 'I')
						break;
				}
			}
		}
		return new String(result);
	}

}

package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringFormationFromSubstring {

	public static void main(String[] args) {
		int testCases;
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases =Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				str = br.readLine().trim();
				System.out.println(findSubstring(str) ? "True" : "False");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean findSubstring(String str) {
		int len;
		StringBuilder front, back, repeatStr;
		front = new StringBuilder();
		back = new StringBuilder();
		len = str.length();
		for(int i=0, j=len-1; i<j; i++,j--) {
			front.append(str.charAt(i));
			back.insert(0, str.charAt(j));
			if(front.toString().equals(back.toString()) && len % front.length() == 0) {
				repeatStr = new StringBuilder();
				for(int k=0; k<len/front.length(); k++)
					repeatStr.append(front.toString());
				if(str.equals(repeatStr.toString()))
					return true;
			}
		}
		return false;
	}

}

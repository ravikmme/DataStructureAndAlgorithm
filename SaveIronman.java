package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaveIronman {

	public static void main(String[] args) { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases;
		String str;
		try {
			testCases = Integer.parseInt(br.readLine());
			for(int i=0; i<testCases; i++) {
				str = br.readLine();
				System.out.println(checkPalindrome(str));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	private static String checkPalindrome(String str) {
		boolean palindromeFlag = true;
		char front, back;
		int len = str.length();
		int low = 0;
		int high = len - 1;
		while(low < high) {
			front = str.charAt(low);
			back = str.charAt(high);
			if(front == back){
				++low;
				--high;
				continue;
			}
			else if((front >= 65 && front <= 90 || front >= 97 && front <=122) 
					&& (back >= 65 && back <= 90 || back >= 97 && back <= 122) && Math.abs(front - back) == 32) {
				++low;
				--high;
				continue;
			}
			else if(!(front >= 65 && front <= 90 || front >= 97 && front <=122 
					|| front >= 48 && front <= 57)) {
				++low;
				if(!(back >= 65 && back <= 90 || back >= 97 && back <=122 
						|| back >= 48 && back <= 57))
					--high;
				continue;
			}
			else if(!(back >= 65 && back <= 90 || back >= 97 && back <=122 
					|| back >= 48 && back <= 57)) {
				--high;
				continue;
			}
			else {
				palindromeFlag = false;
				break;
			}
		}
		if(palindromeFlag)
			return "YES";
		else
			return "NO";
	}

}

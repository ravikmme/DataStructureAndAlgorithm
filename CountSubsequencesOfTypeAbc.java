package main.java.com.rss.gfg.amazon;

import java.util.Scanner;

public class CountSubsequencesOfTypeAbc {

	public static void main(String[] args) {
		int testCases;
		String str;
		Scanner scan = new Scanner(System.in);
		testCases = scan.nextInt();
		while(testCases-- != 0) {
			str = scan.next();
			System.out.println(findSubseqCount(str));
		}
		scan.close();
	}

	private static int findSubseqCount(String str) {
		int aCount = 0, bCount = 0, cCount = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='a')
				aCount = 1 + 2 * aCount;
			else if(str.charAt(i)=='b')
				bCount = aCount + 2 * bCount;
			else if(str.charAt(i)=='c')
				cCount = bCount + 2 * cCount;
		}
		return cCount;
	}
}

package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfWays {

	public static void main(String[] args) {
		int testCases, length;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				length = Integer.parseInt(br.readLine());
				System.out.println(countWays(length, 4));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static long countWays(int length, int width) {
		long[] count = new long[length + 1];
		count[0] = 0;
		for(int i=1; i<=length; i++) {
			if(i > width)
				count[i] = count[i-1] + count[i-width];
			else if(i < width)
				count[i] = 1l;
			else
				count[i] = 2l;
		}
		System.out.println(Arrays.toString(count));
		return count[length];
	}

}

package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialKeyboard {

	public static void main(String[] args) {
		int testCases, num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				num = Integer.parseInt(br.readLine());
				System.out.println(findAOccurence_N(num));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static int findAOccurence_N(int num) {
		if(num <= 6)
			return num;
		int[] result = new int[num + 1];
		for(int i=1; i<=6; i++)
			result[i] = i;
		for(int i=7; i<=num; i++) {
			for(int j=i-5; j<i; j++) {
				if(result[i] < result[j] * (i-j-1))
					result[i] = result[j] * (i-j-1);
			}
		}
		return result[num];
	}
	
	/*public static int findAOccurence_1(int N) {
	    int[] best = new int[]{0, 1, 2, 3, 4, 5, 6, 9, 12,
                               16, 20, 27, 36, 48, 64, 81};
        int q = N > 15 ? (N - 11) / 5 : 0;
        return best[N - 5*q] << 2 * q;
	}*/

}

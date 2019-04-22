package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsBinaryNumberMultipleOf3 {

	public static void main(String[] args) {

		int testCases;
		String data;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while (testCases-- > 0) {
				data = br.readLine();
				System.out.println(isMultipleOf3(Integer.parseInt(data, 2)));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	public static int isMultipleOf3(int num) {
		int oddCount = 0, evenCount = 0;
		if (num < 0)
			num = -num;
		if (num == 0)
			return 1;
		if (num == 1)
			return 0;
		while (num != 0) {
			if ((num & 1) != 0)
				++oddCount;
			num = num >> 1;
			if ((num & 1) != 0)
				++evenCount;
			num = num >> 1;
		}
		return isMultipleOf3(Math.abs(oddCount - evenCount));
	}

}

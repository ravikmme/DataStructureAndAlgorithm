package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PossibleGroups {

	public static void main(String[] args) {
		int testCases, noOfElements;
		String[] tempData;
		int[] arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while (testCases-- > 0) {
				noOfElements = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				arr = new int[noOfElements];
				for (int i = 0; i < noOfElements; i++)
					arr[i] = Integer.parseInt(tempData[i]);
				System.out.println(findGroups(arr, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	public static long findGroups(int[] arr, int noOfElements) {
		long result = 0l;
		long[] rem = new long[] { 0l, 0l, 0l };
		for (int i = 0; i < noOfElements; i++)
			rem[arr[i] % 3]++;
		result += (rem[0] * (rem[0] - 1)) / 2;
		result += rem[1] * rem[2];
		result += (rem[0] * (rem[0] - 1) * (rem[0] - 2)) / 6;
		result += (rem[1] * (rem[1] - 1) * (rem[1] - 2)) / 6;
		result += (rem[2] * (rem[2] - 1) * (rem[2] - 2)) / 6;
		result += rem[0] * rem[1] * rem[2];
		return result;
	}

}

package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfQueryII {

	public static void main(String[] args) {
		int testCases, noOfElements, noOfQuery;
		String[] tempData;
		int[] arr, query;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				noOfElements = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				arr = new int[noOfElements];
				for(int i=0; i<noOfElements; i++)
					arr[i] = Integer.parseInt(tempData[i]);
				noOfQuery = Integer.parseInt(br.readLine().trim());
				tempData = br.readLine().split("\\s+");
				query = new int[2 * noOfQuery];
				for(int i=0; i<noOfQuery*2; i++)
					query[i] = Integer.parseInt(tempData[i]);
				findSumQuery(arr, noOfElements, query, noOfQuery);
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void findSumQuery(int[] arr, int noOfElements, int[] query, int noOfQuery) {
		for(int i=1; i<noOfElements; i++)
			arr[i] += arr[i-1];
		for(int i=0; i<noOfQuery; i++)
			System.out.print((arr[query[i * 2 + 1] - 1] - (query[i * 2] - 2 < 0 ? 0 : arr[query[i * 2] - 2])) + " ");
	}

}

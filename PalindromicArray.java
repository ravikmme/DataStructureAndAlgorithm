package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicArray {

	public static void main(String[] args) {
		int testCases, noOfElements;
		int[] arr;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				noOfElements = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				arr = new int[noOfElements];
				for(int i=0; i<noOfElements; i++)
					arr[i] = Integer.parseInt(tempData[i]);
				System.out.println(convertPalinOperation(arr, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int convertPalinOperation(int[] arr, int noOfElements) {
		int low = 0, high = noOfElements - 1, noOfOperations = 0;
		while(low < high) {
			if(arr[low] == arr [high]) {
				low++;
				high--;
			}
			else if(arr[low] < arr[high] && low + 1 <= high) {
				arr[low + 1] += arr[low];
				low++;
				noOfOperations++;
			}
			else if(arr[low] > arr[high] && high - 1 >= low) {
				arr[high - 1] += arr[high];
				high--;
				noOfOperations++;
			}
		}
		return noOfOperations;
	}

}

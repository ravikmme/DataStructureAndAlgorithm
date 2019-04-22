package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NextPermutation {

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
				System.out.println(findNextGreater(arr, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String findNextGreater(int[] arr, int noOfElements) {
		int prevElement, smallSwapIndex = -1, nextBigSwapIndex = -1, nextBigSwapNumber = Integer.MAX_VALUE;
		if(noOfElements > 1)
			prevElement = arr[noOfElements - 1];
		else
			return String.valueOf(arr[0]);
		for(int i=noOfElements-2; i>=0; i--) {
			if(arr[i] < prevElement) {
				smallSwapIndex = i;
				break;
			}
			else
				prevElement = arr[i];
		}
		if(smallSwapIndex == -1) {
			Arrays.sort(arr);
		}
		else {
			for(int i=smallSwapIndex+1; i<noOfElements; i++) {
				if(arr[i] > arr[smallSwapIndex] && arr[i] < nextBigSwapNumber) {
					nextBigSwapIndex = i;
					nextBigSwapNumber = arr[i];
				}
			}
			//Swap smallSwapIndex & nextBigSwapIndex
			arr[nextBigSwapIndex] = arr[smallSwapIndex];
			arr[smallSwapIndex] = nextBigSwapNumber;
			Arrays.sort(arr, smallSwapIndex + 1, noOfElements);
		}
		return Arrays.stream(arr).mapToObj(a-> String.valueOf(a)).reduce((o1, o2)-> o1 + " " + o2).get();
	}

}

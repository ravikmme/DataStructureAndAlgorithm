package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarraysOfSizeK {

	public static void main(String[] args) {
		int testCases, noOfElements, window;
		String[] tempData;
		int[] arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while (testCases-- > 0) {
				tempData = br.readLine().split("\\s+");
				noOfElements = Integer.parseInt(tempData[0]);
				window = Integer.parseInt(tempData[1]);
				tempData = br.readLine().split("\\s+");
				arr = new int[noOfElements];
				for (int i = 0; i < noOfElements; i++)
					arr[i] = Integer.parseInt(tempData[i]);
				windowMax(arr, noOfElements, window);
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	public static void windowMax(int[] arr, int noOfElements, int window) {
		Deque<Integer> objDq = new LinkedList<Integer>();
		for (int i = 0; i < window; i++) {
			while (objDq.size() > 0 && arr[objDq.peekLast()] < arr[i])
				objDq.removeLast();
			objDq.add(i);
		}
		System.out.print(arr[objDq.peek()] + " ");
		for (int i = window; i < noOfElements; i++) {
			if(i - objDq.peekFirst() >= window)
				objDq.removeFirst();
			while (objDq.size() > 0 && arr[objDq.peekLast()] < arr[i])
				objDq.removeLast();
			objDq.add(i);
			System.out.print(arr[objDq.peek()] + " ");
		}
	}

}

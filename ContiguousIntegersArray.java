package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ContiguousIntegersArray {
	public static void main (String[] args) { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases, numOfElements;
		String allElements;
		String[] arrRange;
		try {
			testCases = Integer.parseInt(br.readLine().trim());
			for(int i=0; i<testCases; i++) {
				numOfElements = Integer.parseInt(br.readLine().trim());
				allElements = br.readLine();
				arrRange = allElements.split("\\s+");
				int[] arr = new int[numOfElements];
				for(int j=0; j<numOfElements; j++) {
					arr[j] = Integer.parseInt(arrRange[j].trim());
				}
				System.out.println(contiguous(arr, arr.length) ? "Yes" : "No");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean contiguous(int arr[], int n) {
		boolean isContiguous = true;
		Set<Integer> uniqueElementSet = new HashSet<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			min = Math.min(arr[i], min);
			max = Math.max(arr[i], max);
			uniqueElementSet.add(arr[i]);
		}
		if(max-min+1 != uniqueElementSet.size())
			isContiguous = false;
		return isContiguous;
	}
}

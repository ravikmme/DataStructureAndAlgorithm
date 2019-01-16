package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositiveNegativePair {

	public static void main(String[] args) { 
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
				List<Integer> objList = findPair(arr, arr.length);
				if(objList.size()==0)
					System.out.println(0);
				else {
					for(int k=objList.size()-1; k>=0; k--) {
						System.out.print(objList.get(k) + " ");
						if(k!=0)
							System.out.print(" ");
							
					}
					System.out.println();
					objList.stream().map(a -> a + " ").forEach(System.out::print);
				}
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Integer> findPair(int arr[], int n) {
		List<Integer> objList = new ArrayList<>();
		int pos = n - 1;
		int element;
		Arrays.sort(arr);
		for(int i=0; i<n; i++) {
			if(arr[i] >= 0)
				break;
			else {
				element = Math.abs(arr[i]);
				while(arr[pos] > element)
					--pos;
				if(element == arr[pos]){
					objList.add(arr[pos]);
					objList.add(arr[i]);
					--pos;
				}
			}
		}
		return objList;
	}

}

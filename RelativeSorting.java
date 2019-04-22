package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RelativeSorting {

	public static void main(String[] args) {
		int testCases, noOfElementsInFirst, noOfElementsInSecond;
		String[] tempData;
		Integer[] arr, refArr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				tempData = br.readLine().split("\\s+");
				noOfElementsInFirst = Integer.parseInt(tempData[0]);
				noOfElementsInSecond = Integer.parseInt(tempData[1]);
				tempData = br.readLine().split("\\s+");
				arr = new Integer[noOfElementsInFirst];
				for(int i=0; i<noOfElementsInFirst; i++)
					arr[i] = Integer.parseInt(tempData[i]);
				tempData = br.readLine().split("\\s+");
				refArr = new Integer[noOfElementsInSecond];
				for(int i=0; i<noOfElementsInSecond; i++)
					refArr[i] = Integer.parseInt(tempData[i]);
				relativeSort(arr, noOfElementsInFirst, refArr, noOfElementsInSecond);
				System.out.println(Arrays.stream(arr).map(a -> a.toString()).reduce((o1, o2) -> o1 + " " + o2).get());
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Integer[] relativeSort(Integer[] arr, int noOfElementsInFirst, Integer[] refArr, int noOfElementsInSecond) {
		Map<Integer, Integer> objMap = new HashMap<>();
		
		for(int i=0; i<noOfElementsInSecond; i++)
			objMap.put(refArr[i], i);
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				Integer firstIndex = objMap.get(o1);
				Integer secondIndex = objMap.get(o2);
				if(firstIndex != null && secondIndex != null)
					return firstIndex - secondIndex;
				else if(firstIndex != null)
					return -1;
				else if(secondIndex != null)
					return 1;
				else
					return o1-o2;
			}
		});
		return arr;
	}

}

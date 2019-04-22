package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberOfJumps {
	
	static class Index {
		int minJump = Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		int testCases, noOfElements;
		int[] arr;
		String[] tempData;
//		Index objIndex;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				noOfElements = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				arr = new int[noOfElements];
				for(int i=0; i<noOfElements; i++)
					arr[i] = Integer.parseInt(tempData[i]);
//				objIndex = new Index();
//				findMinJump(arr, noOfElements, 0, 0, 0, objIndex);
//				System.out.println(objIndex.minJump);
				System.out.println(findMinJump_Dp(arr, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void findMinJump(int[] arr, int noOfElements, int startPos, int range, int noOfJumps, Index objIndex) {
		if(range >= noOfElements) {
			if(objIndex.minJump > noOfJumps)
				objIndex.minJump = noOfJumps;
		}
		for(int i=startPos; i<=range && i<noOfElements; i++) {
			findMinJump(arr, noOfElements, i + 1, i + arr[i], noOfJumps + 1, objIndex);
		}
	}
	
	public static int findMinJump_Dp(int[] arr, int noOfElements) {
		int range, max, noOfJumps = 0;
		for(int i=0; i<noOfElements; i++) {
			range = arr[i];
			if(range == 0)
				return -1;
			max = i + range--;
			if(max >= noOfElements - 1) {
				++noOfJumps;
				break;
			}
			while(range > 0) {
				if(max + arr[max] < i + range + arr[i + range])
					max = i + range;
				--range;
			}
			if(max > i)
				i = max - 1;
			else
				return -1;
			++noOfJumps;
		}
		return noOfJumps;
	}
}

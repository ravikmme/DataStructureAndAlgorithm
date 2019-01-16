package main.java.com.rss.gfg.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class BoxStacking {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		//sc.next();
		while(t-- > 0)
		{
			int n = sc.nextInt();

			int A[]  =new int[1000];
			int B[] = new int[1000];
			int C[] = new int[1000];

			for(int i = 0; i < n; i++)
			{
				int a =sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();

				A[i] = a;
				B[i] = b;
				C[i] = c;
			}

			System.out.println(maxHeight(A,B,C,n));
		}
		sc.close();
	}

	public static int maxHeight(int height[], int width[], int length[], int n)	{
		int noOfCombination, maxPossibleHeight;
		int[] maxHeightArr, resultArr;
		List<List<Integer>> postureList = getAllPossibleCombination(height, width, length, n);
		noOfCombination = postureList.size();
		maxHeightArr = new int[noOfCombination];
		resultArr = new int[noOfCombination];
		for(int i=0; i<noOfCombination; i++){
			maxHeightArr[i] = postureList.get(i).get(2);
			resultArr[i] = i;
		}
		
		for(int i=1; i<noOfCombination; i++) {
			for(int j=0; j<i; j++) {
				if(postureList.get(i).get(0) < postureList.get(j).get(0) 
						&& postureList.get(i).get(1) < postureList.get(j).get(1) 
						&& maxHeightArr[j] + postureList.get(i).get(2) > maxHeightArr[i]) {
					maxHeightArr[i] = maxHeightArr[j] + postureList.get(i).get(2);
					resultArr[i] = j;
				}
			}
		}
		
		maxPossibleHeight = Arrays.stream(maxHeightArr).max().getAsInt();
		/*List<List<Integer>> boxStackList = new ArrayList<>();
		for(int i=0; i<noOfCombination; i++) {
			if(maxHeightArr[i] == maxPossibleHeight) {
				while(resultArr[i] != i) {
					boxStackList.add(postureList.get(i));
					i = resultArr[i];
				}
				boxStackList.add(postureList.get(i));
				break;
			}
		}
		System.out.println(boxStackList);*/
			
		
		return maxPossibleHeight;
	}

	private static List<List<Integer>> getAllPossibleCombination(int[] height, int[] width, int[] length, int n) {
		int eachLength;
		int eachWidth;
		int eachHeight;
		List<List<Integer>> postureList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			eachLength = length[i];
			eachWidth = width[i];
			eachHeight = height[i];
			if(eachWidth > eachHeight)
				postureList.add(Arrays.asList(eachWidth, eachHeight, eachLength));
			else
				postureList.add(Arrays.asList(eachHeight, eachWidth, eachLength));
			if(eachLength > eachHeight)
				postureList.add(Arrays.asList(eachLength, eachHeight, eachWidth));
			else
				postureList.add(Arrays.asList(eachHeight, eachLength, eachWidth));
			if(eachLength > eachWidth)	
				postureList.add(Arrays.asList(eachLength, eachWidth, eachHeight));
			else
				postureList.add(Arrays.asList(eachWidth, eachLength, eachHeight));
		}
		Collections.sort(postureList, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return ((o2.get(0) * o2.get(1)) - (o1.get(0) * o1.get(1)));
			}
		});
		return postureList;
	}
}
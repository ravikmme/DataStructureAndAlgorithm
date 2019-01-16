package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationPossible {

	public static void main(String[] args) {
		int testCases, arrSize, targetChildren;
		int[] boxArr;
		String[] strArr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			for(int i=0; i<testCases; i++) {
				strArr = br.readLine().split("\\s+");
				arrSize = Integer.parseInt(strArr[0]);
				boxArr = new int[arrSize];
				for(int j=0; j<arrSize; j++)
					boxArr[j] = Integer.parseInt(strArr[j+1]);
				targetChildren = Integer.parseInt(br.readLine());
				if(combination(boxArr, targetChildren))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	/*public static boolean combination(int[] boxArr, int targetChildren) {
		int numOfBox;
		numOfBox = boxArr.length;
		int[] combinationPossible = new int[targetChildren + 1];
		Arrays.fill(combinationPossible, 0);
		combinationPossible[0] = 1;
		Arrays.sort(boxArr);
		for(int i=1; i<=targetChildren; i++) {
			for(int j=0; j<numOfBox; j++) {
				if(i >= boxArr[j])
					combinationPossible[i] += combinationPossible[i-boxArr[j]];
				else
					break;
			}
		}
		return false;
	}*/

	public static boolean combination(int[] boxArr, int targetChildren) {
		int numOfBox;
		numOfBox = boxArr.length;
		boolean combinationPossible[][] = new boolean[targetChildren+1][numOfBox+1]; 

		for (int i = 0; i <= numOfBox; i++) 
			combinationPossible[0][i] = true; 

		for (int i = 1; i <= targetChildren; i++) 
			combinationPossible[i][0] = false; 

		for (int i = 1; i <= targetChildren; i++) 
		{ 
			for (int j = 1; j <= numOfBox; j++) 
			{ 
				combinationPossible[i][j] = combinationPossible[i][j-1]; 
				if (i >= boxArr[j-1]) 
					combinationPossible[i][j] = combinationPossible[i][j] ||  
					combinationPossible[i - boxArr[j-1]][j-1]; 
			} 
		} 
		return combinationPossible[targetChildren][numOfBox]; 
	}

}

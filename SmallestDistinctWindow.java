package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SmallestDistinctWindow {

	public static void main(String[] args) {
		int testCases;
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			for(int i=0; i<testCases; i++) {
				str = br.readLine();
				System.out.println(findSmallDistinctWin_NSol(str));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private static int findSmallDistinctWin_NSol(String str) {
		int maxSize, strLen, uniqueCharCount, tempUniqueCharCount, minUniqueStrLen, start, presentMinStart;
		char[] charArr;
		maxSize = 256;
		tempUniqueCharCount = uniqueCharCount = start = presentMinStart =0;
		minUniqueStrLen = Integer.MAX_VALUE;
		boolean[] visited = new boolean[maxSize];
		int[] containsArr = new int[maxSize];
		Arrays.fill(visited, false);
		strLen = str.length();
		charArr = str.toCharArray();
		for(char eachChar : charArr){
			if(visited[eachChar] == false)
				++uniqueCharCount;
			visited[eachChar] = true;
		}
		for(int i=0; i<strLen; i++) {
			if(containsArr[charArr[i]] == 0)
				++tempUniqueCharCount;
			containsArr[charArr[i]]++;
			if(tempUniqueCharCount == uniqueCharCount) {
				if(minUniqueStrLen > i-start+1) {
					minUniqueStrLen = i-start+1;
					presentMinStart = start;
				}
			}
		}
		return 0;
	}

}

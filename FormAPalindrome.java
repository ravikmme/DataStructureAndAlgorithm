package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormAPalindrome {

	public static void main(String[] args) {
		int testCases;
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				str = br.readLine().trim();
//				System.out.println(findPalindromeFormation_Rec(str.toCharArray(), 0, str.length() - 1, new HashMap<String, Integer>()));
				System.out.println(findPalindromeFormation_DP(str.toCharArray()));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*public static int findPalindromeFormation_Rec(char[] charArr, int low, int high, Map<String, Integer> objMap) {
		int result;
		if(low > high) {
			result = 0;
			objMap.put(low + "-" + high, result);
			return result;
		}
		if(objMap.containsKey((low) + "-" + (high)))
			return objMap.get((low) + "-" + (high));
		if(charArr[low] == charArr[high]) {
			result = findPalindromeFormation_Rec(charArr, low + 1, high - 1, objMap);
			objMap.put(low + "-" + high, result);
			return result;
		}
		else {
			result = Math.min(findPalindromeFormation_Rec(charArr, low, high - 1, objMap), 
					findPalindromeFormation_Rec(charArr, low + 1, high, objMap)) + 1;
			objMap.put(low + "-" + high, result);
			return result;
		}
	}*/
	
	public static int findPalindromeFormation_DP(char[] charArr) {
		int length = charArr.length;
		int[][] resultArr = new int[length][length];
		for(int i=1; i<length; i++) {
			for(int j=0; j<length-i; j++) {
				if(charArr[j] == charArr[j+i])
					resultArr[j][j+i] = resultArr[j+1][j+i-1];
				else
					resultArr[j][j+i] = Math.min(resultArr[j][j+i-1], resultArr[j+1][j+i]) + 1;
			}
		}
		return resultArr[0][length - 1];
	}

}

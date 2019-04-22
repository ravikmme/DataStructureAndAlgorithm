package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClosestPalindrome {

	public static void main(String[] args) {
		int testCases;
		String strData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				strData = br.readLine().trim();
				System.out.println(findClosestPalindrome(strData));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	public static String findClosestPalindrome(String strData) {
		int length;
		char[] mirrorStr;
		long diff1, diff2, diff3;
		String addToMid = null, subtractToMid = null, leftHalf, mirror;
		length = strData.length();
		long strLong = Long.parseLong(strData);

		if(strData.equals(new StringBuilder(strData).reverse().toString()))
			return strData;

		if(length == 1)
			return String.valueOf((char)(strData.charAt(0) - 1));


		if(checkAllNine(strData, length)) {
			StringBuilder strBuild = new StringBuilder();
			strBuild.append("1");
			for(int i=1; i<length; i++)
				strBuild.append("0");
			strBuild.append("1");
			return strBuild.toString();
		}

		if(strLong == Math.pow(10, length - 1))
			return String.valueOf(strLong - 1);

		mirrorStr = mirrorLeft(strData.toCharArray(), length);
		mirror = String.valueOf(mirrorStr);
		diff1 = Math.abs(strLong - Long.parseLong(String.valueOf(mirrorStr)));
		char mid = mirrorStr[(length - 1) / 2];
		if(length % 2 != 0) {
			//Add to mid
			if(mid != '9') {
				addToMid = mirror.substring(0, length / 2) + (char)(mid + 1) + mirror.substring(length / 2 + 1);
			}
			else {
				leftHalf = String.valueOf(Integer.parseInt(mirror.substring(0, length / 2)) + 1);
				addToMid = leftHalf + '0' + new StringBuilder(leftHalf).reverse().toString();
			}
			//subtract to mid
			if(mid != '0') {
				subtractToMid = mirror.substring(0, length / 2) + (char)(mid - 1) + mirror.substring(length / 2 + 1);
			}
			else {
				leftHalf = String.valueOf(Integer.parseInt(mirror.substring(0, length / 2)) - 1);
				subtractToMid = leftHalf + '9' + new StringBuilder(leftHalf).reverse().toString();
			}
		}
		else {
			//Add to mid
			if(mid != '9') {
				addToMid = mirror.substring(0, (length - 1) / 2) + (char)(mid + 1) + (char)(mid + 1) + mirror.substring(length / 2 + 1);
			}
			else {
				leftHalf = String.valueOf(Integer.parseInt(mirror.substring(0, length / 2)) + 1);
				addToMid = leftHalf + new StringBuilder(leftHalf).reverse().toString();
			}
			//subtract to mid
			if(mid != '0') {
				subtractToMid = mirror.substring(0, (length - 1) / 2) + (char)(mid - 1) + (char)(mid - 1) + mirror.substring(length / 2 + 1);
			}
			else {
				leftHalf = String.valueOf(Integer.parseInt(mirror.substring(0, length / 2)) - 1);
				subtractToMid = leftHalf + new StringBuilder(leftHalf).reverse().toString();
			}
		}
		diff2 = Math.abs(strLong - Long.parseLong(addToMid));
		diff3 = Math.abs(strLong - Long.parseLong(subtractToMid));
		if(diff1 > diff2) {
			if(diff3 > diff2)
				return addToMid;
			else {
				if(diff3 > diff1)
					return mirror;
				else
					return subtractToMid;
			}

		}
		else {
			if(diff3 > diff1)
				return mirror;
			else
				return subtractToMid;
		}

	}

	public static char[] mirrorLeft(char[] strData, int length) {
		char[] mirrorData = new char[length];
		for(int i=0, j=length-1; i<length/2; i++,j--) {
			mirrorData[i] = strData[i];
			mirrorData[j] = strData[i];
		}
		if(length % 2 != 0)
			mirrorData[length / 2] = strData[length / 2];
		return mirrorData;
	}

	public static boolean checkAllNine(String strData, int length) {
		boolean result = true;
		for(int i=0; i<length; i++) {
			if(strData.charAt(i) != '9') {
				result = false;
				break;
			}
		}
		return result;
	}

}

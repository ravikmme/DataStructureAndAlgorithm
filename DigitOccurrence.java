package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitOccurrence {
	public static void main (String[] args) { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases, searchDigit, startRange, endRange;
		String numRange;
		String[] arrRange;
		try {
			testCases = Integer.parseInt(br.readLine());
			for(int i=0; i<testCases; i++) {
				searchDigit = Integer.parseInt(br.readLine());
				numRange = br.readLine();
				arrRange = numRange.split(" ");
				startRange = Integer.parseInt(arrRange[0]);
				endRange = Integer.parseInt(arrRange[1]);
				System.out.println(Math.abs(countOccurrences(startRange, searchDigit) 
				- countOccurrences(endRange - 1, searchDigit)));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			try{
				throw new NumberFormatException();
				
			}catch(Exception ex) {
				
			}
		}
	}
	
		public static int countOccurrences(int number, int searchDigit) {
		int prevNumber = 0;
		int countOccur = 0;
		int place = 0;
		int presentDigit;
		if(searchDigit == 0) {
			while(number != 0) {
				presentDigit = number % 10;
				System.out.println((place * (int)Math.pow(10, place - 1)) * presentDigit + (presentDigit == 0 ? prevNumber + 1 - (int)Math.pow(10, place) : 0));
				countOccur = countOccur + ((place * (int)Math.pow(10, place - 1)) * presentDigit) 
						+ (presentDigit == 0 ? prevNumber + 1 - (int)Math.pow(10, place) : 0);
				prevNumber = prevNumber + presentDigit * (int)Math.pow(10, place);
				number = number / 10;
				++place;
			}
		}
		else {
			while(number != 0) {
				presentDigit = number % 10;
				countOccur = countOccur + ((place * (int)Math.pow(10, place - 1)) * presentDigit)
						+ (searchDigit < presentDigit && searchDigit != 0 ? (int)Math.pow(10, place) : 0) 
						+ (presentDigit == searchDigit && searchDigit != 0 ? prevNumber + 1 : 0); 
				prevNumber = prevNumber + presentDigit * (int)Math.pow(10, place);
				number = number / 10;
				++place;
			}
			
		}
		return countOccur;
	}
}
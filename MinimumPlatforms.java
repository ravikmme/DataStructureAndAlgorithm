package main.java.com.rss.walmart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumPlatforms {

	public static void main(String[] args) {
		int testCases, noOfElements;
		int[] arrival, departure;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				noOfElements = Integer.parseInt(br.readLine().trim());
				tempData = br.readLine().split("\\s+");
				arrival = new int[noOfElements];
				for(int i=0; i<noOfElements; i++)
					arrival[i] = Integer.parseInt(tempData[i]);
				tempData = br.readLine().split("\\s+");
				departure = new int[noOfElements];
				for(int i=0; i<noOfElements; i++)
					departure[i] = Integer.parseInt(tempData[i]);
				System.out.println(findMinPlatforms(arrival, departure, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int findMinPlatforms(int[] arrival, int[] departure, int noOfElements) {
		int minRequiredPlatforms, currentPlatforms, arrivalPos, departurePos;
		minRequiredPlatforms = 0;
		currentPlatforms = arrivalPos = departurePos = 0;
		Arrays.sort(arrival);
		Arrays.sort(departure);
		while(arrivalPos < noOfElements && departurePos < noOfElements) {
			if(arrival[arrivalPos] <= departure[departurePos]) {
				currentPlatforms++;
				arrivalPos++;
				if(minRequiredPlatforms < currentPlatforms)
					minRequiredPlatforms = currentPlatforms;
			}
			else if(arrival[arrivalPos] > departure[departurePos]) {
				currentPlatforms--;
				departurePos++;
			}
			else {
				arrivalPos++;
				departurePos++;
			}
		}
		return minRequiredPlatforms;
	}

}

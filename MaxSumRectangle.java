package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSumRectangle {

	public static void main(String[] args) {
		int testcases, row, column, counter;
		int[][] matrix;
		String[] strArr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testcases = Integer.parseInt(br.readLine());
			for(int i=0; i<testcases; i++) {
				strArr = br.readLine().split("\\s+");
				row = Integer.parseInt(strArr[0]);
				column = Integer.parseInt(strArr[1]);
				strArr = br.readLine().split("\\s+");
				matrix = new int[row][column];
				counter = 0;
				for(int j=0; j<row; j++) {
					for(int k=0; k<column; k++) {
						matrix[j][k] = Integer.parseInt(strArr[counter++]);
					}
				}
				System.out.println(findMaxSum(matrix, row, column));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	private static long findMaxSum(int[][] matrix, int row, int column) {
		int count, left = 0, right = 0, up = 0, down = 0, start, end;
		long maxSum = Long.MIN_VALUE, maxSoFar = Long.MIN_VALUE, maxEnding =0;
//		int[] calcArr = new int[row];
		Integer[] calcArr = new Integer[row];
		for(int i=0; i<column; i++) {
			for(int j=i; j<column; j++) {
				count = 0;
				maxSoFar = Long.MIN_VALUE; 
				maxEnding =0;
				start =0;
				end =0;
				for(int k=0; k<row; k++) {
					if(i == j)
						calcArr[count] = matrix[k][j];
					else {
						calcArr[count] += matrix[k][j];
//						++count;
					}
					maxEnding += calcArr[count];
					if(maxSoFar < maxEnding){
						maxSoFar = maxEnding;
						end = count;
					}
					if(maxEnding < 0){
						maxEnding = 0;
						start = count + 1;
					}
					++count;
					
//					System.out.println(k + " " + j);
				}
				if(maxSum < maxSoFar){
					maxSum = maxSoFar;
					left = i;
					right = j;
					up = start;
					down = end;
				}
//				System.out.print(Arrays.stream(calcArr).map(in -> String.valueOf(in)).reduce((f, s) -> f + ", " + s));
//				System.out.println("  -> " + maxSoFar + " - " + maxSum + " : " + left + " - " + right + " - " + up + " - " + down);
			}
		}
		return maxSum;
	}
}

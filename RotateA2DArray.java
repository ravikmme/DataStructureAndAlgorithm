package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateA2DArray {

	public static void main(String[] args) {
		int testCases, length;
		int[][] matrix;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				length = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				matrix = new int[length][length];
				for(int i=0; i<length; i++)
					for(int j=0; j<length; j++)
						matrix[i][j] = Integer.parseInt(tempData[i*length+j]);
				rotateArray(matrix, length);
				for(int i=0; i<length; i++)
					for(int j=0; j<length; j++)
						System.out.print(matrix[i][j] + " ");
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int[][] rotateArray(int[][] matrix, int length) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<length; i++)
			for(int j=0; j<length; j++)
				if(max < matrix[i][j])
					max = matrix[i][j];
		max++;
		for(int i=0; i<length; i++)
			for(int j=0; j<length; j++)
				matrix[i][j] = max *(matrix[length-j-1][i]%max) + matrix[i][j]%max;
		for(int i=0; i<length; i++)
			for(int j=0; j<length; j++)
				matrix[i][j] = matrix[i][j]/max;
		return matrix;
	}

}

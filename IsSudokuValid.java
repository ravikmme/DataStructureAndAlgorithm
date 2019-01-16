package main.java.com.rss.gfg.amazon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IsSudokuValid {

	public static void main(String[] args) {
		int testCases;
		int n =9, m=9;
		int[][] sudokuMatrix = new int[n][m];
		Scanner scan = new Scanner(System.in);
		testCases = scan.nextInt();
		while(testCases-- != 0) {
			for(int i=0; i<n; i++) 
				for(int j=0; j<m; j++) 
					sudokuMatrix[i][j] = scan.nextInt();
			System.out.println(isValid(sudokuMatrix, n, m));
		}
		scan.close();
	}
	
	private static int isValid(int[][] sudokuMatrix, int n, int m) {
		boolean[] columnStatus = new boolean[n];
		boolean columnValid;
		boolean smallMatrixValid;
		for(int i=0; i<n; i++) {
			boolean rowValid = isRowValid(sudokuMatrix, i, m);
			for(int j=0; j<m; j++) {
				if(columnStatus[j] == true)
					columnValid = true;
				else
					columnStatus[j] = columnValid = isColumnValid(sudokuMatrix, i, m);
				if(i % 3 == 0 && j % 3 == 0)
					smallMatrixValid = isSmallMatrixValid(sudokuMatrix, i, j);
				else
					smallMatrixValid = true;
				if(rowValid && columnValid && smallMatrixValid)
					continue;
				else
					return 0;
			}
		}
		return 1;
	}
	
	private static boolean isRowValid(int[][] sudokuMatrix, int row, int noOfColumn) {
		boolean result = true;
		Set<Integer> uniqueEntrySet = new HashSet<>();
		for(int i=0; i<noOfColumn; i++) {
			if(uniqueEntrySet.contains(sudokuMatrix[row][i])) {
				result = false;
				break;
			}
			if(sudokuMatrix[row][i] != 0)
				uniqueEntrySet.add(sudokuMatrix[row][i]);
		}
		return result;
	}
	
	private static boolean isColumnValid(int[][] sudokuMatrix, int column, int noOfRow) {
		boolean result = true;
		Set<Integer> uniqueEntrySet = new HashSet<>();
		for(int i=0; i<noOfRow; i++) {
			if(uniqueEntrySet.contains(sudokuMatrix[i][column])) {
				result = false;
				break;
			}
			if(sudokuMatrix[i][column] != 0)
				uniqueEntrySet.add(sudokuMatrix[i][column]);
		}
		return result;
	}
	
	private static boolean isSmallMatrixValid(int[][] sudokuMatrix, int startRow, int startColumn) {
		boolean result = true;
		Set<Integer> uniqueEntrySet = new HashSet<>();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(uniqueEntrySet.contains(sudokuMatrix[startRow + i][startColumn + j])) {
					result = false;
					break;
				}
				if(sudokuMatrix[startRow + i][startColumn + j] != 0)
					uniqueEntrySet.add(sudokuMatrix[startRow + i][startColumn + j]);
			}
		}
		return result;
	}

}

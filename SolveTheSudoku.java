package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolveTheSudoku {

	public static void main(String[] args) {
		int testCases, matrixSize = 9;
		String[] tempData;
		int[][] arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while (testCases-- > 0) {
				tempData = br.readLine().trim().split("\\s+");
				arr = new int[matrixSize][matrixSize];
				for (int i = 0; i < matrixSize; i++)
					for (int j = 0; j < matrixSize; j++)
						arr[i][j] = Integer.parseInt(tempData[i * matrixSize + j]);
				findSudokuSolution(arr, matrixSize);
				print(arr, matrixSize);
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static int[][] findSudokuSolution(int[][] arr, int matrixSize) {
		int i, j;
		for (i = 0; i < matrixSize; i++) {
			for (j = 0; j < matrixSize; j++) {
				if (arr[i][j] == 0)
					fillPossibleValues(arr, matrixSize, i, j);
			}
		}
		guessValues(arr, matrixSize);
		return arr;
	}

	public static boolean guessValues(int[][] arr, int matrixSize) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				if (arr[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty)
				break;
		}

		if (isEmpty)
			return true;

		Set<Integer> possibleValues;
		possibleValues = possibleNumber(arr, matrixSize, row, col);
		for (Integer eachValue : possibleValues) {
			arr[row][col] = eachValue;
			if (guessValues(arr, matrixSize))
				return true;
			else
				arr[row][col] = 0; // Backtrack
		}
		return false;
	}

	public static Set<Integer> possibleNumber(int[][] arr, int matrixSize, int row, int column) {
		int i, j;
		Set<Integer> possibleValues = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
				.collect(Collectors.toCollection(HashSet::new));
		// Row Check
		for (i = 0; i < matrixSize; i++) {
			if (arr[row][i] != 0)
				possibleValues.remove(arr[row][i]);
		}
		// Column Check
		for (i = 0; i < matrixSize; i++) {
			if (arr[i][column] != 0)
				possibleValues.remove(arr[i][column]);
		}
		// Small Box Check
		int startBoxRow = (row / (matrixSize / 3)) * 3;
		int startBoxColumn = (column / (matrixSize / 3)) * 3;
		for (i = startBoxRow; i < startBoxRow + 3; i++) {
			for (j = startBoxColumn; j < startBoxColumn + 3; j++) {
				if (arr[i][j] != 0)
					possibleValues.remove(arr[i][j]);
			}
		}
		return possibleValues;
	}

	public static void fillPossibleValues(int[][] arr, int matrixSize, int row, int column) {
		int i, j;
		Set<Integer> possibleValues;
		// Row Check
		for (i = 0; i < matrixSize; i++) {
			if (arr[row][i] == 0) {
				possibleValues = possibleNumber(arr, matrixSize, row, i);
				if (possibleValues.size() == 1) {
					arr[row][i] = possibleValues.iterator().next();
					fillPossibleValues(arr, matrixSize, row, i);
				}
			}
		}
		// Column Check
		for (i = 0; i < matrixSize; i++) {
			if (arr[i][column] == 0) {
				possibleValues = possibleNumber(arr, matrixSize, i, column);
				if (possibleValues.size() == 1) {
					arr[i][column] = possibleValues.iterator().next();
					fillPossibleValues(arr, matrixSize, i, column);
				}
			}
		}
		// Small Box Check
		int startBoxRow = (row / (matrixSize / 3)) * 3;
		int startBoxColumn = (column / (matrixSize / 3)) * 3;
		for (i = startBoxRow; i < startBoxRow + 3; i++) {
			for (j = startBoxColumn; j < startBoxColumn + 3; j++) {
				if (arr[i][j] == 0) {
					possibleValues = possibleNumber(arr, matrixSize, i, j);
					if (possibleValues.size() == 1) {
						arr[i][j] = possibleValues.iterator().next();
						fillPossibleValues(arr, matrixSize, i, j);
					}
				}
			}
		}
	}

	public static void print(int[][] arr, int matrixSize) {
		for (int i = 0; i < matrixSize; i++)
			for (int j = 0; j < matrixSize; j++)
				System.out.print(arr[i][j] + " ");
	}
}

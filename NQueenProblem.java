package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

	public static void main(String[] args) {
		int testCases, chessBoardSize;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				chessBoardSize = Integer.parseInt(br.readLine());
				solveNQueenProblem(chessBoardSize);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void solveNQueenProblem(int chessBoardSize) {
		int[][] board = new int[chessBoardSize][chessBoardSize];
		List<Integer> objPositionList = new ArrayList<Integer>() ;
		List<String> result = new ArrayList<String>();
		solveNQueenProblemUtil(board, chessBoardSize, 0, objPositionList, result);
		System.out.println(result.isEmpty() ? -1 : result.stream().reduce((o1, o2) -> o1 + " " + o2).get());
	}
	
	public static boolean solveNQueenProblemUtil(int[][] board, int chessBoardSize, int row, List<Integer> objPositionList, List<String> result) {
		if(row == chessBoardSize) {
			result.add("[" + objPositionList.stream().map(a -> a.toString()).reduce((o1, o2) -> o1 + " " + o2).get() + "]");
			return true;
		}
		for(int i=0; i<chessBoardSize; i++) {
			if(isPostionCorrect(board, chessBoardSize, row, i)) {
				board[row][i] = 1;
				objPositionList.add(i + 1);
				solveNQueenProblemUtil(board, chessBoardSize, row + 1, objPositionList, result);
				board[row][i] = 0;
				objPositionList.remove(objPositionList.size() - 1);
			}
		}
		return false;
	}
	
	public static boolean isPostionCorrect(int[][] board, int chessBoardSize, int row, int column) {
		int i, j;
		for(i=0; i<chessBoardSize; i++)
			if(i != column && board[row][i] == 1)
				return false;
		for(i=0; i<chessBoardSize; i++)
			if(i != row && board[i][column] == 1)
				return false;
		i=row - 1;
		j=column - 1;
		while(i >= 0 && i < chessBoardSize && j >= 0 && j < chessBoardSize) {
			if(board[i][j] == 1)
				return false;
			i--;
			j--;
		}
		i=row + 1;
		j=column + 1;
		while(i >= 0 && i < chessBoardSize && j >= 0 && j < chessBoardSize) {
			if(board[i][j] == 1)
				return false;
			i++;
			j++;
		}
		i=row - 1;
		j=column + 1;
		while(i >= 0 && i < chessBoardSize && j >= 0 && j < chessBoardSize) {
			if(board[i][j] == 1)
				return false;
			i--;
			j++;
		}
		i=row + 1;
		j=column - 1;
		while(i >= 0 && i < chessBoardSize && j >= 0 && j < chessBoardSize) {
			if(board[i][j] == 1)
				return false;
			i++;
			j--;
		}
		return true;
	}
}

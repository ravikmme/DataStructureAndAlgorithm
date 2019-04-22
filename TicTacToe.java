package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

	public static void main(String[] args) {
		int testCases;
		String[] data;
		char[] board;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while (testCases-- > 0) {
				data = br.readLine().split("\\s+");
				board = new char[data.length];
				for(int i=0; i<data.length; i++)
					board[i] = data[i].charAt(0);
				System.out.println(isTicTacToeValid(board) ? "Valid" : "Invalid");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isTicTacToeValid(char[] board) {
		int xCount = 0, oCount = 0;
		for(int i=0; i < board.length; i++) {
			if(board[i] == 'X')
				xCount++;
			if(board[i] == 'O')
				oCount++;
		}
		if (xCount == oCount || xCount == oCount + 1) { 
            if (isWinner(board, 'O')) { 
                if (isWinner(board, 'X')) { 
                    return false; 
                } 
                return (xCount == oCount); 
            } 
            if (isWinner(board, 'X') && xCount != oCount + 1) { 
                return false; 
            } 
            return true; 
        }
		return false;
	}

	public static boolean isWinner(char[] board, char c) {
		int winnerPostion[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, 
				{ 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };
		for (int i = 0; i < 8; i++) { 
            if (board[winnerPostion[i][0]] == c && board[winnerPostion[i][1]] == c 
                    && board[winnerPostion[i][2]] == c) { 
                return true; 
            } 
        } 
        return false; 
	}

}

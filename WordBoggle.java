package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WordBoggle {
	
	static class BooleanFlag {
		boolean flag = false;
	}
	private static List<String> dictionary;
	public static void main(String[] args) {
		int testCases, noOfWords, row, column, count;
		char[][] charArr;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- != 0) {
				noOfWords = Integer.parseInt(br.readLine());
				dictionary = new ArrayList<>();
				tempData = br.readLine().split("\\s+");
				for(int i=0; i<noOfWords; i++)
					dictionary.add(tempData[i]);
				tempData = br.readLine().split("\\s+");
				row = Integer.parseInt(tempData[0]);
				column = Integer.parseInt(tempData[1]);
				charArr = new char[row][column];
				tempData = br.readLine().split("\\s+");
				count = 0;
				for(int i=0; i<row; i++)
					for(int j=0; j<column; j++)
						charArr[i][j] = tempData[count++].charAt(0);
				findWord(charArr, row, column);
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	private static void findWord(char[][] charArr, int row, int column) {
		String word;
		boolean[][] visited;
		BooleanFlag objBooleanFlag;
		Set<String> sortedSet = new TreeSet<>();
		for(int i=0; i<dictionary.size(); i++) {
			word = dictionary.get(i);
			objBooleanFlag = new BooleanFlag();
			for(int j=0; j<row; j++) {
				for(int k=0; k<column; k++) {
					if(charArr[j][k] == word.charAt(0)){
						visited = new boolean[row][column];
						visited[j][k] = true;
						findWordUtil(charArr, row, column, j, k, 1, word, visited, objBooleanFlag);
						if(objBooleanFlag.flag){
							sortedSet.add(word);
							break;
						}
					}
				}
				if(objBooleanFlag.flag)
					break;
			}
		}
		if(sortedSet.size() > 0)
		    System.out.print(sortedSet.stream().reduce((word1, word2) -> word1 + " " + word2).get());
		else
		    System.out.print("-1");
	}
	
	private static void findWordUtil(char[][] charArr, int row, int column, int xPos, int yPos, int index, String word, boolean[][] visited, BooleanFlag objBooleanFlag) {
		if(index == word.length()){
			objBooleanFlag.flag = true;
//			System.out.print(word + " ");
			return;
		}
		int[] xPath = new int[]{-1, 0, 1, 0, -1, -1, 1, 1};
		int[] yPath = new int[]{0, 1, 0, -1, -1, 1, 1, -1};
		for(int i=0; i<xPath.length; i++){
			if(xPos + xPath[i] >= 0 && xPos + xPath[i] < row 
					&& yPos + yPath[i] >= 0 && yPos + yPath[i] < column 
					&& visited[xPos + xPath[i]][yPos + yPath[i]] == false 
					&& charArr[xPos + xPath[i]][yPos + yPath[i]] == word.charAt(index)) {
				visited[xPos + xPath[i]][yPos + yPath[i]] = true;
				findWordUtil(charArr, row, column, xPos + xPath[i], yPos + yPath[i], ++index, word, visited, objBooleanFlag);
				if(objBooleanFlag.flag)
					break;
				--index;
			}
		}
		
	}
}

package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

	public static void main(String[] args) {
		int testcases, row, column, elementLen;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testcases = Integer.parseInt(br.readLine());
			String[] dimensionStr, elementsStr;
			int[][] matrix;
			for(int i=0; i<testcases; i++) {
				dimensionStr = br.readLine().split("\\s+");
				row = Integer.parseInt(dimensionStr[0]);
				column = Integer.parseInt(dimensionStr[1]);
				matrix = new int[row][column];
				elementsStr = br.readLine().split("\\s+");
				elementLen = 0;
				for(int j=0; j<row; j++) {
					for(int k=0; k<column; k++) {
						matrix[j][k] = Integer.parseInt(elementsStr[elementLen++]);
					}
				}
				System.out.println(findStepToRot(matrix, row, column));
//				System.out.println(surroundZero(matrix, row, column));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*private static Element surroundZero(int[][] matrix, int row, int column) {
		List<Element> aroundCell;
		Element cell = null;
		boolean zeroFlag = true;
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				if(matrix[i][j]==1){
					aroundCell = aroundCell(i, j);
					zeroFlag = true;
					for(Element eachElement : aroundCell){
						cell = eachElement;
						if(isValid(row, column, eachElement.x, eachElement.y) && matrix[eachElement.x][eachElement.y] == 0) {
							continue;
						}
						else if(isValid(row, column, eachElement.x, eachElement.y) && matrix[eachElement.x][eachElement.y] != 0){
							zeroFlag = false;
						}
					}
					if(zeroFlag==true)
						return new Element(i, j);
				}
			}
		}
		return new Element(-1, -1);
	}*/
	
	private static int findStepToRot(int[][] matrix, int row, int column) {
		int timeTaken = 0;
		boolean rotFlag = false;
		Element element;
//		Element prev = new Element(-1, -1);
		List<Element> objElementList;
		Queue<Element> objQueue =  new LinkedList<>();
		boolean[][] visitedCell = new boolean[row][column]; 
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				if(matrix[i][j] == 2)
					objQueue.add(new Element(i, j));
			}
		}
		objQueue.add(new Element(-1, -1));
		while(!objQueue.isEmpty()) {
			element = objQueue.poll();
			if(isValid(row, column, element.x, element.y)){
				visitedCell[element.x][element.y] = true;
				objElementList = aroundCell(element.x, element.y);
				for(Element eachElement : objElementList) {
					if(isValid(row, column, eachElement.x, eachElement.y) 
							&& visitedCell[eachElement.x][eachElement.y] == false 
							&& matrix[eachElement.x][eachElement.y] == 1) {
						rotFlag = true;
						matrix[eachElement.x][eachElement.y] = 2;
						objQueue.add(new Element(eachElement.x, eachElement.y));
					}
				}
			}
			else {
				if(!objQueue.isEmpty()){
					objQueue.add(new Element(-1, -1));
					++timeTaken;
				}
				rotFlag = false;
			}
		}
		if(rotFlag)
			++timeTaken;
		return checkContent(matrix, row, column, 1) ? timeTaken : -1;
	}
	
	private static boolean checkContent(int matrix[][], int row, int col, int digit) {
		boolean contentFlag = true;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++){
				if(matrix[i][j] == digit){
					contentFlag = false;
					break;
				}
			}
			if(!contentFlag)
				break;
		}
		return contentFlag;
	}
	
	private static boolean isValid(int matrixRow, int matrixCol, int row, int col) {
		boolean validFlag = false;
		if(row >= 0 && row < matrixRow && col >= 0 && col <matrixCol)
			validFlag = true;
		return validFlag;
	}
	
	private static List<Element> aroundCell(int row, int col) {
		int[] dx = new int[]{-1, 1, 0, 0};
		int[] dy = new int[]{0, 0, -1, 1};
		List<Element> objElementList = new ArrayList<>();
		for(int i=0; i<dx.length; i++) {
			objElementList.add(new Element(row + dx[i], col + dy[i]));
		}
		return objElementList;
	}
}

class Element {
	int x;
	int y;
	public Element(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Element [x=" + x + ", y=" + y + "]";
	}
	
	
}
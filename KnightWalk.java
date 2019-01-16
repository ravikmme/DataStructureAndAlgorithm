package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KnightWalk {

	static int[] xPath = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
	static int[] yPath = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
	public static void main(String[] args) {
		int testCases, row, column, sourceRow, sourceColumn, desRow, desColumn;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- != 0) {
				tempData = br.readLine().split("\\s+");
				row = Integer.parseInt(tempData[0]);
				column = Integer.parseInt(tempData[1]);
				tempData = br.readLine().split("\\s+");
				sourceRow = Integer.parseInt(tempData[0]);
				sourceColumn = Integer.parseInt(tempData[1]);
				desRow = Integer.parseInt(tempData[2]);
				desColumn = Integer.parseInt(tempData[3]);
				System.out.println(findStep(row, column, sourceRow, sourceColumn, desRow, desColumn));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int findStep(int row, int column, int xSource, int ySource, int xDes, int yDes) {
		int step = 0;
		int xAxis, yAxis, xOffset, yOffset, x, y;
		List<Integer> objCoordinate;
		Queue<List<Integer>> bfsQueue = new LinkedList<>();
		boolean[][] visited = new boolean[row][column];
		if(xSource == xDes && ySource == yDes)
		    return 0;
		bfsQueue.add(Arrays.asList(xSource, ySource));
		bfsQueue.add(null);
		while(!bfsQueue.isEmpty()) {
			objCoordinate = bfsQueue.poll();
			if(objCoordinate == null) {
				if(bfsQueue.size() > 0) {
					++step;
					bfsQueue.add(null);
					continue;
				}
				break;
			}
			xAxis = objCoordinate.get(0);
			yAxis = objCoordinate.get(1);
			for(int i=0; i<xPath.length; i++) {
				xOffset = xPath[i];
				yOffset = yPath[i];
				x = xAxis + xOffset;
				y = yAxis + yOffset;
				if(x > 0 && x <= row 
						&& y > 0 && y <= column 
						&& visited[x - 1][y - 1] == false) {
					if(x == xDes && y == yDes) {
						return ++step;
					}
					bfsQueue.add(Arrays.asList(x, y));
				}
			}
			visited[xAxis - 1][yAxis - 1] = true;
		}
		return -1;
	}
}

package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {

	public static void main(String[] args) {
		int testCases, n;
		String[] knightPosStrArr, targetPosStrArr;
		int[] knightPos, targetPos;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			for(int i=0; i<testCases; i++) {
				
				n = Integer.parseInt(br.readLine());
				knightPosStrArr = br.readLine().split("\\s+");
				knightPos = new int[] {Integer.parseInt(knightPosStrArr[0]), 
						Integer.parseInt(knightPosStrArr[1])};
				targetPosStrArr = br.readLine().split("\\s+");
				targetPos = new int[] {Integer.parseInt(targetPosStrArr[0]), 
						Integer.parseInt(targetPosStrArr[1])};
				
				System.out.println(findMinStep(knightPos, targetPos, n));
				
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int findMinStep(int[] knightPos, int[] targetPos, int n) {
		int desX, desY;
		Cell frontElement;
		Queue<Cell> objQueue = new LinkedList<>();
		boolean[][] visitedNode = new boolean[n][n];
		int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2}; 
	    int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	    objQueue.add(new Cell(knightPos[0], knightPos[1], 0));
	    visitedNode[knightPos[0] - 1][knightPos[1] - 1] = true;
	    
	    while(!objQueue.isEmpty()) {
	    	frontElement = objQueue.poll();
	    	
	    	if(frontElement.x == targetPos[0] && frontElement.y == targetPos[1])
	    		return frontElement.dis;
	    	
	    	for(int i=1; i<=dx.length; i++) {
	    		desX = frontElement.x + dx[i-1];
	    		desY = frontElement.y + dy[i-1];
	    		if(desX > 0 && desX <= n && desY > 0 && desY <= n && visitedNode[desX - 1][desY - 1] == false) {
	    			objQueue.add(new Cell(desX, desY, frontElement.dis + 1));
	    			visitedNode[desX - 1][desY - 1] = true;
	    			
	    		}
	    	}
	    	
	    }
		return 0;
	}

}

class Cell {
	int x;
	int y;
	int dis;
	public Cell(int x, int y, int dis) {
		super();
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
	
}
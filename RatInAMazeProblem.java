package main.java.com.rss.gfg.amazon;

import java.util.*;
public class RatInAMazeProblem {
	
	static int[] xPath = new int[]{-1, 1, 0, 0};
	static int[] yPath = new int[]{0, 0, -1, 1};
	static char[] direction = new char[]{'U', 'D', 'L', 'R'};
	static ArrayList<String> objPathList = new ArrayList<>();
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j]=sc.nextInt();
			ArrayList<String> res=printPath(a,n);
			for(int i=0;i<res.size();i++)
				System.out.print(res.get(i)+" ");
			System.out.println();
		}
		sc.close();
	}
	
	public static ArrayList<String> printPath(int[][] m, int n)
	{
		boolean[][] visited = new boolean[n][n];
		visited[0][0] = true;
		objPathList = new ArrayList<>();
		findMazePath(m, n, visited, 0, 0, "");
		Collections.sort(objPathList);
		return objPathList;
	}
	
	private static boolean findMazePath(int[][] matrix, int matrixSize, boolean[][] visited, int x, int y, String path) {
		boolean pathFoundFlag = false;
		int xCoordinate, yCoordinate;
		for(int i=0; i<xPath.length; i++) {
			xCoordinate = x + xPath[i];
			yCoordinate = y + yPath[i];
			if(isCoordinateValid(matrixSize, xCoordinate, yCoordinate) 
					&& visited[xCoordinate][yCoordinate] == false 
					&& matrix[xCoordinate][yCoordinate] == 1) {
				path = path + direction[i];
				visited[xCoordinate][yCoordinate] = true;
				if(xCoordinate == matrixSize - 1 && yCoordinate == matrixSize - 1){
					objPathList.add(path);
					visited[xCoordinate][xCoordinate] = false;
					return true;
				}
				else
					pathFoundFlag = findMazePath(matrix, matrixSize, visited, xCoordinate, yCoordinate, path);
				path = path.substring(0, path.length() - 1);
				visited[xCoordinate][yCoordinate] = false;
			}
		}
		
		return pathFoundFlag;
	}
	
	private static boolean isCoordinateValid(int matrixSize, int x, int y) {
		boolean validFlag = false;
		if(x >= 0 && x < matrixSize && y >=0 && y < matrixSize)
			validFlag = true;
		return validFlag;
	}
}

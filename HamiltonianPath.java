package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HamiltonianPath {
	
	static class TotalVisitedVertex {
		int visitedNode = 1;
	}

	public static void main(String[] args) {
		int testCases, vertices, edges;
		int[][] graph;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- != 0) {
				tempData = br.readLine().split("\\s+");
				vertices = Integer.parseInt(tempData[0]);
				edges = Integer.parseInt(tempData[1]);
				graph = new int[vertices][vertices];
				tempData = br.readLine().split("\\s+");
				for(int i=0; i<edges; i++){
					graph[Integer.parseInt(tempData[i * 2]) - 1][Integer.parseInt(tempData[i * 2 + 1]) - 1] = 1;
					graph[Integer.parseInt(tempData[i * 2 + 1]) - 1][Integer.parseInt(tempData[i * 2]) - 1] = 1;
				}
				System.out.println(findHamilPath(graph, vertices));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static int findHamilPath(int[][] graph, int vertices) {
		boolean[] visited;
		TotalVisitedVertex objTotalVisitedVertex;
		for(int i=0; i<vertices; i++) {
			visited = new boolean[vertices];
			visited[i] = true;
			objTotalVisitedVertex = new TotalVisitedVertex();
			if(findHamilPathUtil(graph, vertices, i, visited, objTotalVisitedVertex))
				return 1;
		}
		return 0;
	}
	
	private static boolean findHamilPathUtil(int[][] graph, int vertices, int startVertex, boolean[] visited, TotalVisitedVertex objTotalVisitedVertex) {
		boolean pathFlag = false;
		
		for(int i=0; i<vertices; i++) {
			if(objTotalVisitedVertex.visitedNode == vertices)
				return true;
			else{
				if(visited[i] == false && graph[startVertex][i] == 1){
					++objTotalVisitedVertex.visitedNode;
					visited[i] = true;
					pathFlag = findHamilPathUtil(graph, vertices, i, visited, objTotalVisitedVertex);
					if(!pathFlag) {
						visited[i] = false;
						--objTotalVisitedVertex.visitedNode;
					}
				}
			}
			
		}
		return pathFlag;
	}

}

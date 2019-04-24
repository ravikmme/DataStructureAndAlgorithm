package main.java.com.rss.walmart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {
	
	static class Graph {
		LinkedList<Integer>[] adjacencyMatrix;
		@SuppressWarnings("unchecked")
		public Graph(int noOfVertices) {
			adjacencyMatrix = new LinkedList[noOfVertices];
			for(int i=0; i<noOfVertices; i++)
				adjacencyMatrix[i] = new LinkedList<Integer>();
		}
		
		public void addEdge(int fromVertex, int toVertex) {
			adjacencyMatrix[fromVertex].add(toVertex);
		}
		
		public void topologicalSort() {
			Set<Integer> visited = new HashSet<>();
			Stack<Integer> objStack = new Stack<>();
			for(int i=0; i<adjacencyMatrix.length; i++) {
				if(!visited.contains(i))
					topologicalSortUtil(i, visited, objStack);
			}
			while(!objStack.isEmpty())
				System.out.print((char)('a' + objStack.pop()) + " ");
		}
		
		public void topologicalSortUtil(int index, Set<Integer> visited, Stack<Integer> objStack) {
			visited.add(index);
			for(int i=0; i<adjacencyMatrix[index].size(); i++) {
				if(visited.contains(adjacencyMatrix[index].get(i)))
					continue;
				topologicalSortUtil(adjacencyMatrix[index].get(i), visited, objStack);
			}
			objStack.add(index);
		}
		
	}
	
	public static void findOrder(String[] dictionary, int noOfWords, int noOfLetters) {
		String firstWord, secondWord;
		Graph objGraph = new Graph(noOfLetters);
		for(int i=0; i<noOfWords-1; i++) {
			firstWord = dictionary[i];
			secondWord = dictionary[i+1];
			for(int j=0; j<Math.min(firstWord.length(), secondWord.length()); j++) {
				if(firstWord.charAt(j) != secondWord.charAt(j)) {
					objGraph.addEdge(firstWord.charAt(j) - 'a', secondWord.charAt(j) - 'a');
					break;
				}
			}
		}
		objGraph.topologicalSort();
	}

	public static void main(String[] args) {
		int testCases, noOfWords, noOfLetters;
		String[] tempData, dictionary;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				tempData = br.readLine().split("\\s+");
				noOfWords = Integer.parseInt(tempData[0]);
				noOfLetters = Integer.parseInt(tempData[1]);
				dictionary = br.readLine().split("\\s+");
				findOrder(dictionary, noOfWords, noOfLetters);
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}

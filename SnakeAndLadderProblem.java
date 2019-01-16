package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderProblem {
	
//	private static int row = 5;
//	private static int column = 6;
	private static int source = 1;
	private static int destination = 30;

	public static void main(String[] args) {
		int testCases, noOfSnakeLadder, n, m;
		String[] tempData;
		List<List<Integer>> objLadderList, objSnakeList;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- != 0) {
				noOfSnakeLadder = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				objLadderList = new ArrayList<>();
				objSnakeList = new ArrayList<>();
				for(int i=0; i<noOfSnakeLadder; i++) {
					n = Integer.parseInt(tempData[i * 2]);
					m = Integer.parseInt(tempData[i * 2 + 1]);
					if(n < m)
						objLadderList.add(Arrays.asList(n, m));
					else
						objSnakeList.add(Arrays.asList(n, m));
				}
				System.out.println(findMinStep(objLadderList, objSnakeList));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int findMinStep(List<List<Integer>> objLadderList, List<List<Integer>> objSnakeList) {
		int minStep = 0, breadthSize, indexSeek, ladderSeek, snakeSeek;
//		boolean destinationFound = false;
		Integer presentIndex;
		boolean[] visited = new boolean[destination];
		Queue<Integer> bfsQueue = new LinkedList<>();
		bfsQueue.add(source);
		while(!bfsQueue.isEmpty()) {
			breadthSize = bfsQueue.size();
			while(breadthSize-- != 0) {
				presentIndex = bfsQueue.poll();
				for(int i=1; i<=6; i++) {
					indexSeek = presentIndex + i;
					while(visited[indexSeek - 1] == false && (changeIndex(objLadderList, indexSeek) != 0 || changeIndex(objSnakeList, indexSeek) != 0)) {
						ladderSeek = changeIndex(objLadderList, indexSeek);
						snakeSeek = changeIndex(objSnakeList, indexSeek);
						if(ladderSeek != 0)
							indexSeek = ladderSeek;
						else {
							indexSeek = snakeSeek;
							visited[indexSeek - 1] = false;
						}
					}
					if(indexSeek == destination)
						return ++minStep;
					if(indexSeek <= destination && visited[indexSeek - 1] == false)
						bfsQueue.add(indexSeek);
				}
				visited[presentIndex - 1] = true;
			}
			++minStep;
		}
		return -1;
		
	}
	
	private static int changeIndex(List<List<Integer>> objIntList, int presentIndex) {
		int nextIndex =0;
		for(List<Integer> eachList : objIntList) {
			if(eachList.get(0) == presentIndex) {
				nextIndex = eachList.get(1);
				break;
			}
		}
		return nextIndex;
	}

}
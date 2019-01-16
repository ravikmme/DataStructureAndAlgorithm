package main.java.com.rss.gfg.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestRangeInKLists {

	public static void main(String[] args) {
		int[][] arrElement = {{4, 7, 9, 12, 15}, {0, 8, 10, 14, 20}, {6, 12, 16, 30, 50}};
//		int[][] arrElement = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//		int[][] arrElement = {{1, 3, 5, 7, 9}, {0, 2, 4, 6, 8}, {2, 3, 5, 7, 11}};
		int row = arrElement.length;
		int[] pointerArr = new int[row];
		int[] pointerLength = new int[row];
		int min = 0, max = 0, tempRange, minElementRow;
		Integer pointerMax = Integer.MIN_VALUE;
		Integer range = Integer.MAX_VALUE;

		for(int i=0; i < row; i++) {
			pointerLength[i] = arrElement[i].length;
		}

		PriorityQueue<Integer> objPQ = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer firstRowIndex, Integer secondRowIndex) {
				return arrElement[firstRowIndex][pointerArr[firstRowIndex]] - arrElement[secondRowIndex][pointerArr[secondRowIndex]];
			}
		});

		for(int i=0; i<row; i++) {
			if(pointerMax < arrElement[i][pointerArr[i]])
				pointerMax = arrElement[i][pointerArr[i]];
			objPQ.add(i);
		}

		while(true) {
			minElementRow = objPQ.poll();
			tempRange = pointerMax - arrElement[minElementRow][pointerArr[minElementRow]];
			if(range > tempRange) {
				range = tempRange;
				min = arrElement[minElementRow][pointerArr[minElementRow]];
				max = pointerMax;
			}
			++pointerArr[minElementRow];
			if(pointerArr[minElementRow] < pointerLength[minElementRow]) {
				if(pointerMax < arrElement[minElementRow][pointerArr[minElementRow]])
					pointerMax = arrElement[minElementRow][pointerArr[minElementRow]];
				objPQ.add(minElementRow);
			}
			else
				break;
		}
		System.out.println(min + " - " + max);
	}
}

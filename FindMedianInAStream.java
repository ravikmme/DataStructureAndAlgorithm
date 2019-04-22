package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInAStream {

	public static void main(String[] args) {
		int noOfElements, elementData;
		PriorityQueue<Integer> minPq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxPq = new PriorityQueue<Integer>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			noOfElements = Integer.parseInt(br.readLine());
			for(int i=0; i<noOfElements; i++) {
				elementData = Integer.parseInt(br.readLine().trim()	);
				System.out.println(findMedian(minPq, maxPq, elementData));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int findMedian(PriorityQueue<Integer> minPq, PriorityQueue<Integer> maxPq, int data) {
		minPq.add(data);
		maxPq.add(minPq.poll());
		if(minPq.size() < maxPq.size())
			minPq.add(maxPq.poll());
		if(minPq.size() > maxPq.size())
			return minPq.peek();
		else
			return (minPq.peek() + maxPq.peek()) / 2;
	}

}

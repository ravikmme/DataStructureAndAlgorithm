package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervals {

	static class Pair {
		int start;
		int end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return start + " " + end;
		}
		
	}

	public static void main(String[] args) {
		int testCases, noOfElements;
		String[] tempdata;
		Pair[] objPair;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while (testCases-- > 0) {
				noOfElements = Integer.parseInt(br.readLine());
				tempdata = br.readLine().split("\\s+");
				objPair = new Pair[noOfElements];
				for (int i = 0; i < noOfElements; i++)
					objPair[i] = new Pair(Integer.parseInt(tempdata[i * 2]), Integer.parseInt(tempdata[i * 2 + 1]));
				System.out.println(findOverlappingInterval(objPair, noOfElements));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static String findOverlappingInterval(Pair[] objPair, int noOfElements) {
		int startPoint, endPoint;
		List<Pair> resultPair = new ArrayList<>();
		Arrays.sort(objPair, (objFirst, objSecond) -> {
			if (objFirst.start != objSecond.start)
				return objFirst.start - objSecond.start;
			else
				return objFirst.end - objSecond.end;
		});
		startPoint = objPair[0].start;
		endPoint = objPair[0].end;
		for(int i=1; i<noOfElements; i++) {
			if(endPoint >= objPair[i].start)
				endPoint = Math.max(endPoint, objPair[i].end);
			else {
				resultPair.add(new Pair(startPoint,endPoint));
				startPoint = objPair[i].start;
				endPoint = objPair[i].end;
			}
		}
		resultPair.add(new Pair(startPoint,endPoint));
		return resultPair.stream().map(a-> a.toString()).reduce((o1, o2) -> o1 + " " + o2).get();
	}

}

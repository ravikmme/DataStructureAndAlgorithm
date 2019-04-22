package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumberFormedFromArray {

	public static void main(String[] args) {
		int testCases;
		String[] tempData;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					int lengthO1 = o1.length(); 
					int lengthO2 = o2.length(); 
					int minLength = Math.min(lengthO1, lengthO2);
					for(int i=0; i<minLength; i++) {
						if(o1.charAt(i) != o2.charAt(i))
							return o2.charAt(i) - o1.charAt(i);
					}
					if(lengthO1 == lengthO2) {
						return 0;
					}
					else if(lengthO1 > lengthO2) {
						o1 = o1.substring(lengthO2);
						return compare(o1, o2);
					}
					else{
						o2 = o2.substring(lengthO1);
						return compare(o1, o2);
					}
				}
			});
			while(testCases-- > 0) {
				br.readLine();
				tempData = br.readLine().split("\\s+");
				for(String eachString : tempData)
					pq.add(eachString);
				StringBuilder strBuilder = new StringBuilder();
				while(!pq.isEmpty())
					strBuilder.append(pq.poll());
				System.out.println(strBuilder.toString());
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}

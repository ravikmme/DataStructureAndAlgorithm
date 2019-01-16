package main.java.com.rss.gfg.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RearrangeCharacters {

	public static void main(String[] args) {
		int testCases;
		String str;
		Scanner scan = new Scanner(System.in);
		testCases = scan.nextInt();
		while(testCases-- != 0) {
			str = scan.next();
			System.out.println(jumbleChar(str));
		}
		scan.close();
	}

	private static int jumbleChar(String str) {
		class KeyPQ {
			char c;
			int count;
			public KeyPQ(char c, int count) {
				super();
				this.c = c;
				this.count = count;
			}
			@Override
			public String toString() {
				return "KeyPQ [c=" + c + ", count=" + count + "]";
			}
		}
		int result = 1;
		int maxSize = 26;
		int[] occurrence = new int[maxSize];
		KeyPQ prevKey, presentKey;
		StringBuilder strBuild = new StringBuilder();
		PriorityQueue<KeyPQ> pq = new PriorityQueue<>(new Comparator<KeyPQ>() {

			@Override
			public int compare(KeyPQ o1, KeyPQ o2) {
				return o2.count - o1.count;
			}
		});
		for(int i=0; i<str.length(); i++)
			occurrence[str.charAt(i) - 'a']++;
		for(int i=0; i<occurrence.length; i++) {
			if(occurrence[i] > 0) {
				pq.add(new KeyPQ((char)('a' + i), occurrence[i]));
			}
		}
		prevKey = new KeyPQ('-', -1);
		while(!pq.isEmpty()) {
			presentKey = pq.poll();
			strBuild.append(presentKey.c);
			if(prevKey.count > 0){
				pq.add(prevKey);
			}
			presentKey.count--;
			prevKey = presentKey;
		}
		if(strBuild.length() != str.length())
			result = 0;
		return result;
	}
}

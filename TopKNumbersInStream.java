package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class TopKNumbersInStream {

	public static void main(String[] args) {
		int testCases, n, k;
		int[] arr;
		String[] strArr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			for(int i=0; i<testCases; i++) {
				strArr = br.readLine().split("\\s+");
				n = Integer.parseInt(strArr[0]);
				k = Integer.parseInt(strArr[1]);
				strArr = br.readLine().split("\\s+");
				arr = Arrays.stream(strArr).mapToInt(a->Integer.parseInt(a)).toArray();
				printTopKElement(arr, n, k);
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void printTopKElement(int[] arr, int n, int k) {
		int freq, counter;
		Iterator<Integer> iteratorMap;
		Map<Integer, Integer> objKVMap = new HashMap<>();
		StringBuilder strBuild = new StringBuilder();
		SortedMap<Integer, Integer> objSortedMap = new TreeMap<>(new FreqCompare(objKVMap));
		for(int i=0; i<n; i++) {
			if(objKVMap.containsKey(arr[i])) {
				freq = objKVMap.get(arr[i]) + 1;
				objSortedMap.remove(arr[i]);
				objKVMap.put(arr[i], freq);
			}
			else {
				freq = 1;
				objKVMap.put(arr[i], freq);
			}
			objSortedMap.put(arr[i], freq);
			counter = 0;
			iteratorMap = objSortedMap.keySet().iterator();
			while(iteratorMap.hasNext() && counter < k) {
				strBuild.append(iteratorMap.next()).append(" ");
//				System.out.print(iteratorMap.next() + " ");
				++counter;
			}
			strBuild.append("\n");
		}
		File file = new File("E:\\Workspaces\\Gfg\\ProblemSolving\\resources\\StrResult1.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(strBuild.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class FreqCompare implements Comparator<Integer> {
	Map<Integer, Integer> objMap;

	public FreqCompare(Map<Integer, Integer> objMap) {
		super();
		this.objMap = objMap;
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		Integer o1Freq= this.objMap.get(o1);
		Integer o2Freq= this.objMap.get(o2);
		if(o1Freq == o2Freq)
			return o1-o2;
		else
			return o2Freq - o1Freq;
	}

}

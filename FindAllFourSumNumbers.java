package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FindAllFourSumNumbers {

	public static void main(String[] args) {
		int testCases, noOfElements, sum;
		int[] arr;
		String[] strArr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- != 0) {
				strArr = br.readLine().split("\\s+");
				noOfElements = Integer.parseInt(strArr[0]);
				sum = Integer.parseInt(strArr[1]);
				arr = new int[noOfElements];
				strArr = br.readLine().split("\\s+");
				for(int i=0; i<noOfElements; i++) {
					arr[i] = Integer.parseInt(strArr[i]);
				}
//				findFourSum(arr, noOfElements, sum);
				findFourSumNonRec(arr, noOfElements, sum);
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void findFourSumNonRec(int[] arr, int noOfElements, int sum) {
		class Pair {
			int firstIndex;
			int secondIndex;
			public Pair(int firstIndex, int secondIndex) {
				this.firstIndex = firstIndex;
				this.secondIndex = secondIndex;
			}
		}
//		Pair objPair;
		List<Integer> arrNew;
		List<Pair> pairList;
		String str;
		Set<String> strSet = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] firstArr = o1.split(" ");
				String[] secondArr = o2.split(" ");
				for(int i=0; i<firstArr.length; i++) {
					if(Integer.parseInt(firstArr[i]) > Integer.parseInt(secondArr[i]))
						return 1;
					else if(Integer.parseInt(firstArr[i]) < Integer.parseInt(secondArr[i]))
						return -1;
					else 
						continue;
				}
				return 0;
			}
		});
		Map<Integer, List<Pair>> objSumMap = new HashMap<>();
		for(int i=0; i<noOfElements-1; i++)
			for(int j=i+1; j<noOfElements; j++) {
				if(objSumMap.containsKey(arr[i] + arr[j])) {
					pairList = objSumMap.get(arr[i] + arr[j]);
					pairList.add(new Pair(i, j));
					objSumMap.put(arr[i] + arr[j], pairList);
				}
				else{
					pairList = new ArrayList<>();
					pairList.add(new Pair(i, j));
					objSumMap.put(arr[i] + arr[j], pairList);
				}
			}
		
		for(int i=0; i<noOfElements-1; i++) {
			for(int j=i+1; j<noOfElements; j++) {
				if(objSumMap.containsKey(sum - (arr[i] + arr[j]))) {
					pairList = objSumMap.get(sum - (arr[i] + arr[j]));
					for(Pair objPair : pairList) {
						if(objPair.firstIndex != i && objPair.firstIndex != j 
								&& objPair.secondIndex  != i && objPair.secondIndex != j) {
							arrNew = Arrays.asList(arr[i], arr[j] , arr[objPair.firstIndex], arr[objPair.secondIndex]);
							Collections.sort(arrNew);
//							for(int eachInt : arrNew)
//								System.out.print(eachInt + " ");
//							System.out.print("$");
						str = arrNew.stream().map(a -> String.valueOf(a)).reduce((word1, word2) -> word1 + " " + word2).get();
						if(!strSet.contains(str)) {
							strSet.add(str);
//							System.out.print(str);
//							System.out.print(" $");
						}
						
						}
					}
				}
			}
		}
		if(strSet.size()==0)
			System.out.print("-1");
		else if(strSet.size()==1) {
			System.out.print(strSet.stream().map(a -> a).reduce((word1, word2) -> word1 + " $" + word2).get());
			System.out.print(" $");
		}
		else{
			System.out.print(strSet.stream().map(a -> a).reduce((word1, word2) -> word1 + " $" + word2).get());
			System.out.print(" $");
		}
	}

	/*private static void findFourSum(int[] arr, int noOfElements, int sum) {
		List<Integer> objIntList = new ArrayList<>();
		Arrays.sort(arr);
		findFourSumUtil(arr, noOfElements, sum, 0, objIntList, new HashSet<String>());
	}

	private static void findFourSumUtil(int[] arr, int noOfElements, int sum, int index, List<Integer> objIntList, Set<String> strSet) {
		if(objIntList.size() == 4) {
			if(objIntList.stream().mapToInt(a -> a).sum() == sum){
				String string = objIntList.stream().map(a -> a.toString()).reduce((word1, word2) -> word1 + " " + word2).get();
				if(!strSet.contains(string)){
					strSet.add(string);
					System.out.print(string + " $");
				}
				return;
			}
		}
		if(index == noOfElements)
			return;
		List<Integer> objInclude = new ArrayList<>();
		List<Integer> objExclude = new ArrayList<>();
		objInclude.addAll(objIntList);
		objInclude.add(arr[index]);
		objExclude.addAll(objIntList);
		findFourSumUtil(arr, noOfElements, sum, index+1, objInclude, strSet);
		findFourSumUtil(arr, noOfElements, sum, index+1, objExclude, strSet);
	}*/

}

package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SteppingNumbers {

	public static void main(String[] args) {
		int testCases, n, m;
		String[] arrString;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			for(int i=0; i<testCases; i++) {
				arrString = br.readLine().split("\\s+");
				n = Integer.parseInt(arrString[0]);
				m = Integer.parseInt(arrString[1]);
				System.out.println(findSteppingNumbersBfs(n, m).size());
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private static List<Integer> findSteppingNumbersBfs(int n, int m) {
		List<Integer> stepNumList = new ArrayList<>();
		for(int i=0; i<=9; i++)
			stepNumList.addAll(steppingNumbersUtil(n, m, i));
		return stepNumList;
	}
	
	private static List<Integer> steppingNumbersUtil(int n, int m, int num) {
		int stepNum, rem, stepNumPlus, stepNumMinus;
		List<Integer> stepNumList = new ArrayList<>();
		Queue<Integer>  stepNumQueue = new LinkedList<>();
		stepNumQueue.add(num);
		
		while(!stepNumQueue.isEmpty()) {
			stepNum = stepNumQueue.poll();
			if(stepNum >= n && stepNum <= m)
				stepNumList.add(stepNum);
			if(stepNum == 0 || stepNum > m)
				continue;
			rem = stepNum % 10;
			stepNumPlus = stepNum * 10 + rem + 1;
			stepNumMinus = stepNum * 10 + rem - 1;
			if(rem == 0)
				stepNumQueue.add(stepNumPlus);
			else if(rem == 9)
				stepNumQueue.add(stepNumMinus);
			else {	
				stepNumQueue.add(stepNumMinus);
				stepNumQueue.add(stepNumPlus);
			}
		}
		return stepNumList;
	}

}

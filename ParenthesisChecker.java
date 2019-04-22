package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParenthesisChecker {

	public static void main(String[] args) {
		int testCases;
		String data;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				data = br.readLine().trim();
				System.out.println(checkParanthesis(data.toCharArray()));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String checkParanthesis(char[] data) {
		Stack<Character> objStack = new Stack<Character>();
		for(int i=0; i<data.length; i++) {
			if(data[i] == '[' || data[i] == '{' || data[i] == '(')
				objStack.push(data[i]);
			else {
				if(objStack.size() > 0 && matchParanthesis(objStack.peek(), data[i]))
					objStack.pop();
				else
					return "not balanced";
			}
		}
		return objStack.size() == 0 ? "balanced" : "not balanced";
	}
	
	public static boolean matchParanthesis(char stackPeek, char nextChar) {
		boolean result = false;
		if(stackPeek == '[' && nextChar == ']')
			result = true;
		else if(stackPeek == '{' && nextChar == '}')
			result = true;
		else if(stackPeek == '(' && nextChar == ')')
			result = true;
		return result;
	}

}

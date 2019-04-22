package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class SimilarExpressions {

	public static void main(String[] args) {
		int testCases;
		String data1, data2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				data1 = br.readLine().trim();
				data2 = br.readLine().trim();
				System.out.println(checkExpSimilar(data1, data2) ? "YES" : "NO");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkExpSimilar(String data1, String data2) {
		Map<Character, Integer> occurence1, occurence2;
		if(!(data1.charAt(0) == '+' || data1.charAt(0) == '-'))
			data1 = "+" + data1;
		if(!(data2.charAt(0) == '+' || data2.charAt(0) == '-'))
			data2 = "+" + data2;
		data1 = removeBracket(data1);
		data2 = removeBracket(data2);
		occurence1 = expressionOccurence(data1);
		occurence2 = expressionOccurence(data2);
		return occurenceComparison(occurence1, occurence2);
	}

	private static boolean occurenceComparison(Map<Character, Integer> occurence1, Map<Character, Integer> occurence2) {
		int value;
		char key;
		Entry<Character, Integer> nextItem;
		if(occurence1.size() == occurence2.size()) {
			Iterator<Entry<Character, Integer>> iterator = occurence1.entrySet().iterator();
			while(iterator.hasNext()) {
				nextItem = iterator.next();
				key = nextItem.getKey();
				value = nextItem.getValue();
				if(value != 0) {
					if(occurence2.containsKey(key)) {
						if(occurence2.get(key) != value)
							return false;
					}
					else
						return false;
				}
			}
		}
		else
			return false;
		return true;
	}
	
	public static String removeBracket(String data) {
		Stack<Boolean> objToggleRequired = new Stack<>();
		StringBuilder strBuilder = new StringBuilder();
		for(int i=0; i<data.length(); i++) {
			switch (data.charAt(i)) {
			case '(':
				if(objToggleRequired.size() > 0) {
					if(strBuilder.charAt(strBuilder.length() - 1) == '-')
						objToggleRequired.push(true);
					else
						objToggleRequired.push(false);
				}
				else {
					if(data.charAt(i - 1) == '-') {
						objToggleRequired.push(true);
					}
					else
						objToggleRequired.push(false);
				}
				if(i + 1 < data.length() && (data.charAt(i + 1) == '+' || data.charAt(i + 1) == '-')) {
					if(strBuilder.charAt(strBuilder.length() - 1) == '-') {
						if(data.charAt(i + 1) == '+')
							strBuilder.deleteCharAt(strBuilder.length() - 1).append('-');
						else
							strBuilder.deleteCharAt(strBuilder.length() - 1).append('+');
					}
					else {
						if(data.charAt(i + 1) == '-')
							strBuilder.deleteCharAt(strBuilder.length() - 1).append('-');
					}
					++i;
						
				}
					
				break;
			case ')':
				objToggleRequired.pop();
				break;
			case '+':
				if(objToggleRequired.size() > 0) {
					if(objToggleRequired.peek())
						strBuilder.append('-');
					else
						strBuilder.append('+');
				}
				else
					strBuilder.append('+');
				break;
			case '-':
				if(objToggleRequired.size() > 0) {
					if(objToggleRequired.peek())
						strBuilder.append('+');
					else
						strBuilder.append('-');
				}
				else
					strBuilder.append('-');
				break;
			default:
				strBuilder.append(data.charAt(i));
				break;
			}
		}
		return strBuilder.toString();
	}
	
	public static Map<Character, Integer> expressionOccurence(String data) {
		Character key;
		int value;
		Map<Character, Integer> occurence = new HashMap<>();
		for(int i=1; i<data.length(); i=i+2) {
			key = data.charAt(i);
			if(occurence.containsKey(key)) {
				value = occurence.get(key);
				if(data.charAt(i - 1) == '+') {
					if(value == -1)
						occurence.remove(key);
					else
						occurence.put(key, value + 1);
				}
				else {
					if(value == 1)
						occurence.remove(key);
					else
						occurence.put(key, value - 1);
				}
			}
			else {
				if(data.charAt(i - 1) == '+')
					occurence.put(key, 1);
				else
					occurence.put(key, -1);
			}
		}
		return occurence;
	}

}

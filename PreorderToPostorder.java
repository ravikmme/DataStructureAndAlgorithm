package main.java.com.rss.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PreorderToPostorder {
	
	static class Index {
		int position;
	}
	
	static class TreeNode {
		int data;
		TreeNode left, right;
		public TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int testCases, noOfElements;
		String[] tempData;
		int[] arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				noOfElements = Integer.parseInt(br.readLine());
				tempData = br.readLine().split("\\s+");
				arr = new int[noOfElements];
				for(int i=0; i<noOfElements; i++)
					arr[i] = Integer.parseInt(tempData[i]);
				findPostorder(arr, noOfElements);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void findPostorder(int[] arr, int noOfElements) {
		TreeNode root = findPostorderUtil(arr, noOfElements, new Index(), Integer.MAX_VALUE, Integer.MIN_VALUE);
		postorder(root);
		System.out.println();
	}
	
	public static void postorder(TreeNode root) {
		if(root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}

	public static TreeNode findPostorderUtil(int[] arr, int noOfElements, Index objIndex, int maxValue, int minValue) {
		if(objIndex.position == noOfElements)
			return null;
		TreeNode node = new TreeNode(arr[objIndex.position]);
		if(objIndex.position + 1 == noOfElements)
			return node;
		if(arr[objIndex.position + 1] < arr[objIndex.position] && arr[objIndex.position + 1] > minValue) {
			node.left = findPostorderUtil(arr, noOfElements, objIndex, arr[objIndex.position++], minValue);
		}
		if(arr[objIndex.position + 1] > arr[objIndex.position] && arr[objIndex.position + 1] < maxValue) {
			node.right = findPostorderUtil(arr, noOfElements, objIndex, maxValue, arr[objIndex.position++]);
		}
		return node;
	}
}

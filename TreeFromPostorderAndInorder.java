package main.java.com.rss.amazon;

import java.util.Scanner;

public class TreeFromPostorderAndInorder {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int value) {
			data = value;
			left = null;
			right = null;
		}
	}

	public void printINORDER(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		printINORDER(root.left);

		printINORDER(root.right);

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		TreeFromPostorderAndInorder ip = new TreeFromPostorderAndInorder();
		int T = sc.nextInt();
		while (T > 0) {
			int n = sc.nextInt();
			int inorder[] = new int[n];
			int postorder[] = new int[n];
			for (int i = 0; i < n; i++)
				inorder[i] = sc.nextInt();
			for (int i = 0; i < n; i++)
				postorder[i] = sc.nextInt();
			Node root = buildTree(inorder, postorder, n);
			ip.printINORDER(root);
			System.out.println();

			T--;

		}
		sc.close();
	}
	
	static class Index {
		int index;
	}

	public static Node buildTree(int in[], int post[], int n) {
		Index objIndex = new Index();
		objIndex.index = n - 1;
		return buildTreeUtil(in, post, 0, n-1, objIndex);
	}
	
	public static Node buildTreeUtil(int in[], int post[], int startIndex, int endIndex, Index objIndex) {
		if(startIndex > endIndex)
			return null;
		int rootValue, breakPoint = startIndex;
		rootValue = post[objIndex.index--];	//create node from right in post order
		Node root = new Node(rootValue);
		if(startIndex == endIndex)
			return root;
		while(breakPoint < endIndex) {
			if(in[breakPoint] == rootValue)
				break;
			++breakPoint;
		}
		root.right = buildTreeUtil(in, post, breakPoint + 1, endIndex, objIndex);
		root.left = buildTreeUtil(in, post, startIndex, breakPoint - 1, objIndex);
		return root;
	}
	
}
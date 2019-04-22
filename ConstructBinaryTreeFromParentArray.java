package main.java.com.rss.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConstructBinaryTreeFromParentArray {
	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	static class NodeWrapper {
		Node root;
	}
	
	static ArrayList<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];

			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();

			Node root = construcTree(arr, n);

			printLevelOrder(root);
			System.out.println();
		}
		sc.close();
	}

	public static void printList(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
		}
	}

	public static void printLevelOrder(Node root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			result.clear();
			printGivenLevel(root, i);
			Collections.sort(result);
			for (int j = 0; j < result.size(); j++)
				System.out.print(result.get(j) + " ");
		}
	}

	public static int height(Node root) {
		if (root == null)
			return 0;

		else {
			int lheight = height(root.left);
			int rheight = height(root.right);
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	public static void printGivenLevel(Node node, int level) {
		if (node == null)
			return;
		if (level == 1)
			result.add(node.data);
		else if (level > 1) {
			printGivenLevel(node.left, level - 1);
			printGivenLevel(node.right, level - 1);
		}
	}

	public static Node construcTree(int arr[], int n) {
		NodeWrapper objNodeWrapper = new NodeWrapper();
		Node[] nodeArr = new Node[n];
		for (int i = 0; i < n; i++)
			construcTreeUtil(arr, i, nodeArr, objNodeWrapper);
		return objNodeWrapper.root;
	}

	public static void construcTreeUtil(int arr[], int position, Node[] nodeArr, NodeWrapper objNodeWrapper) {
		if(nodeArr[position] != null)
			return;
		
		nodeArr[position] = new Node(position);
		if(arr[position] == -1) {
			objNodeWrapper.root = nodeArr[position];
			return;
		}
		if(nodeArr[arr[position]] == null)
			construcTreeUtil(arr, arr[position], nodeArr, objNodeWrapper);
		if(nodeArr[arr[position]].left == null)
			nodeArr[arr[position]].left = nodeArr[position];
		else
			nodeArr[arr[position]].right = nodeArr[position];
		
	}
}

package main.java.com.rss.amazon;

import java.util.Scanner;

public class FixingTwoNodesOfABST {
	static int flag = 1;
	static int c = 0;
	static Node first, middle, last, prev;

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int m = n;
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Node root = null;
			Node temp = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int a1 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (i == 0) {
					root = new Node(a);
					temp = new Node(a);
					switch (lr) {
					case 'L':
						root.left = new Node(a1);
						temp.left = new Node(a1);
						break;
					case 'R':
						root.right = new Node(a1);
						temp.right = new Node(a1);
						break;
					}
				} else {
					insert(root, a, a1, lr);
					insert(temp, a, a1, lr);
				}
			}
			flag = 1;
			c = 0;
//            FixingTwoNodesOfABST gfg = new FixingTwoNodesOfABST();
			root = /* gfg. */correctBST(root);

			inorder(temp, root);
			if (c + 1 == m)
				System.out.println(flag);
			else
				System.out.println("0");

		}
		sc.close();
	}

	public static void insert(Node root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Node(a1);
				break;
			case 'R':
				root.right = new Node(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

	public static void inorder(Node temp, Node root) {
		if (flag == 0) {
			return;
		}
		if (temp == null && root == null)
			return;
		if (root == null) {
			flag = 0;
			return;
		}
		if (temp == null) {
			flag = 0;
			return;
		}
		if (temp.data == root.data) {
			c++;
		}
		inorder(temp.left, root.left);
		inorder(temp.right, root.right);
	}

	private static Node correctBST(Node root) {
		int tempData;
		correctBSTUtil(root);
		if (first != null && last != null) {
			tempData = first.data;
			first.data = last.data;
			last.data = tempData;
		} else if (first != null) {
			tempData = first.data;
			first.data = middle.data;
			middle.data = tempData;
		}
		return root;
	}

	private static void correctBSTUtil(Node root) {
		if (root != null) {
			correctBSTUtil(root.left);
			if (prev != null && root.data < prev.data) {

				if (first == null) {
					first = prev;
					middle = root;
				} else
					last = root;
			}
			prev = root;
			correctBSTUtil(root.right);
		}
	}
}

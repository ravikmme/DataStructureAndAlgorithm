package main.java.com.rss.amazon;

import java.util.Scanner;

public class AVLTreeInsertion {
	static class Node {
		int data;
		int height;
		Node left, right;

		Node(int d) {
			data = d;
			height = 0;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			boolean f = true;
			if (n == 0) {
				System.out.println("1");
				continue;
			}
			if (n == 1) {
//				int a = sc.nextInt();
				sc.nextInt();
				System.out.println("1");
				continue;
			}
			if (n == 2) {
//				int a = sc.nextInt();
//				a = sc.nextInt();
				sc.nextInt();
				sc.nextInt();
				System.out.println("1");
				continue;
			} else {
//			GfG g=new GfG();
				Node root = null;
				Node proot = null;
				f = true;
				while (n-- > 0) {
					int a = sc.nextInt();
					proot = insertToAVL(root, a);
					if (isBalanced(proot) == 0) {
						f = false;
						break;
					}
					if (!_B(root)) {
						if (I_(root)) {
							f = false;
							break;
						}
					}
				}
			}
			if (f == true)
				System.out.println("1");
			else
				System.out.println("0");
		}
		sc.close();
	}

	public static int _B_(Node root) {
		if (root == null)
			return 0;
		int lH = _B_(root.left);
		if (lH == -1)
			return -1;
		int rH = _B_(root.right);
		if (rH == -1)
			return -1;
		if (Math.abs(lH - rH) > 1)
			return -1;
		return Math.max(lH, rH) + 1;
	}

	public static boolean _B(Node root) {
		if (_B_(root) == -1)
			return false;
		else
			return true;
	}

	public static int isBalanced(Node root) {
		int lh;
		int rh;
		if (root == null)
			return 1;
		lh = heigh(root.left);
		rh = heigh(root.right);

		if (Math.abs(lh - rh) <= 1)
			if (isBalanced(root.left) == 1)
				if (isBalanced(root.right) == 1)
					return 1;
		return 0;
	}

	public static int heigh(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(heigh(node.left), heigh(node.right));
	}

	public static boolean I_(Node root) {
//		Node prev = null;
		if (root != null) {
			if (!I_(root.left))
				return false;
//			if (prev != null && root.data <= prev.data)
//				return false;
//			prev = root;
			return I_(root.right);
		}
		return true;
	}

	public static Node insertToAVL(Node node, int data) {
		if(node == null)
			return new Node(data);
		if(data <= node.data)
			node.left = insertToAVL(node.left, data);
		else
			node.right = insertToAVL(node.right, data);
		int balance = height(node.left) - height(node.right);
		if(balance > 1) {
			if(height(node.left.left) >= height(node.left.right))
				return rotateRight(node);	//Left Left Rotation
			else {
				//Left Right Rotation
				node.left = rotateLeft(node.left);
				return rotateRight(node);
			}
		}
		if(balance < -1) {
			if(height(node.right.right) >= height(node.right.left))
				return rotateLeft(node);	//Right Right Rotation
			else {
				//Right Left Rotation
				node.right = rotateRight(node.right);
				return rotateLeft(node);
			}
		}
		node.height = height(node);
		return node;
	}

	private static Node rotateRight(Node node) {
		Node newRoot = node.left;
		node.left = newRoot.right;
		newRoot.right = node;
		node.height = height(node);
		newRoot.height = height(newRoot);
		return newRoot;
	}

	private static Node rotateLeft(Node node) {
		Node newRoot = node.right;
		node.right = newRoot.left;
		newRoot.left = node;
		node.height = height(node);
		newRoot.height = height(newRoot);
		return newRoot;
	}
	
	public static int height(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	
}

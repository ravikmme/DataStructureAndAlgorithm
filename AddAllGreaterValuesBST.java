package main.java.com.rss.amazon;

//INITIAL CODE
import java.util.Scanner;

//A Binary Search Tree node
public class AddAllGreaterValuesBST {
	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
	}

	Node root;

	void insert(Node root, int key) {
		// System.out.print(key);
		if (key < root.data) { // System.out.print(root.key);
			if (root.left != null)
				insert(root.left, key);
			else {
				root.left = new Node(key);
				// System.out.print(root.left.key);
			}
			// root = root.left;
			// insert(root.left,key);
		} else if (key > root.data) {
			// System.out.print(root.key);
			if (root.right != null)
				insert(root.right, key);
			else {
				root.right = new Node(key);
				// System.out.print(root.right.key);
			}
			// root = root.right;
			// insert(root.right, key);
			// System.out.println(key);
		}
	}

	void inorder(Node node) {
		if (node == null)
			return;
		else
			inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// Node root;
		while (t > 0) {
			// Node root;
			// Node tmp;
			// root = null;
			int n = sc.nextInt();
			AddAllGreaterValuesBST tree = new AddAllGreaterValuesBST();
			// GfG g = new GfG();
			int a1 = sc.nextInt();
			Node root = new Node(a1);

			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				tree.insert(root, a);
			}

			// tree.inorder(root);
			modify(root);
			tree.inorder(root);
			System.out.println();
			t--;
		}
		sc.close();
	}

	static class AddData {
		int sum = 0;
	}
	
	public static void modify(Node root) {
		modifyUtil(root, new AddData());
	}
	
	public static void modifyUtil(Node root, AddData objAddData) {
		int toBeAdded;
		if(root == null)
			return;
		modifyUtil(root.right, objAddData);
		toBeAdded = objAddData.sum;
		objAddData.sum += root.data;
		root.data += toBeAdded; 
		modifyUtil(root.left, objAddData);
	}
	
}

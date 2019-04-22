package main.java.com.rss.amazon;

import java.util.HashMap;
//INITIAL CODE
import java.util.Scanner;

//A Binary Search Tree node
public class CheckForBST {
	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	/*
	 * void printInorder(Node node) { if (node == null) return; /* first recur on
	 * left child
	 */
	// printInorder(node.left);
	/* then print the data of node */
	// System.out.print(node.data + " ");
	/* now recur on right child */
	// printInorder(node.right);
	// }*/
	// driver function to test the above functions
	public static void main(String args[]) {
		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();

			Node root = null;
			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				// cout << n1 << " " << n2 << " " << (char)lr << endl;
				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
				n--;
			}

			System.out.println(isBST(root));
			// ob.printInorder(root);
			t--;

		}
		sc.close();
	}

	public static int isBST(Node root) {
		return isBSTUtil(root, Integer.MAX_VALUE, Integer.MIN_VALUE) ? 1 : 0;
	}
	
	public static boolean isBSTUtil(Node root, int max, int min) {
		if(root == null)
			return true;
		if(root.data > max || root.data < min)
			return false;
		return isBSTUtil(root.left, root.data, min) && isBSTUtil(root.right, max, root.data);
	}
}

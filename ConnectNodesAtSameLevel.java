package main.java.com.rss.amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// A Binary Tree node
public class ConnectNodesAtSameLevel {
	static class Node {
		int data;
		Node left, right, nextRight;

		Node(int item) {
			data = item;
			left = right = nextRight = null;

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

	void printSpecial(Node root) {
		if (root == null)
			return;
		Node node = root;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.nextRight;
		}
		if (root.left != null)
			printSpecial(root.left);
		else
			printSpecial(root.right);

	}

	// driver function to test the above functions
	public static void main(String args[]) {

		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ConnectNodesAtSameLevel can = new ConnectNodesAtSameLevel();
		// Node root=null;

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


			connect(root);
			can.printSpecial(root);
			System.out.println();
			can.inorder(root);
			System.out.println();
			t--;

		}
		sc.close();
	}

	public static void connect(Node root) {
		int queueSize;
		Node prevLeftNode = null, presentNode = null;
		Queue<Node> bfsQueue = new LinkedList<>();
		bfsQueue.add(root);
		while(!bfsQueue.isEmpty()) {
			queueSize = bfsQueue.size();
			for(int i=0; i<queueSize; i++) {
				presentNode = bfsQueue.poll();
				if(presentNode.left != null)
					bfsQueue.add(presentNode.left);
				if(presentNode.right != null)
					bfsQueue.add(presentNode.right);
				if(i > 0)
					prevLeftNode.nextRight = presentNode;
				prevLeftNode = presentNode;
			}
		}
	}
}

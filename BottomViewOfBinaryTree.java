package main.java.com.rss.amazon;

//Java Program to print Bottom View of Binary Tree
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

//Tree node class

public class BottomViewOfBinaryTree {
	static class Node {
		int data; // data of the node
		int hd; // horizontal distance of the node
		Node left, right; // left and right references

		// Constructor of tree node
		public Node(int key) {
			data = key;
			hd = Integer.MAX_VALUE;
			left = right = null;
		}
	}

	// driver function to test the above functions
	public static void main(String args[]) {

		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
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

			// g.leftView(root);
			bottomView(root);

			System.out.println();
			t--;
		}
		sc.close();
	}

	public static void bottomView(Node root) {
		Entry<Integer, Integer> next ;
		Map<Integer, Integer> objMap = new TreeMap<>();
		bottomViewUtil(root, 0, objMap);
		Iterator<Entry<Integer, Integer>> iterator = objMap.entrySet().iterator();
		while(iterator.hasNext()) {
			next = iterator.next();
			System.out.print(next.getValue() + " ");
		}
	}
	
	public static void bottomViewUtil(Node root, int value, Map<Integer, Integer> objMap) {
		if(root == null)
			return;
		objMap.put(value, root.data);
		bottomViewUtil(root.left, value - 1, objMap);
		bottomViewUtil(root.right, value + 1, objMap);
	}
}

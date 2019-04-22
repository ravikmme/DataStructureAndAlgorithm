package main.java.com.rss.amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

//Tree node
public class DiagonalTraversalOfBinaryTree {
	static class TreeNode {
		int data; // node data
		TreeNode left, right; // left and right child's reference
		// Tree node constructor

		TreeNode(int d) {
			data = d;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			TreeNode root = null;
			if (n == 1) {
				int a = sc.nextInt();
				System.out.println(a);
				continue;
			} else {
				while (n-- > 0) {
					int n1 = Integer.parseInt(sc.next());
					int n2 = Integer.parseInt(sc.next());
					char lr = sc.next().charAt(0);
					if (root == null) {
						root = new TreeNode(n1);
						switch (lr) {
						case 'L':
							root.left = new TreeNode(n2);
							break;
						case 'R':
							root.right = new TreeNode(n2);
							break;
						}
					} else {
						insert(root, n1, n2, lr);
					}
				}
			}
			diagonalPrint(root);
			System.out.println();

		}
		sc.close();
	}

	public static void insert(TreeNode root, int n1, int n2, char lr) {
		if (root == null)
			return;
		if (root.data == n1) {
			switch (lr) {
			case 'L':
				root.left = new TreeNode(n2);
				break;
			case 'R':
				root.right = new TreeNode(n2);
				break;
			}
		} else {
			insert(root.left, n1, n2, lr);
			insert(root.right, n1, n2, lr);
		}
	}

	public static void diagonalPrint(TreeNode root) {
		List<Integer> value;
		TreeMap<Integer, List<Integer>> objElementMap = new TreeMap<Integer, List<Integer>>();
		diagonalPrintUtil(root, objElementMap, 0);
		Iterator<Entry<Integer, List<Integer>>> iterator = objElementMap.entrySet().iterator();
		while(iterator.hasNext()) {
			value = iterator.next().getValue();
			value.stream().map(a->a.toString()+ " ").forEach(System.out::print);
		}
	}
	
	public static void diagonalPrintUtil(TreeNode root, TreeMap<Integer, List<Integer>> objElementMap, int gradient) {
		if(root == null)
			return;
		if(objElementMap.containsKey(gradient))
			objElementMap.get(gradient).add(root.data);
		else {
			List<Integer> objIntList = new ArrayList<Integer>();
			objIntList.add(root.data);
			objElementMap.put(gradient, objIntList);
		}
		diagonalPrintUtil(root.left, objElementMap, gradient + 1);
		diagonalPrintUtil(root.right, objElementMap, gradient);
	}
}

package main.java.com.rss.gfg.amazon;

import java.util.*;

public class LargestBst{
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data=data;
			left=null;
			right=null;}
	}
	static class TreeDetails {
		int size; 
	    int max; 
	    int min; 
	    int ans; 
	    boolean isBST;
		public TreeDetails(int size, int max, int min, int ans, boolean isBST) {
			super();
			this.size = size;
			this.max = max;
			this.min = min;
			this.ans = ans;// Size of largest BST
			this.isBST = isBST;
		} 
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			Node root=null;
			if(n==0){
				System.out.println("0");
				continue;
			}
			if(n==1)
			{
				sc.nextInt();
				System.out.println("1");
				continue;

			}
			else{while(n-->0){
				int n1=sc.nextInt();
				int n2=sc.nextInt();
				char ch=sc.next().charAt(0);
				if(root==null)
				{root=new Node(n1);
				switch(ch){
				case 'L':root.left=new Node(n2);
				break;
				case 'R':root.right=new Node(n2);
				break;
				}
				}
				else{insert(n1,n2,ch,root);}
			}
			largestBst(root);
			}
		}
		sc.close();
	}		
	public static void insert(int n1,int n2,char ch,Node root){
		if(root==null)
			return;
		if(root.data==n1)
			switch(ch){
			case 'L':root.left=new Node(n2);
			break;
			case 'R':root.right=new Node(n2);
			break;
			}
		insert(n1,n2,ch,root.left);
		insert(n1,n2,ch,root.right);
	}
	
	public static int largestBst(Node node) {
        int i = largestBstUtil(node).ans;
        System.out.println(i);
        return i;
    }
    
    private static TreeDetails largestBstUtil(Node root) {
		if(root == null)
			return new TreeDetails(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
		if(root.left == null && root.right == null)
			return new TreeDetails(1, root.data, root.data, 1, true);
		
		TreeDetails leftTreeDetails = largestBstUtil(root.left);
		TreeDetails rightTreeDetails = largestBstUtil(root.right);
		
		TreeDetails retResult;
		int treeSize = 1 + leftTreeDetails.size + rightTreeDetails.size;
		if(leftTreeDetails.isBST && rightTreeDetails.isBST 
				&& (leftTreeDetails.max == Integer.MAX_VALUE || root.data > leftTreeDetails.max) 
				&& (rightTreeDetails.min == Integer.MIN_VALUE || root.data < rightTreeDetails.min)) {
			retResult = new TreeDetails(treeSize, rightTreeDetails.max, leftTreeDetails.min, treeSize, true);
			return retResult;
		}
		int minimum = Arrays.asList(leftTreeDetails.min, rightTreeDetails.min, root.data).stream().max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		}).get();
		int maximum = Arrays.asList(leftTreeDetails.max, rightTreeDetails.max, root.data).stream().max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		}).get();
		retResult = new TreeDetails(treeSize, maximum, minimum, leftTreeDetails.ans > rightTreeDetails.ans ? leftTreeDetails.ans : rightTreeDetails.ans, false);
		return retResult;
	}
}
package main.java.com.rss.gfg.amazon;

import java.util.Scanner;
import java.util.Stack;

public class KSumPaths {	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Node root =null;
			while(n-->0){
				int a1=sc.nextInt();
				int a2=sc.nextInt();
				char lr=sc.next().charAt(0);
				if(root==null){
					root=new Node(a1);
					switch(lr){
					case 'L':root.left=new Node(a2);
					break;
					case 'R':root.right=new Node(a2);
					break;
					}
				}
				else{
					insert(root,a1,a2,lr);
				}
			}
			int k=sc.nextInt();
//			printCount(root,k);
			System.out.println(printCount(root,k));
		}
		sc.close();
	}

	private static int printCount(Node root, int k) {
		Index count = new Index();
		Stack<Integer> depthStack = new Stack<>();
		printCountUtil(root, depthStack, k, count);
		return count.index;
	}
	
	private static void printCountUtil(Node root, Stack<Integer> depthStack, int k, Index count) {
		if(root == null)
			return;
		depthStack.add(root.data);
		printCountUtil(root.left, depthStack, k, count);
		printCountUtil(root.right, depthStack, k, count);
		int sum = 0;
		for(int i=depthStack.size()-1; i>=0; i--) {
			sum += depthStack.elementAt(i);
			if(sum == k) {
				++count.index;
				for(int j=i; j<depthStack.size(); j++)
					System.out.print(depthStack.elementAt(j) + " ");
				System.out.println();
			}
		}
		depthStack.pop();
	}



	public static void insert(Node root, int a1,int a2,char lr){
		if(root==null)
			return;
		if(root.data==a1){
			switch(lr){
			case 'L':root.left=new Node(a2);
			break;
			case 'R':root.right=new Node(a2);
			break;
			}
		}
		else{
			insert(root.left,a1,a2,lr);
			insert(root.right,a1,a2,lr);
		}
	}
}

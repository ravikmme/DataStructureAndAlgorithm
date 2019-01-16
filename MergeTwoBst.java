package main.java.com.rss.gfg.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MergeTwoBst {
	
	static class Node{
		int data;
		Node left, right;
		Node(int d){
			data=d;
			left=right=null;
		}
	}
	
	static class Index {
		int pos = 0;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int x = sc.nextInt();
			int y = sc.nextInt();
			Node fhead = null;
			Node shead = null;
			for(int i = 0; i < x; i++)
			{
				if(fhead==null)
					fhead = new Node(sc.nextInt());
				else{
					insert(fhead,sc.nextInt());
				}
			}
			for(int i = 0; i < y; i++)
			{
				if(shead==null)
					shead = new Node(sc.nextInt());
				else{
					insert(shead,sc.nextInt());
				}
			}
			merge(fhead , shead);
			System.out.println();
		}
		sc.close();
	}
	
	public static Node insert(Node head, int a){
		if(head==null)
			return new Node(a);
		if(head.data>a)
			head.left=insert(head.left,a);
		if(head.data<a)
			head.right=insert(head.right,a);
		return head;
	}
	
	private static void merge(Node root1, Node root2) {
		List<Integer> objIntElement = new ArrayList<>();
		if(root1 == null && root2 == null)
			return;
		if(root1 == null) {
			inorder(root2, objIntElement);
			System.out.println(objIntElement.stream().map(a -> a.toString()).reduce((word1, word2) -> word1 + " " + word2).get());
			return;
		}
		if(root2 == null) {
			inorder(root1, objIntElement);
			System.out.println(objIntElement.stream().map(a -> a.toString()).reduce((word1, word2) -> word1 + " " + word2).get());
			return;
		}
		inorder(root2, objIntElement);
		Index pointer = new Index();
		mergeInorder(root1, objIntElement, pointer);
		while(pointer.pos < objIntElement.size())
			System.out.print(objIntElement.get(pointer.pos++) + " ");
		
			
	}
	
	private static void inorder(Node root, List<Integer> objIntElement) {
		if(root != null) {
			inorder(root.left, objIntElement);
			objIntElement.add(root.data);
			inorder(root.right, objIntElement);
		}
	}
	private static void mergeInorder(Node root, List<Integer> objIntElement, Index pointer) {
		if(root != null) {
			mergeInorder(root.left, objIntElement, pointer);
			while(pointer.pos < objIntElement.size() && root.data >=  objIntElement.get(pointer.pos))
				System.out.print(objIntElement.get(pointer.pos++) + " ");
			System.out.print(root.data + " ");
			mergeInorder(root.right, objIntElement, pointer);
		}
	}
}
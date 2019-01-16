package main.java.com.rss.gfg.amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode
{
	int data;
	TreeNode left, right;
	TreeNode(int key)
	{
		data = key;
		left = right = null;
	}
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
}
public class TopViewBinaryTree {
	public static void insert(TreeNode root,int a,int a1,char lr){
		if(root==null){
			return;
		}
		if(root.data==a){
			switch(lr){
			case 'L':root.left=new TreeNode(a1);
			break;
			case 'R':root.right=new TreeNode(a1);
			break;
			}
			return;
		}
		insert(root.left,a,a1,lr);
		insert(root.right,a,a1,lr);
	}

	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();

		while(t-->0){
			int n=sc.nextInt();
			if(n==0){
				System.out.println(0);
				continue;
			}
			TreeNode root = null;
			for(int i=0;i<n;i++){
				int a=sc.nextInt();
				int a1=sc.nextInt();
				char lr=sc.next().charAt(0);
				if(i==0){
					root=new TreeNode(a);
					switch(lr){
					case 'L':root.left=new TreeNode(a1);
					break;
					case 'R':root.right=new TreeNode(a1);
					break;
					}
				}
				else{
					insert(root,a,a1,lr);
				}
			}

			printCorner(root);
			System.out.println();
		}
		sc.close();
	}

	public static void printCorner(TreeNode objTreeNode) {
		TreeNode presentTreeNode, prevTreeNode = new TreeNode(0);
		Queue<TreeNode> objQueue = new LinkedList<>();
		objQueue.add(objTreeNode);
		objQueue.add(null);
		while(!objQueue.isEmpty()) {
			presentTreeNode = objQueue.poll();
			if(presentTreeNode == null) {
				if(objQueue.size() == 0)
					break;
				objQueue.add(null);
			}
			else if(prevTreeNode == null) {
				System.out.print(presentTreeNode.data + " ");
				if(presentTreeNode.left != null)
					objQueue.add(presentTreeNode.left);
				if(presentTreeNode.right != null)
					objQueue.add(presentTreeNode.right);
			}
			else if(objQueue.peek() == null) {
				System.out.print(presentTreeNode.data + " ");
				if(presentTreeNode.left != null)
					objQueue.add(presentTreeNode.left);
				if(presentTreeNode.right != null)
					objQueue.add(presentTreeNode.right);
			}
			else {
				if(presentTreeNode.left != null)
					objQueue.add(presentTreeNode.left);
				if(presentTreeNode.right != null)
					objQueue.add(presentTreeNode.right);
			}
			prevTreeNode = presentTreeNode;
		}
	}
}

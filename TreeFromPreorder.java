package main.java.com.rss.gfg.amazon;
import java.util.Scanner;

class Node{
	int data;
	Node left,right;
	Node(int d)
	{
		data=d;
		left=right=null;
	}
}
public class TreeFromPreorder
{
	public static void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int []pre=new int[n];
			char []preLN=new char[n];
			for(int i=0;i<n;i++)
			{
				int b=sc.nextInt();
				pre[i]=b;
			}
			for(int i=0;i<n;i++)
			{
				char c=sc.next().charAt(0);
				preLN[i]=c;
			}
			GFGTreeFromPreorder obj=new GFGTreeFromPreorder();
			Node root=obj.constructTree(n,pre,preLN);
			inorder(root);
			System.out.println();
		}
		sc.close();
	}
}

class Index {
	int index = 0;
}

class GFGTreeFromPreorder
{
	Node root;
	Node constructTree(int n, int pre[], char preLN[])
	{
		constructTreeUtil(n, pre, preLN, new Index(), root);
		return root;
	}

	Node constructTreeUtil(int n, int pre[], char preLN[], Index indexPointer, Node temp) {
		int presentIndex = indexPointer.index;
		if(indexPointer.index==n)
			return null;
		temp = new Node(pre[presentIndex]);
		if(presentIndex==0)
			this.root = temp;
		indexPointer.index++;
		if(preLN[presentIndex] == 'N') {
			temp.left = constructTreeUtil(n, pre, preLN, indexPointer, temp.left);
			temp.right = constructTreeUtil(n, pre, preLN, indexPointer, temp.right);
		}
		return temp;

	}
}
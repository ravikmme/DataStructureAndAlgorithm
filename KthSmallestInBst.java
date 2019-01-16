package main.java.com.rss.gfg.amazon;

import java.util.Scanner;

class TwoWayNode{
	int data;
	TwoWayNode left, right;
	TwoWayNode(int d){
		data=d;
		left=right=null;
	}
}
public class KthSmallestInBst {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            TwoWayNode fhead=null;
            for(int i = 0; i < n; i++)
			{
				if(fhead==null)
					fhead = new TwoWayNode(sc.nextInt());
				else{
					insert(fhead,sc.nextInt());
				}
			}
			int k=sc.nextInt();
			int ans=kthSmallest(fhead,k);
			System.out.println(ans);
        }
        sc.close();
    }
	public static TwoWayNode insert(TwoWayNode head, int a){
		if(head==null)
			return new TwoWayNode(a);
		if(head.data>=a)
			head.left=insert(head.left,a);
		if(head.data<a)
			head.right=insert(head.right,a);
		return head;
	}
	private static int kthSmallest(TwoWayNode fhead, int k) {
		Index result = new Index();
		result.index = Integer.MIN_VALUE;
		kthSmallestUtil(fhead, k, new Index(), result); 
		return result.index;
	}
	
	private static void kthSmallestUtil(TwoWayNode node, int k, Index index, Index result) {
		if (node == null) 
            return; 
  
		kthSmallestUtil(node.left, k, index, result); 
  
		++index.index;
		if(index.index == k){
			result.index = node.data;
			return;
		}
  
        kthSmallestUtil(node.right, k, index, result); 
	}
}
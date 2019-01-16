package main.java.com.rss.gfg.amazon;

import java.util.*;
/*class TreeNode{
	int data;
	TreeNode left,right;
	TreeNode(int d){
		data=d;
		left=right=null;
	}
}*/
public class PrintNodesWithKLeaves {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int k=sc.nextInt();
			TreeNode root=null;
			if(n==0||n==1)
			{
				System.out.println("-1");
				continue;
			}
			for(int i=0;i<n;i++){
				int a=sc.nextInt();
				int a1=sc.nextInt();
				char lr=sc.next().charAt(0);
				if(root==null){
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
			btWithKleaves(root, k);
		}
		sc.close();
	}
	public static void insert(TreeNode root,int a,int a1,char lr){
		if(root==null)
			return;
		if(root.data==a)
		{
			switch(lr){
					case 'L':root.left=new TreeNode(a1);
					break;
					case 'R':root.right=new TreeNode(a1);
					break;
				}
		}
		else {
			insert(root.left,a,a1,lr);
			insert(root.right,a,a1,lr);
		}
	}
	
	private static void btWithKleaves(TreeNode root, int k) {
		KLeavePresent objKLeavePresent = new KLeavePresent();
		btWithKleavesUtil(root, k, objKLeavePresent);
		if(!objKLeavePresent.iskLeaveFlag())
			System.out.print("-1");
		System.out.println();
	}
	
	private static int btWithKleavesUtil(TreeNode root, int k, KLeavePresent kLeaveFlag) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		int total = btWithKleavesUtil(root.left, k, kLeaveFlag) + btWithKleavesUtil(root.right, k, kLeaveFlag);
		if(total == k){
			kLeaveFlag.setkLeaveFlag(true);;
			System.out.print(root.data + " ");
		}
		return total;		
	}
	 
}

class KLeavePresent{
	private boolean kLeaveFlag = false;
	public boolean iskLeaveFlag() {
		return kLeaveFlag;
	}
	public void setkLeaveFlag(boolean kLeaveFlag) {
		this.kLeaveFlag = kLeaveFlag;
	}
	@Override
	public String toString() {
		return "KLeavePresent [kLeaveFlag=" + kLeaveFlag + "]";
	}
}
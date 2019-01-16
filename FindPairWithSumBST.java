package main.java.com.rss.gfg.amazon;

import java.util.Scanner;

/*class TreeNode
{
	int data;
	TreeNode left, right;
	TreeNode(int key)
	{
		data = key;
		left = right = null;
	}
}*/

public class FindPairWithSumBST
{
	//static ArrayList<Integer> list = new ArrayList<Integer>();
	public static TreeNode insert(TreeNode root, int data)
	{
		if(root == null)
		{
			return (new TreeNode(data));
		}
		if(data < root.data)
		{
			root.left = insert(root.left, data);
		}
		else if(data > root.data)
		{
			root.right = insert(root.right, data);
		}
		return root;   
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			//list.clear();
			int n = sc.nextInt();
			int sum = sc.nextInt();
			TreeNode root = null;
			for(int i = 0; i  < n; i++)
			{
				int data = sc.nextInt();
				root = insert(root, data);
			}

			//inorderWalk(root);
			// int sum = sc.nextInt();
			boolean pairExists = findPair(root, sum);
			if(pairExists == true)
				System.out.println("1");
			else
				System.out.println("0");
		} 
		sc.close();

	}
	/*public static void inorderWalk(TreeNode root)
    {
        if(root == null)
            return;

        inorderWalk(root.left);
        list.add(root.data);
        inorderWalk(root.right);
    }*/
	
	private static boolean findPair(TreeNode root, int sum) {
		
		return false;
	}
}
package main.java.com.rss.gfg.amazon;


import java.util.*;
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
public class PairWithTargetInBst {
	static ArrayList<Integer> list = new ArrayList<Integer>();
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
			list.clear();
			int n = sc.nextInt();
			int sum = sc.nextInt();
			TreeNode root = null;
			for(int i = 0; i  < n; i++)
			{
				int data = sc.nextInt();
				root = insert(root, data);
			}

			//inorderWalk(root);
			GfGPairWithTargetInBst gfg = new GfGPairWithTargetInBst();
			// int sum = sc.nextInt();
			boolean pairExists = gfg.findPair(root, sum);
			//            boolean pairExists = findPair(root, sum);
			if(pairExists == true)
				System.out.println("1");
			else
				System.out.println("0");
		} 
		sc.close();
	}

	/*private static boolean findPair(TreeNode root, int target)
	{
		if(root == null)
			return false;
		if(findPair(root.left, target))
			return true;
		if(list.contains(target - root.data)) {
			System.out.println("Pair found: " + root.data + " " + (target - root.data));
			return true;
		}
		else
			list.add(root.data);
		return findPair(root.right, target);
	}*/
	/*public static void inorderWalk(TreeNode root)
    {
        if(root == null)
            return;

        inorderWalk(root.left);
        list.add(root.data);
        inorderWalk(root.right);
    }*/



}

class GfGPairWithTargetInBst
{
	public boolean findPair(TreeNode root, int target) {
		Set<Integer> set = new HashSet<>();
		return find(root, target, set);
	}
	
	public static boolean find(TreeNode root, int k, Set < Integer > set) {
		if (root == null)
			return false;
		if (set.contains(k - root.data))
			return true;
		set.add(root.data);
		return find(root.left, k, set) || find(root.right, k, set);
	}
}
package main.java.com.rss.gfg.amazon;

import java.util.Scanner;

public class DeleteKeysInALinkedList {
	static class Node
	{
		int data;
		Node next;
		
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	Node head;
	void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	public void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;
		   temp.next = node;
		}
    }
	
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t  =sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			DeleteKeysInALinkedList llist = new DeleteKeysInALinkedList();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			int x = sc.nextInt();
			Node result = deleteAllOccurances(llist.head, x);
			llist.printList(result);
		t--;
		}
		 sc.close();
	}

	private static Node deleteAllOccurances(Node head, int x) {
		Node root, prev;
		boolean occur = false;
		while(head.data == x)
			head = head.next;
		prev = root = head;
		while(root != null) {
			occur = false;
			while(root != null && root.data == x) {
				occur = true;
				root = root.next;
			}
			if(occur) {
				prev.next = root;
			}
			prev = root;
			if(root != null)
				root = root.next;
		}
		return head;
	}
}
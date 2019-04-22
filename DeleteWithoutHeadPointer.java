package main.java.com.rss.amazon;

import java.util.*;

public class DeleteWithoutHeadPointer {
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node head;

	void printList(Node head) {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();
	}

	void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	Node search_Node(Node head, int k) {
		Node current = head;
		while (current != null) {
			if (current.data == k)
				break;
			current = current.next;
		}
		return current;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			DeleteWithoutHeadPointer llist = new DeleteWithoutHeadPointer();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			int k = sc.nextInt();
			Node del = llist.search_Node(llist.head, k);

			if (del != null && del.next != null) {
				deleteNode(del);
			}
			llist.printList(llist.head);
			t--;
		}
		sc.close();
	}

	public static void deleteNode(Node del) {
		Node prev = null;
		while(del.next != null) {
			del.data = del.next.data;
			prev = del;
			del = del.next;
		}
		prev.next = null;
	}
}

package main.java.com.rss.amazon;

import java.util.*;

public class IntersectionPointInYShappedLinkedLists {
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node head = null;
	Node tail = null;

	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
			tail = head;
		} else {
			// Node temp = head;
			// while (temp.next != null)
			// temp = temp.next;
			// temp.next = node;
			tail.next = node;
			tail = node;
		}
	}

	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			IntersectionPointInYShappedLinkedLists llist1 = new IntersectionPointInYShappedLinkedLists();
			IntersectionPointInYShappedLinkedLists llist2 = new IntersectionPointInYShappedLinkedLists();
			IntersectionPointInYShappedLinkedLists llist3 = new IntersectionPointInYShappedLinkedLists();

			int a1 = sc.nextInt();
			Node head1 = new Node(a1);
			Node tail1 = head1;
			llist1.addToTheLast(head1);
			for (int i = 1; i < n1; i++) {
				int a = sc.nextInt();
				llist1.addToTheLast(new Node(a));
			}

			int b1 = sc.nextInt();
			Node head2 = new Node(b1);
			Node tail2 = head2;
			llist2.addToTheLast(head2);
			for (int i = 1; i < n2; i++) {
				int b = sc.nextInt();
				llist2.addToTheLast(new Node(b));
			}

			int c1 = sc.nextInt();
			Node head3 = new Node(c1);
//			Node tail3 = head3;
			llist3.addToTheLast(head3);
			for (int i = 1; i < n3; i++) {
				int c = sc.nextInt();
				llist3.addToTheLast(new Node(c));
			}

			if (tail1 != null)
				tail1.next = head3;
			if (tail2 != null)
				tail2.next = head3;

			// llist1.head= new GFG().Intersection(llist1.head,llist2.head);
			// llist1.printList();
			// System.out.println();

			System.out.println(intersectPoint(llist1.head, llist2.head));
			t--;
		}
		sc.close();
	}

	public static int intersectPoint(Node headA, Node headB) {
		int headASize = 0, headBSize = 0, forward;
		Node origHeadA = headA, origHeadB = headB;
		while(headA != null) {
			++headASize;
			headA = headA.next;
		}
		while(headB != null) {
			++headBSize;
			headB = headB.next;
		}
		if(headASize > headBSize) {
			forward = headASize - headBSize;
			while(forward-- > 0)
				origHeadA = origHeadA.next;
		}
		else {
			forward = headBSize - headASize;
			while(forward-- > 0)
				origHeadB = origHeadB.next;
		}
		while(origHeadA != null) {
			if(origHeadA == origHeadB)
				return origHeadA.data;
			origHeadA = origHeadA.next;
			origHeadB = origHeadB.next;
		}
		return -1;
	}
}

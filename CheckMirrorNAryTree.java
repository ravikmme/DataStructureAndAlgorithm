package main.java.com.rss.gfg.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class CheckMirrorNAryTree {

	public static void main(String[] args) {
		int testCases, /*noOfNode, */edge, parentElement, childElement;
		NArrTree root1 = null, root2 = null, node, childNode;
		Map<Integer, NArrTree> map1 = new HashMap<>();
		Map<Integer, NArrTree> map2 = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		testCases = scan.nextInt();
		while(testCases-- != 0) {
			/*noOfNode = */scan.nextInt();
			edge = scan.nextInt();
			for(int i=0; i<edge; i++) {
				parentElement = scan.nextInt();
				childElement = scan.nextInt();
				childNode = new NArrTree(childElement);
				if(i == 0) {
					root1 = new NArrTree(parentElement);
					root1.objNArrTreeList.add(childNode);
					map1.put(parentElement, root1);
				}
				else if(map1.containsKey(parentElement)) {
					map1.get(parentElement).objNArrTreeList.add(childNode);
				}
				else {
					node = new NArrTree(parentElement);
					node.objNArrTreeList.add(childNode);
					map1.put(parentElement, node);
				}
				map1.put(childElement, childNode);
			}
			
			for(int i=0; i<edge; i++) {
				parentElement = scan.nextInt();
				childElement = scan.nextInt();
				childNode = new NArrTree(childElement);
				if(i == 0) {
					root2 = new NArrTree(parentElement);
					root2.objNArrTreeList.add(childNode);
					map2.put(parentElement, root2);
				}
				else if(map2.containsKey(parentElement)) {
					map2.get(parentElement).objNArrTreeList.add(childNode);
				}
				else {
					node = new NArrTree(parentElement);
					node.objNArrTreeList.add(childNode);
					map2.put(parentElement, node);
				}
				map2.put(childElement, childNode);
			}
			System.out.println(checkMirror(root1, root2));
		}
		scan.close();
	}

	private static int checkMirror(NArrTree root1, NArrTree root2) {
		int prev = 0, next = 0, count = 0;
		List<Integer> delimitIndex1, delimitIndex2;
		List<Integer> elementList1 = new LinkedList<>();
		List<Integer> elementList2 = new LinkedList<>();
		delimitIndex1 = levelOrderTraversal(root1, elementList1);
		delimitIndex2 = levelOrderTraversal(root2, elementList2);
		if(elementList1.size() != elementList2.size())
			return 0;
		if(delimitIndex1.size() != delimitIndex2.size())
			return 0;
		for(int i=0; i<delimitIndex1.size(); i++) {
			if(delimitIndex1.get(i) != delimitIndex2.get(i))
				return 0;
		}
		next = delimitIndex1.get(count);
		for(int i=0; i<elementList1.size(); i++) {
			if(elementList1.get(i) != elementList2.get(--next))
				return 0;
			if(next == prev && i < elementList1.size() - 1) {
				prev = delimitIndex1.get(count);
				next = delimitIndex1.get(++count);
			}
				
		}
		return 1;
	}
	
	private static List<Integer> levelOrderTraversal(NArrTree root, List<Integer> elementList) {
		List<Integer> delimitIndex = new LinkedList<>();
		Queue<NArrTree> bfsQueue = new LinkedList<>();
		NArrTree node = null;
		bfsQueue.add(root);
		bfsQueue.add(null);
		while(!bfsQueue.isEmpty()) {
			node = bfsQueue.poll();
			if(node == null) {
				if(bfsQueue.isEmpty())
					break;
				else{
					bfsQueue.add(null);
					delimitIndex.add(elementList.size());
				}
			}
			else {
				elementList.add(node.data);
				if(node.objNArrTreeList.size() > 0) {
					for(NArrTree eachNArrTree : node.objNArrTreeList)
						bfsQueue.add(eachNArrTree);
				}
			}
		}
		delimitIndex.add(elementList.size());
		return delimitIndex;
	}
}

class NArrTree {
	int data;
	List<NArrTree> objNArrTreeList = new ArrayList<>();
	public NArrTree(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "NArrTree [data=" + data + ", objNArrTreeList=" + objNArrTreeList + "]";
	}
}
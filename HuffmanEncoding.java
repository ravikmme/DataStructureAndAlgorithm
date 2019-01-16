package main.java.com.rss.gfg.amazon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanEncoding {
	public static void main (String[] args) {
		int testCases;
		char[] charArr;
		String[] strArr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			for(int i=0; i<testCases; i++) {
				charArr = br.readLine().toCharArray();
				strArr = br.readLine().split("\\s+");
				hoffmanEncode(charArr, strArr);
				System.out.println();
			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void hoffmanEncode(char[] charArr, String[] strArr) {
		HuffNode firstHuffNode, secondHuffNode;
		PriorityQueue<HuffNode> huffNodePrQueue = new PriorityQueue<>(new Comparator<HuffNode>() {
			@Override
			public int compare(HuffNode o1, HuffNode o2) {
				/*boolean charFlagFirst = Character.isLetter(o1.vchar);
				boolean charFlagSecond = Character.isLetter(o2.vchar);
				if(o1.val == o2.val){
					if(charFlagFirst==true && charFlagSecond==false)
						return 1;
					if(charFlagFirst==false && charFlagSecond==true)
						return -1;
					return o1.val - o2.val;
				}
				else
					return o1.val - o2.val;*/
				
				if (o1.val < o2.val) {
				    return -1;
			    }
			    return 1;
					
//				return o1.val - o2.val;
					
				
			}
		});
		//		List<HuffNode> huffNodeList = new ArrayList<>();
		for(int i=0; i<charArr.length; i++)
			huffNodePrQueue.add(new HuffNode(charArr[i], Integer.parseInt(strArr[i])));
		//			huffNodeList.add(new HuffNode(charArr[i], Integer.parseInt(strArr[i])));

		while(huffNodePrQueue.size() > 1) {
			firstHuffNode = huffNodePrQueue.poll();
			secondHuffNode = huffNodePrQueue.poll();
			HuffNode objHuffNode = new HuffNode('-', firstHuffNode.val + secondHuffNode.val);
			objHuffNode.leftNode = firstHuffNode;
			objHuffNode.rightNode = secondHuffNode;
			huffNodePrQueue.add(objHuffNode);
		}
		printEncoding(huffNodePrQueue.poll(), "");
	}

	private static void printEncoding(HuffNode objHuffNode, String strCode) {

		if(objHuffNode.leftNode == null && objHuffNode.rightNode == null){
			if(Character.isLetter(objHuffNode.vchar))
				System.out.print(/*objHuffNode.vchar + " - " + */strCode.toString() + " ");
			return;
		}
		printEncoding(objHuffNode.leftNode, strCode + "0");
		printEncoding(objHuffNode.rightNode, strCode + "1");
	}
}

class HuffNode implements Comparable<HuffNode>{
	char vchar;
	int val;
	HuffNode leftNode;
	HuffNode rightNode;
	public HuffNode(char vchar, int val) {
		this.vchar = vchar;
		this.val = val;
	}
	@Override
	public int compareTo(HuffNode o) {
		return this.val - o.val;
	}
	@Override
	public String toString() {
		return "HuffNode [vchar=" + vchar + ", val=" + val + "]";
	}

}
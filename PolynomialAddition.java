package main.java.com.rss.gfg.amazon;

//import java.util.Comparator;
//import java.util.PriorityQueue;
import java.util.Scanner;

class PolynomialNode{
    int coeff;
    int pow;
    PolynomialNode next;
    PolynomialNode(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}
public class PolynomialAddition
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            PolynomialNode start1=null,cur1=null,start2=null,cur2=null;
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                PolynomialNode ptr=new PolynomialNode(a,b);
                if(start1==null)
                {
                    start1=ptr;
                    cur1=ptr;
                }
                else{
                    cur1.next=ptr;
                    cur1=ptr;
                }
            }
            n=sc.nextInt();
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                PolynomialNode ptr=new PolynomialNode(a,b);
                if(start2==null)
                {
                    start2=ptr;
                    cur2=ptr;
                }
                else{
                    cur2.next=ptr;
                    cur2=ptr;
                }
            }
//            GFG obj=new GFG();
//            obj.addPolynomial(start1,start2);
            addPolynomial1(start1,start2);
            System.out.println();
        }
        sc.close();
    }
    
    /*private static void addPolynomial(PolynomialNode p1,PolynomialNode p2){
    	PolynomialNode pFirstNode, pSecondNode, prevResultNode = null, head = null;
    	int coefficient;
    	PriorityQueue<PolynomialNode> pqFirst = new PriorityQueue<>(new Comparator<PolynomialNode>() {

			@Override
			public int compare(PolynomialNode o1, PolynomialNode o2) {
				return o2.pow-o1.pow;
			}
		});
    	PriorityQueue<PolynomialNode> pqSecond = new PriorityQueue<>(new Comparator<PolynomialNode>() {
    		
    		@Override
    		public int compare(PolynomialNode o1, PolynomialNode o2) {
    			return o2.pow-o1.pow;
    		}
    	});
    	PolynomialNode tempHead = p1;
    	while(tempHead != null) {
    		pqFirst.add(tempHead);
    		tempHead = tempHead.next;
    	}
    	tempHead = p2;
    	while(tempHead != null) {
    		pqSecond.add(tempHead);
    		tempHead = tempHead.next;
    	}
    	while(pqFirst.size() != 0 && pqSecond.size() != 0) {
    		pFirstNode = pqFirst.peek();
    		pSecondNode = pqSecond.peek();
    		if(pFirstNode.pow == pSecondNode.pow) {
    			pqFirst.poll();
    			pqSecond.poll();
    			coefficient = pFirstNode.coeff + pSecondNode.coeff;
    			if(prevResultNode != null) {
    				if(prevResultNode.pow == pFirstNode.pow){
    					prevResultNode.coeff += coefficient;
    				}
    				else {
    					prevResultNode.next = new PolynomialNode(coefficient, pFirstNode.pow);
    					prevResultNode = prevResultNode.next;
    				}
    			}
    			else {
    				prevResultNode = new PolynomialNode(coefficient, pFirstNode.pow);
    				head = prevResultNode;
    			}
    		}
    		else if(pFirstNode.pow > pSecondNode.pow) {
    			pqFirst.poll();
    			if(prevResultNode != null) {
    				if(prevResultNode.pow == pFirstNode.pow){
    					prevResultNode.coeff += pFirstNode.coeff;
    				}
    				else {
    					prevResultNode.next = pFirstNode;
    					prevResultNode = prevResultNode.next;
    				}
    			}
    			else {
    				prevResultNode = pFirstNode;
    				head = prevResultNode;
    			}
    		}
    		else {
    			pqSecond.poll();
    			if(prevResultNode != null) {
    				if(prevResultNode.pow == pSecondNode.pow){
    					prevResultNode.coeff += pSecondNode.coeff;
    				}
    				else {
    					prevResultNode.next = pSecondNode;
    					prevResultNode = prevResultNode.next;
    				}
    			}
    			else {
    				prevResultNode = pSecondNode;
    				head = prevResultNode;
    			}
    		}
    	}
    	if(pqFirst.size() != 0){
    		while(pqFirst.size() > 0) {
    			pFirstNode = pqFirst.poll();
    			if(prevResultNode != null) {
    				if(prevResultNode.pow == pFirstNode.pow){
    					prevResultNode.coeff += pFirstNode.coeff;
    				}
    				else {
    					prevResultNode.next = pFirstNode;
    					prevResultNode = prevResultNode.next;
    				}
    			}
    			else {
    				prevResultNode = pFirstNode;
    				head = prevResultNode;
    			}
    		}
    	}
    	else if(pqSecond.size() != 0) {
    		while(pqSecond.size() > 0) {
    			pSecondNode = pqSecond.poll();
    			if(prevResultNode != null) {
    				if(prevResultNode.pow == pSecondNode.pow){
    					prevResultNode.coeff += pSecondNode.coeff;
    				}
    				else {
    					prevResultNode.next = pSecondNode;
    					prevResultNode = prevResultNode.next;
    				}
    			}
    			else {
    				prevResultNode = pSecondNode;
    				head = prevResultNode;
    			}
    		}
    	}
    	prevResultNode = head;
    	while(prevResultNode != null) {
    		System.out.print(prevResultNode.coeff + "x^" + prevResultNode.pow);
    		if(prevResultNode.next != null)
    			System.out.print(" + ");
    		prevResultNode = prevResultNode.next;
    	}
    }*/
    
    private static void addPolynomial1(PolynomialNode p1,PolynomialNode p2){
    	int coefficient;
    	PolynomialNode pFirstNode, pSecondNode, prevResultNode = null, head = null;
    	while(p1 != null && p2 != null) {
    		pFirstNode = p1;
    		pSecondNode = p2;
    		if(pFirstNode.pow == pSecondNode.pow) {
    			coefficient = pFirstNode.coeff + pSecondNode.coeff;
    			if(prevResultNode != null) {
    				if(prevResultNode.pow == pFirstNode.pow) {
    					prevResultNode.coeff += coefficient;
    				}
    				else {
    					prevResultNode.next = new PolynomialNode(coefficient, pFirstNode.pow);
    					prevResultNode = prevResultNode.next;
    				}
    			}
    			else {
    				prevResultNode = new PolynomialNode(coefficient, pFirstNode.pow);
    				head = prevResultNode;
    			}
    			p1 = p1.next;
    			p2 = p2.next;
    		}
    		else if(pFirstNode.pow > pSecondNode.pow) {
    			if(prevResultNode != null) {
    				if(prevResultNode.pow == pFirstNode.pow){
    					prevResultNode.coeff += pFirstNode.coeff;
    				}
    				else {
    					prevResultNode.next = pFirstNode;
    					prevResultNode = prevResultNode.next;
    				}
    			}
    			else {
    				prevResultNode = pFirstNode;
    				head = prevResultNode;
    			}
    			p1 = p1.next;
    		}
    		else {
    			if(prevResultNode != null) {
    				if(prevResultNode.pow == pSecondNode.pow){
    					prevResultNode.coeff += pSecondNode.coeff;
    				}
    				else {
    					prevResultNode.next = pSecondNode;
    					prevResultNode = prevResultNode.next;
    				}
    			}
    			else {
    				prevResultNode = pSecondNode;
    				head = prevResultNode;
    			}
    			p2 = p2.next;
    		}
    		
    	}
    	while(p1 != null) {
			pFirstNode = p1;
			if(prevResultNode != null) {
				if(prevResultNode.pow == pFirstNode.pow){
					prevResultNode.coeff += pFirstNode.coeff;
				}
				else {
					prevResultNode.next = pFirstNode;
					prevResultNode = prevResultNode.next;
				}
			}
			else {
				prevResultNode = pFirstNode;
				head = prevResultNode;
			}
			p1 = p1.next;
		}
    	while(p2 != null) {
			pFirstNode = p2;
			if(prevResultNode != null) {
				if(prevResultNode.pow == pFirstNode.pow){
					prevResultNode.coeff += pFirstNode.coeff;
				}
				else {
					prevResultNode.next = pFirstNode;
					prevResultNode = prevResultNode.next;
				}
			}
			else {
				prevResultNode = pFirstNode;
				head = prevResultNode;
			}
			p2 = p2.next;
		}
    	prevResultNode = head;
    	while(prevResultNode != null) {
    		System.out.print(prevResultNode.coeff);
    		if(prevResultNode.pow != 0)
    			System.out.print("x^" + prevResultNode.pow);
    		if(prevResultNode.next != null)
    			System.out.print(" + ");
    		prevResultNode = prevResultNode.next;
    	}
    }
}
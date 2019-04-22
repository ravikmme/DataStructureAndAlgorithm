package main.java.com.rss.amazon;

import java.util.Scanner;

public class CircularTour {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j = 0;
			int k = 0;
			for (int i = 0; i < 2 * n; i++) {
				if (i % 2 == 0) {
					p[j] = Integer.parseInt(arr[i]);
					j++;
				} else {
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}

			System.out.println(tour(p, d));
//			System.out.println(tour_Rec(p, d));
			t--;
		}
		sc.close();
	}
	
	public static int tour_Rec(int petrol[], int distance[])
    {
		int diff, noOfPumps;
		boolean result;
		noOfPumps = petrol.length;
		for(int i=0; i<noOfPumps; i++) {
			diff = petrol[i] - distance[i];
			if(diff >= 0) {
				result = findCircularTourUtil(petrol, distance, noOfPumps, i+1, diff, 1);
				if(result) {
					return i;
				}
			}
		}
		return -1;
    }
	
	public static boolean findCircularTourUtil(int petrol[], int distance[], int noOfPumps, int index, int petrolLeft, int visited) {
		int diff;
		if(visited == noOfPumps)
			return true;
		diff = petrolLeft + petrol[index % noOfPumps];
		if(diff >=  distance[index % noOfPumps])
			return findCircularTourUtil(petrol, distance, noOfPumps, index+1, diff  - distance[index % noOfPumps], ++visited);
		else
			return false;
	}

	public static int tour(int petrol[], int distance[]) {
		int i;
		int noOfPumps = petrol.length;
		int petrolLeft = 0; 
		int startPostion = 0;
		for(i=0; i<noOfPumps; i++) {
			if(petrolLeft + petrol[i] >= distance[i])
				petrolLeft += petrol[i] - distance[i];
			else {
				petrolLeft = 0;
				startPostion = i + 1 < noOfPumps ? i + 1 : -1;
			}
		}
		if(startPostion == -1)
			return -1;
		else if(startPostion == 0)
			return startPostion;
		else {
			i = 0;
			while(i <= startPostion && petrolLeft + petrol[i] >= distance[i]) {
				petrolLeft += petrol[i] - distance[i];
				i++;
			}
			if(i - 1 == startPostion)
				return startPostion;
			else
				return -1;
		}
	}
}
package baekjoon.sj.divideAndConquer.p_2261;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

//2261
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		ArrayList<Pair> list = new ArrayList<>();
		while (testCase-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new Pair(x, y));
		}

		Collections.sort(list, new MySort());

		findMinDistance(list, 0, list.size());
	}

	public static int findMinDistance(ArrayList<Pair> list, int start, int end) {
		int mid = (start + end) / 2;
		System.out.println("start: "+ start);
		System.out.println("end: "+end);
		if(start  + 1 == end){
			return Integer.MAX_VALUE;
		}
		int leftDistance = findMinDistance(list, start, mid-1);
		int rightDistance = findMinDistance(list, mid, end);
		int minDistance = Math.min(leftDistance, rightDistance);
		
		
		System.out.println(list.get(mid).getX());
		System.out.println(list.get(mid).getY());
		
		return 0;
	}
}

class MySort implements Comparator<Pair>, Comparable<Pair> {

	@Override
	public int compare(Pair o1, Pair o2) {
		// TODO Auto-generated method stub
		if (o1.getX() != o2.getX()) {
			return o1.getX() - o2.getX();
		} else {
			return o1.getY() - o2.getY();
		}
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Pair {
	private int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

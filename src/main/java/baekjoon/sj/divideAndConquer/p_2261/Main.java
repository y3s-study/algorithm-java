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

		// for (Pair pair : list) {
		// System.out.println("x: "+pair.getX()+" y: "+pair.getY());
		// }

		System.out.println(findMinDistance(list, 0, list.size() - 1));
	}

	static public long distance(ArrayList<Pair> list, int a, int b) {
		// System.out.println("x: "+ xDistance(list, a, b));
		// System.out.println("y: "+ yDistance(list, a, b));
		return xDistance(list, a, b) + yDistance(list, a, b);
	}

	public static long xDistance(ArrayList<Pair> list, int a, int b) {
		// System.out.println("list.get(a).getX(): "+list.get(a).getX());
		// System.out.println("list.get(b).getX(): "+ list.get(b).getX());
		// System.out.println("Math.pow(list.get(a).getX() - list.get(b).getX(), 2): "+
		// Math.pow(list.get(a).getX() - list.get(b).getX(), 2));
		return (long) (Math.pow(list.get(a).getX() - list.get(b).getX(), 2));
	}

	public static long yDistance(ArrayList<Pair> list, int a, int b) {
		// System.out.println("Math.pow(list.get(a).getY() - list.get(b).getY(), 2): "+Math.pow(list.get(a).getY()
		// - list.get(b).getY(), 2));
		return (long) (Math.pow(list.get(a).getY() - list.get(b).getY(), 2));
	}

	public static long findMinDistance(ArrayList<Pair> list, int start, int end) {

		// System.out.println("before start: " + start + " end: " + end);
		int mid = (start + end) / 2;
		if (start + 1 == end) {
			// System.out.println(distance(list, start, end));
			return distance(list, start, end);
		}
		if (start == end) {
			// System.out.println(distance(list, start, end));
			return Integer.MAX_VALUE;
		}
		// divide
		long leftDistance = findMinDistance(list, start, mid);
		long rightDistance = findMinDistance(list, mid + 1, end);
		// System.out.println("leftDistance: " + leftDistance);
		// System.out.println("rightDistance: " + rightDistance);
		long minDistance = Math.min(leftDistance, rightDistance);

		// System.out.println("list.get(mid).getX(): " + list.get(mid).getX());
		// System.out.println("list.get(mid).getY(): " + list.get(mid).getY());
		// System.out.println("before minDistance: " + minDistance);
		// conquer
		// System.out.println("conquer start: " + start + " end: " + end);
		for (int i = start; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				// System.out.println("i: "+i+" j: "+j);
				long yDistance = yDistance(list, i, j);
				// System.out.println("yDistance: "+yDistance);
				if (minDistance > yDistance(list, i, j)) {
					minDistance = distance(list, i, j);
				} else {
					break;
				}
			}
		}
		// System.out.println("after minDistance: " + minDistance);
		return minDistance;
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

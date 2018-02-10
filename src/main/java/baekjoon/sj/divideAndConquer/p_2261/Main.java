package baekjoon.sj.divideAndConquer.p_2261;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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

		Collections.sort(list, new xSort());
		System.out.println(findMinDistance(list, 0, list.size() - 1));
	}

	static public long distance(ArrayList<Pair> list, int a, int b) {
		return xDistance(list, a, b) + yDistance(list, a, b);
	}

	public static long xDistance(ArrayList<Pair> list, int a, int b) {
		return (long) (Math.pow(list.get(a).getX() - list.get(b).getX(), 2));
	}

	public static long yDistance(ArrayList<Pair> list, int a, int b) {
		return (long) (Math.pow(list.get(a).getY() - list.get(b).getY(), 2));
	}

	public static long findMinDistance(ArrayList<Pair> list, int start, int end) {
		int mid = (start + end) / 2;

		if (start + 1 == end) {
			return distance(list, start, end);
		}

		if (start == end) {
			return Integer.MAX_VALUE;
		}

		// divide
		long leftDistance = findMinDistance(list, start, mid);
		long rightDistance = findMinDistance(list, mid + 1, end);
		long minDistance = Math.min(leftDistance, rightDistance);

		// conquer
		minDistance = Math.min(minDistance, minYDistanc(list, start, end));

		return minDistance;
	}

	public static long minYDistanc(ArrayList<Pair> list, int start, int end) {
		ArrayList<Pair> subList = new ArrayList<>(list.subList(start, end));
		Collections.sort(subList, new ySort());
		long minDistance = Long.MAX_VALUE;

		for (int i = 0; i < subList.size() - 1; i++) {
			for (int j = i + 1; j < subList.size() && j <= i + 1000; j++) {
				long yDistance = yDistance(subList, i, j);
				if (minDistance > yDistance) {
					minDistance = Math.min(minDistance, distance(subList, i, j));
				} else {
					break;
				}
			}
		}
		return minDistance;
	}
}

class xSort implements Comparator<Pair> {
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.getX() != o2.getX()){
			return o1.getX() - o2.getX();
		}else{
			return o1.getY() - o2.getY();
		}
	}
}

class ySort implements Comparator<Pair> {
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.getY() != o2.getY()){
			return o1.getY() - o2.getY();
		}else{
			return o1.getX() - o2.getX();
		}
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

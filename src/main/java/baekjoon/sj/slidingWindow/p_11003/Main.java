package baekjoon.sj.slidingWindow.p_11003;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//11003
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[] arr = new int[N];

		Deque<Pair> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			while (!dq.isEmpty() && dq.getFirst().getIndex() < i - L + 1) {
				dq.removeFirst();
			}
			while (!dq.isEmpty() && dq.getLast().getValue() >= arr[i]) {
				dq.removeLast();
			}
			dq.add(new Pair(i, arr[i]));
			sb.append(dq.getFirst().getValue() + " ");
		}
		System.out.println(sb);
	}
}

class Pair {
	private int index;
	private int value;

	Pair(int index, int value) {
		this.index = index;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public int getValue() {
		return value;
	}
}
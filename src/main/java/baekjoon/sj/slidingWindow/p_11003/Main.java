package baekjoon.sj.slidingWindow.p_11003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//11003
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Pair> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
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
package baekjoon.sj.dynamic2.p_2342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2342
 * Dance Dance Revolution
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		Pair pair = new Pair(0, 0, 0);

		while (st.hasMoreElements()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		int[][][] cost = new int[5][5][100000];
		System.out.println(findMinSumOfDDR(list, pair, cost, 0));

	}

	private static int findMinSumOfDDR(ArrayList<Integer> list, Pair pair, int[][][] cost, int visited) {
		int left = pair.getLeft();
		int right = pair.getRight();
		int position = pair.getPosition();
		int leftMove = Integer.MAX_VALUE, rightMove = Integer.MAX_VALUE;
		int index = list.get(position);

		if (index == 0) {
			return 0;
		}

		if (cost[left][right][visited] != 0 || cost[right][left][visited] != 0) {
			return cost[left][right][visited];
		}

		// left move
		if ((left == 0 && right == 0) || index != right) {
			leftMove = findMinSumOfDDR(list, new Pair(index, right, position + 1), cost, visited + 1) + calcMoveCost(left, index);
		}

		// right move
		if ((left == 0 && right == 0) || index != left) {
			rightMove = findMinSumOfDDR(list, new Pair(left, index, position + 1), cost, visited + 1) + calcMoveCost(right, index);
		}

		return cost[right][left][visited] = cost[left][right][visited] = Integer.min(leftMove, rightMove);
	}

	private static int calcMoveCost(int value, int index) {
		int result = 0;
		if (value == 0) {
			result = 2; // init middle
		} else if (value == index) {
			result = 1; // hold
		} else if (Math.abs(value - index) == 2) {
			result = 4; // opposite
		} else {
			result = 3; // side
		}
		return result;
	}
}

class Pair {
	private int left;
	private int right;
	private int position;

	Pair(int left, int right, int position) {
		this.left = left;
		this.right = right;
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}
}

package baekjoon.sj.dynamic.p_2342;

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
		System.out.println(findMinSumOfDDR(list, pair, 0));

	}

	private static int findMinSumOfDDR(ArrayList<Integer> list, Pair pair, int sum) {
		int left = pair.getLeft();
		int right = pair.getRight();
		int position = pair.getPosition();
		int leftMove = Integer.MAX_VALUE, rightMove = Integer.MAX_VALUE;
		int tempSum = 0;
		int index = list.get(position);

		// System.out.println("left: " + left + " right: " + right +
		// " position: " + position + " index: " + index + " sum: " + sum);

		if (index == 0) {
			return sum;
		}
		// left move
		if (left == 0) {
			// init middle
			tempSum = sum + 2;
		} else if (left == index) {
			// hold
			tempSum = sum + 1;
		} else if (left == index - 1 || left == (index + 1) % 4) {
			// side
			tempSum = sum + 3;
		} else if (left == (index + 2) % 4) {
			// opposite
			tempSum = sum + 4;
		}

		if ((left == 0 && right == 0) || left != right) {
			leftMove = findMinSumOfDDR(list, new Pair(index, right, position + 1), tempSum);
		}

		tempSum = 0;
		// right move
		if (right == 0) {
			// init middle
			tempSum = sum + 2;
		} else if (right == index) {
			// hold
			tempSum = sum + 1;
		} else if (right == index - 1 || right == (index + 1) % 4) {
			// side
			tempSum = sum + 3;
		} else if (right == (index + 2) % 4) {
			// opposite
			tempSum = sum + 4;
		}
		if ((left == 0 && right == 0) || left != right) {
			rightMove = findMinSumOfDDR(list, new Pair(left, index, position + 1), tempSum);
		}

		return Integer.min(leftMove, rightMove);
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

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

		int[][] cost = new int[list.size()][1 << list.size()];
		System.out.println(findMinSumOfDDR(list, pair, 0, cost, 0, 0, 0));

	}

	private static int findMinSumOfDDR(ArrayList<Integer> list, Pair pair, int sum, int[][] cost, int leftVisited, int rightVisited, int visited) {
		int left = pair.getLeft();
		int right = pair.getRight();
		int position = pair.getPosition();
		int leftMove = Integer.MAX_VALUE, rightMove = Integer.MAX_VALUE;
		int tempSum = 0;
		int index = list.get(position);

		System.out.println("left: " + left + " right: " + right + " position: " + position + " index: " + index + " sum: " + sum + " visited: "
				+ visited + " leftVisited: " + leftVisited + " rightVisited: " + rightVisited);
		
		if (index == 0) {
			return cost[position][visited] = sum;
		}

//		if (cost[leftVisited][rightVisited][visited] != 0) {
//			return cost[leftVisited][rightVisited][visited];
//		}

		// left move
		if (left == 0) {
			tempSum = sum + 2; // init middle
		} else if (left == index) {
			tempSum = sum + 1; // hold
		} else if (left == index - 1 || left == (index + 1) % 4) {
			tempSum = sum + 3; // side
		} else if (left == (index + 2) % 4) {
			tempSum = sum + 4; // opposite
		}
		if ((left == 0 && right == 0) || index != right) {
			leftMove = findMinSumOfDDR(list, new Pair(index, right, position + 1), tempSum, cost, leftVisited + 1, rightVisited, visited
					| (1 << position));
//			System.out.println("leftMove: " + leftMove);
		}

		tempSum = 0;
		// right move
		if (right == 0) {
			tempSum = sum + 2; // init middle
		} else if (right == index) {
			tempSum = sum + 1; // hold
		} else if (right == index - 1 || right == (index + 1) % 4) {
			tempSum = sum + 3; // side
		} else if (right == (index + 2) % 4) {
			tempSum = sum + 4; // opposite
		}
		if ((left == 0 && right == 0) || left != index) {
			rightMove = findMinSumOfDDR(list, new Pair(left, index, position + 1), tempSum, cost, leftVisited, rightVisited + 1, visited
					| (1 << position));
//			System.out.println("rightMove: " + rightMove);
		}

		return cost[position][visited] = Integer.min(leftMove, rightMove);
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

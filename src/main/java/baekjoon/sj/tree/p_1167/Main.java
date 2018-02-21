package baekjoon.sj.tree.p_1167;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1167
public class Main {
	static int maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int[][] weight = new int[v][v];
		sc.nextLine();
//		sc.nextLine();
		while (v-- > 0) {
			String[] input = sc.nextLine().split(" ");
			int row = Integer.parseInt(input[0]) - 1;
			for (int i = 1; i < input.length - 1; i = i + 2) {
				int col = Integer.parseInt(input[i]) - 1;
				int value = Integer.parseInt(input[i + 1]);
				weight[row][col] = value;
				weight[col][row] = value;
			}
//			if (v > 0) {
//				sc.nextLine();
//			}
		}

		findTreeDiameter(weight);

		System.out.println(maxValue);
	}

	static void findTreeDiameter(int[][] weight) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visit = new boolean[weight.length][weight.length];

		// add all node
		for (int i = 0; i < weight.length; i++) {
			queue.add(new Node(i, 0, i));
		}

		while (!queue.isEmpty()) {
			int row = queue.peek().getNode();
			int accumWeight = queue.peek().getWeight(); // accumulateWeight
			int startNode = queue.poll().getStartNode();

			visit[startNode][row] = true;
			for (int i = 0; i < weight.length; i++) {
				if (weight[row][i] != 0 && visit[startNode][i] == false) {
					queue.add(new Node(i, accumWeight + weight[row][i], startNode));
					if (maxValue < accumWeight + weight[row][i]) {
						maxValue = accumWeight + weight[row][i];
					}
				}
			}
		}

	}
}

class Node {
	private int node;
	private int weight;
	private int startNode;

	Node(int node, int weight, int startNode) {
		this.node = node;
		this.weight = weight;
		this.startNode = startNode;
	}

	public int getNode() {
		return node;
	}

	public int getWeight() {
		return weight;
	}

	public int getStartNode() {
		return startNode;
	}

}

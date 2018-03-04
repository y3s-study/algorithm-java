package baekjoon.sj.graph.p_1753;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1753
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int k = sc.nextInt(); // start Number
		ArrayList<ArrayList<Node>> list = new ArrayList<>();

		for (int i = 0; i <= v; i++) {
			list.add(new ArrayList<>());
		}

		while (e-- > 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int weight = sc.nextInt();
			list.get(row).add(new Node(col, weight));
		}

		int[] visit = findMinWeight(list, k);
		for (int i = 1; i < visit.length; i++) {
			if (visit[i] != -1) {
				System.out.println(visit[i]);
			} else {
				System.out.println("INF");
			}

		}
	}

	static int[] findMinWeight(ArrayList<ArrayList<Node>> list, int k) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(k, 0));
		int[] visit = new int[list.size()];
		Arrays.fill(visit, -1);

		while (!queue.isEmpty()) {
			int row = queue.peek().getRow();
			int accWeight = queue.poll().getWeight();

			ArrayList<Node> rowList = list.get(row);
			for (int i = 0; i < rowList.size(); i++) {
				if (visit[rowList.get(i).getRow()] == -1 || accWeight + rowList.get(i).getWeight() < visit[rowList.get(i).getRow()]) {
					queue.add(new Node(rowList.get(i).getRow(), accWeight + rowList.get(i).getWeight()));
					visit[rowList.get(i).getRow()] = accWeight + rowList.get(i).getWeight();
				}
			}
		}
		visit[k] = 0;
		return visit;
	}
}

class Node {
	private int row;
	private int weight;

	Node(int row, int weight) {
		this.row = row;
		this.weight = weight;
	}

	public int getRow() {
		return row;
	}

	public int getWeight() {
		return weight;
	}
}

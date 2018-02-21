package baekjoon.sj.tree.p_1167;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1167
public class Main {
	static int maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<ArrayList<Node>> list = new ArrayList<>(v);

		for (int i = 0; i < v; i++) {
			list.add(new ArrayList<>());
		}

		sc.nextLine();
		// sc.nextLine();
		while (v-- > 0) {
			String[] input = sc.nextLine().split(" ");
			int row = Integer.parseInt(input[0]) - 1;
			for (int i = 1; i < input.length - 1; i = i + 2) {
				int col = Integer.parseInt(input[i]) - 1;
				int value = Integer.parseInt(input[i + 1]);
				list.get(row).add(new Node(col, value, col));
			}
			// if (v > 0) {
			// sc.nextLine();
			// }
		}

		findTreeDiameter(list);

		System.out.println(maxValue);
	}

	static void findTreeDiameter(ArrayList<ArrayList<Node>> list) {
		Queue<Node> queue = new LinkedList<>();

		// add all node
		for (int i = 0; i < list.size(); i++) {
			queue.add(new Node(i, 0, -1));
		}
		
		while (!queue.isEmpty()) {
			int row = queue.peek().getNode();
			int accumWeight = queue.peek().getWeight(); // accumulateWeight
			int parent = queue.poll().getParent();
			// System.out.println("row: " + row + " accumWeight: " + accumWeight
			// + " parent: " + parent);
			// System.out.println("list.get(row).size(): "+list.get(row).size());
			for (int i = 0; i < list.get(row).size(); i++) {
				if (list.get(row).get(i).getParent() != parent) {
					// System.out.println("add queue row: "+list.get(row).get(i).getNode());
					queue.add(new Node(list.get(row).get(i).getNode(), accumWeight + list.get(row).get(i).getWeight(), row));
					if (maxValue < accumWeight + list.get(row).get(i).getWeight()) {
						maxValue = accumWeight + list.get(row).get(i).getWeight();
					}
				}
			}
		}
	}
}

class Node {
	private int node;
	private int weight;
	private int parent; // -1: no parent

	Node(int node, int weight, int parent) {
		this.node = node;
		this.weight = weight;
		this.parent = parent;
	}

	public int getParent() {
		return parent;
	}

	public int getNode() {
		return node;
	}

	public int getWeight() {
		return weight;
	}

}

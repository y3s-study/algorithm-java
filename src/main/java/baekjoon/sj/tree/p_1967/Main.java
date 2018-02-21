package baekjoon.sj.tree.p_1967;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1967
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<ArrayList<Node>> list = new ArrayList<>(v);

		for (int i = 0; i < v; i++) {
			list.add(new ArrayList<>());
		}

		sc.nextLine();
		while (v-- > 1) {
			String[] input = sc.nextLine().split(" ");
			int row = Integer.parseInt(input[0]) - 1;
			int col = Integer.parseInt(input[1]) - 1;
			int value = Integer.parseInt(input[2]);
			list.get(row).add(new Node(col, value, col));
			list.get(col).add(new Node(row, value, row));
		}

		System.out.println(findTreeDiameter(list, -1));
	}

	/*
	 * find Number 
	 * -1: return Node 
	 * etc: return Diameter
	 */
	static int findTreeDiameter(ArrayList<ArrayList<Node>> list, int findNumber) {
		Queue<Node> queue = new LinkedList<>();
		int maxValue = Integer.MIN_VALUE;

		if (findNumber == -1) {
			queue.add(new Node(0, 0, -1));
		} else {
			queue.add(new Node(findNumber, 0, -1));
		}
		int node = -1;
		while (!queue.isEmpty()) {
			int row = queue.peek().getNode();
			int accumWeight = queue.peek().getWeight(); // accumulateWeight
			int parent = queue.poll().getParent();
			for (int i = 0; i < list.get(row).size(); i++) {
				if (list.get(row).get(i).getParent() != parent) {
					queue.add(new Node(list.get(row).get(i).getNode(), accumWeight + list.get(row).get(i).getWeight(), row));
					if (maxValue < accumWeight + list.get(row).get(i).getWeight()) {
						maxValue = accumWeight + list.get(row).get(i).getWeight();
						node = list.get(row).get(i).getNode();
					}
				}
			}
		}

		if (findNumber == -1) {
			return findTreeDiameter(list, node);
		} else {
			return maxValue;
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

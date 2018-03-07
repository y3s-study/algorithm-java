package baekjoon.sk.shortPath.p_1753;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt();
		int e = sc.nextInt();

		int startV = sc.nextInt();

		ArrayList<Node>[] list = new ArrayList[v + 1];

		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<Node>();
		}

		int[] result = new int[v + 1];

		for (int i = 0; i < v + 1; i++)
			result[i] = 11;

		for (int i = 0; i < e; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();

			list[start].add(new Node(end, weight));
		}

		dfs(startV, list, 0, result);

		System.out.println("" + 0);
		for (int i = 2; i < v + 1; i++) {
			if (result[i] == 11)
				System.out.println("INF");
			else
				System.out.println(result[i]);
		}

	}

	static void dfs(int startV, ArrayList<Node>[] list, int pre, int[] result) {

		if (pre < result[startV])
			result[startV] = pre;

		for (int i = 0; i < list[startV].size(); i++) {
			dfs(list[startV].get(i).end, list,
					result[startV] + list[startV].get(i).weight, result);
		}

		return;

	}

	static class Node {
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}

}

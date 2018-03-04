package baekjoon.sk.tree.p_1167;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int v, u, u2, r;
	static int[] dist;
	static int[] visit;
	static ArrayList<Node>[] adj;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		adj = (ArrayList<Node>[]) new ArrayList[10001];

		dist = new int[10001];
		visit = new int[10001];

		for (int i = 1; i <= 10000; i++) {
			adj[i] = new ArrayList<>();
		}

		int n = scanner.nextInt();

		boolean pass_tag = true;

		for (int i = 1; i < n + 1; i++) {
			int parent = scanner.nextInt();

			while (true) {
				int child = scanner.nextInt();
				if (child == -1)
					break;
				int weight = scanner.nextInt();

				for (Node tmp : adj[parent]) {
					if (tmp.data == child && tmp.weight == weight) {
						pass_tag = false;
					}
				}
				if (pass_tag) {
					adj[parent].add(new Node(child, weight));
				}

				pass_tag = true;

				for (Node tmp : adj[child]) {
					if (tmp.data == parent && tmp.weight == weight) {
						pass_tag = false;
					}
				}
				if (pass_tag) {
					adj[child].add(new Node(parent, weight));
				}

				pass_tag = true;

			}
		}

		r = 0;
		u2 = 0;

		for (int i = 1; i < n + 1; i++) {
			dfs(i, 0);
			if (u > u2)
				u2 = u;

			r = 0;
			dist = new int[10001];
			visit = new int[10001];
		}

		r = 0;
		dist = new int[10001];
		visit = new int[10001];

		dfs(u2, 0);

		System.out.println(r);

	}

	static void dfs(int v, int d) {

		dist[v] = d;
		visit[v] = 1;

		if (dist[v] > r) {
			r = dist[v];
			u = v;
		}

		for (Node node : adj[v]) {
			int next = node.data;
			int weight = node.weight;

			if (dist[next] == 0 && visit[next] != 1) {
				dfs(next, d + weight);
			}

		}

	}

	static class Node {
		int data;
		int weight;

		Node(int data, int weight) {
			this.data = data;
			this.weight = weight;
		}
	}

}

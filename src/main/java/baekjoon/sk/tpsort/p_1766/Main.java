package baekjoon.sk.tpsort.p_1766;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertexCnt = sc.nextInt();
		int edgeCnt = sc.nextInt();

		int[] indegree = new int[vertexCnt + 1];
		ArrayList<Integer>[] list = new ArrayList[vertexCnt + 1];

		for (int i = 1; i <= vertexCnt; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < edgeCnt; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			list[start].add(end);
			indegree[end]++;

		}

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		for (int i = 1; i <= vertexCnt; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int current = q.poll();
			System.out.print(current + " ");
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				indegree[next]--;
				if (indegree[next] == 0) {
					q.add(next);
				}
			}
		}

	}

}

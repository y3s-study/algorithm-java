package baekjoon.sj.graph.p_1766;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//1766
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int[] indegree = new int[n + 1];
		while (m-- > 0) {
			int after = sc.nextInt();
			int before = sc.nextInt();
			list.get(after).add(before);
			indegree[before]++;
		}
		ArrayList<Integer> resultList = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		findBeforeWorkBook(list, queue, indegree, resultList);

		printResult(resultList);
	}

	private static void printResult(ArrayList<Integer> resultList) {
		StringBuilder sb = new StringBuilder();
		for (Integer integer : resultList) {
			sb.append(integer + " ");
		}
		System.out.println(sb.toString());
	}

	static void findBeforeWorkBook(ArrayList<ArrayList<Integer>> list, PriorityQueue<Integer> queue, int[] indegree, ArrayList<Integer> resultList) {
		while (!queue.isEmpty()) {
			int position = queue.poll();
			resultList.add(position);
			int before = 0;
//			for (int i = 0; i < list.get(position).size(); i++) {
				before = list.get(position).get(0);
				indegree[before]--;
				if (indegree[before] == 0) {
					queue.add(before);
				}
//			}
		}
	}
}

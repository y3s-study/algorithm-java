package baekjoon.sj.queue.p_1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1260
public class Main {
	static int[][] arr;
	static int[] visitDFS;
	static int[] visitBFS;
	static Queue<Integer> queueDFS = new LinkedList<>();
	static Queue<Integer> queueBFS = new LinkedList<>();

	static void DFS(int row, int col) {
		visitDFS[row] = 1;
		queueDFS.offer(row + 1);
		for (int i = 0; i < arr.length; i++) {
			if (arr[row][i] == 1 && visitDFS[i] != 1) {
				DFS(i, 0);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		arr = new int[n][n];
		visitDFS = new int[n];
		visitBFS = new int[n];
		int row, col;
		for (int i = 0; i < m; i++) {
			row = sc.nextInt() - 1;
			col = sc.nextInt() - 1;
			arr[row][col] = 1;
			arr[col][row] = 1;
		}

		DFS(v - 1, 0);
		while (!queueDFS.isEmpty()) {
			System.out.print(queueDFS.poll() + " ");
		}
		System.out.println();
		BFS(v - 1, 0);
		while (!queueBFS.isEmpty()) {
			System.out.print(queueBFS.poll() + " ");
		}
	}

	public static void BFS(int row, int col) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(row);

		while (!queue.isEmpty()) {
			row = queue.poll();
			queueBFS.offer(row + 1);
			visitBFS[row] = 1;
			for (int i = 0; i < arr.length; i++) {
				if (arr[row][i] == 1 && visitBFS[i] != 1) {
					visitBFS[i] = 1;
					queue.offer(i);
				}
			}
		}
	}
}

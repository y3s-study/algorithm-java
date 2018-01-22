package baekjoon.sk.dynamic.p_1005;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCase = scanner.nextInt();

		scanner.nextLine();

		while (testCase-- > 0) {

			int N = scanner.nextInt();

			int K = scanner.nextInt();

			scanner.nextLine();

			String[] time = scanner.nextLine().split(" ");

			int[] accumulatedValue = new int[N];

			int[][] conn = new int[N][N];

			for (int i = 0; i < K; i++) {

				int x = scanner.nextInt();
				int y = scanner.nextInt();

				scanner.nextLine();

				conn[x - 1][y - 1] = 1;
				conn[y - 1][x - 1] = 1;

			}

			Queue<Integer> q = new LinkedList<Integer>();

			accumulatedValue[0] = Integer.parseInt(time[0]);

			for (int i = 0; i < N; i++) {
				if (conn[0][i] == 1) {
					accumulatedValue[i] = accumulatedValue[0]
							+ Integer.parseInt(time[i]);
					conn[i][0] = 0;
					q.offer(i);
				}
			}

			while (!q.isEmpty()) {

				for (int i = 0; i < N; i++) {
					if (conn[q.peek()][i] == 1) {
						accumulatedValue[i] = ((accumulatedValue[i] > accumulatedValue[q.peek()] + Integer.parseInt(time[i]))?accumulatedValue[i]:accumulatedValue[q.peek()] + Integer.parseInt(time[i]));
						conn[i][q.peek()] = 0;
						q.offer(i);
					}
				}

				q.poll();

			}

			int goal = scanner.nextInt();

			System.out.println(accumulatedValue[goal - 1]);

		}

	}

}

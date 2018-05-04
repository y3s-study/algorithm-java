package baekjoon.sj.backtracking.p_9663;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/9663
 * N-Queen
 */
public class Main {
	static int cnt = 0;
	static int n = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		boolean[][] visited = new boolean[n][n];

		for (int j = 0; j < n; j++) {
			visited[0][j] = true;
			findNoneAttackCnt(visited, 1, j);
			visited[0][j] = false;
		}
		System.out.println(cnt);
	}

	static int[][] attackRange = { 
//			{ 0, 1 }, 
			{ 1, 1 }, 
			{ 1, 0 }, 
			{ 1, -1 }, 
//			{ 0, -1 }, 
			{ -1, -1 }, 
			{ -1, 0 }, 
			{ -1, 1 } 
		};

	private static void findNoneAttackCnt(boolean[][] visited, int nCnt, int index) {

		int row = index / n;

		if (n == nCnt) {
			cnt++;
			// for (int i = 0; i < n; i++) {
			// for (int j = 0; j < n; j++) {
			// if (visited[i][j] == true) {
			// System.out.print("1 ");
			// } else {
			// System.out.print("0 ");
			// }
			// }
			// System.out.println();
			// }
			return;
		}

		if (isOutOfArrayIndex(row + 1, 0, visited)) {
			return;
		}

		for (int j = 0; j < n; j++) {
			index = (row + 1) * n + j;

			if (checkPosition(row + 1, j, visited) == true && visited[row + 1][j] == false) {
				visited[row + 1][j] = true;
				findNoneAttackCnt(visited, nCnt + 1, index);
				visited[row + 1][j] = false;
			}
		}
	}

	private static boolean checkPosition(int row, int col, boolean[][] visited) {
		boolean checkPosition = true;
		for (int k = 0; k < attackRange.length && checkPosition; k++) {
			int nextRow = row + attackRange[k][0];
			int nextCol = col + attackRange[k][1];
			while (!isOutOfArrayIndex(nextRow, nextCol, visited)) {
				if (visited[nextRow][nextCol] == true) {
					checkPosition = false;
					break;
				}
				nextRow += attackRange[k][0];
				nextCol += attackRange[k][1];
			}
		}
		return checkPosition;
	}

	private static boolean isOutOfArrayIndex(int nextRow, int nextCol, boolean[][] visited) {
		return (nextRow >= visited.length || nextRow < 0 || nextCol >= visited[0].length || nextCol < 0);
	}
}

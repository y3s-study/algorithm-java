package baekjoon.sj.backtracking.p_2580;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2580
 * 스토쿠
 */
public class Main {
	static int N = 9;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		makeSudoku(arr);
		printArr(arr);
	}

	private static void printArr(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void makeSudoku(int[][] arr) {
		boolean[] visited = new boolean[N];

		checkRow(arr, visited);
		checkCol(arr, visited);
		checkRow(arr, visited);

		checkSquare(arr, visited);
	}

	private static void checkSquare(int[][] arr, boolean[] visited) {
		int cnt = 0;
		int x = 0, y = 0;
		for (int i = 0; i < N / 3; i++) {
			for (int j = 0; j < N / 3; j++) {
				cnt = 0;
				Arrays.fill(visited, false);
				for (int row = i * 3; row < (i + 1) * 3; row++) {
					for (int col = j * 3; col < (j + 1) * 3; col++) {
						if (arr[row][col] != 0) {
							visited[arr[row][col] - 1] = true;
						} else {
							cnt++;
							x = row;
							y = col;
						}
					}
				}

				if (cnt == 1) {
					for (int col = 0; col < N; col++) {
						if (visited[col] == false) {
							arr[x][y] = col + 1;
							break;
						}
					}
				}
			}
		}
	}

	private static void checkCol(int[][] arr, boolean[] visited) {
		int cnt = 0;
		int number = 0;
		for (int i = 0; i < N; i++) {
			cnt = 0;
			Arrays.fill(visited, false);
			for (int j = 0; j < N; j++) {
				if (arr[j][i] != 0) {
					visited[arr[j][i] - 1] = true;
				} else {
					cnt++;
					number = j;
				}
			}

			if (cnt == 1) {
				for (int j = 0; j < N; j++) {
					if (visited[j] == false) {
						arr[number][i] = j + 1;
						break;
					}
				}
			}
		}
	}

	private static void checkRow(int[][] arr, boolean[] visited) {
		int cnt = 0;
		int number = 0;
		for (int i = 0; i < N; i++) {
			cnt = 0;
			Arrays.fill(visited, false);
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != 0) {
					visited[arr[i][j] - 1] = true;
				} else {
					cnt++;
					number = j;
				}
			}

			if (cnt == 1) {
				for (int j = 0; j < N; j++) {
					if (visited[j] == false) {
						arr[i][number] = j + 1;
						break;
					}
				}
			}
		}
	}
}

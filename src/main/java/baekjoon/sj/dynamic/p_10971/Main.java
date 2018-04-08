package baekjoon.sj.dynamic.p_10971;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/10971
 * 외판원 순회 2
 */
public class Main {
	static int minCharge = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		findMinCharge(arr, new boolean[n], 0, 0, 1, 0);
		System.out.println(minCharge);
	}

	private static void findMinCharge(int[][] arr, boolean[] visit, int row, int col, int cnt, int sum) {
		visit[row] = true;
		if (cnt == arr.length) {
			minCharge = Integer.min(sum + arr[row][col], minCharge);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visit[i] == false && arr[row][i] != 0) {
				if (minCharge > sum + arr[row][i]) {
					findMinCharge(arr, visit, i, 0, cnt + 1, sum + arr[row][i]);
					visit[i] = false;
				}
			}
		}
	}
}

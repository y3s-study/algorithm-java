package baekjoon.sj.dynamic.p_2098;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2098
 * 외판원 순회
 */
public class Main {
	static int sum = 0;
	static int minCharge = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		boolean[][] visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[0][i] != 0) {
				// visit[i][0] = true;
				// sum = arr[0][i];
				findMinCharge(arr, visit[i], 0, i, 1);
				// System.out.println("sum: "+sum);
			}
		}
		System.out.println(minCharge);
	}

	private static void findMinCharge(int[][] arr, boolean[] visit, int row, int col, int cnt) {
		// System.out.println("row: " + row + " col: " + col);
		// System.out.println("sum: "+sum);
		visit[row] = true;
		if (cnt == arr.length) {
			minCharge = Integer.min(sum + arr[row][col], minCharge);
			// System.out.println("sum: " + (sum+arr[row][col]));
		}

		for (int i = 0; i < arr.length; i++) {
			if (visit[i] == false && arr[row][i] != 0) {
				// System.out.println("arr[" + row + "][" + i + "]: " +
				// arr[row][i]);
				sum += arr[row][i];
				// System.out.println("enter row: " + i + " col: " + 0);
				findMinCharge(arr, visit, i, 0, cnt + 1);
				sum -= arr[row][i];
			}
		}
		visit[row] = false;
	}
}

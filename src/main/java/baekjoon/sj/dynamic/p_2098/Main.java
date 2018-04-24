package baekjoon.sj.dynamic.p_2098;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2098
 * 외판원 순회 1
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int[][] distance = new int[n][1 << n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println(findMinCharge(arr, distance, 0, 1));
	}

	private static int findMinCharge(int[][] arr, int[][] distance, int currentCity, int visited) {
		if (visited == (1 << arr.length) - 1) {
			return arr[currentCity][0];
		}

		if (distance[currentCity][visited] != 0) {
			return distance[currentCity][visited];
		}

		// int minCharge = Integer.MAX_VALUE;
		int minCharge = 987654321;
		for (int i = 0; i < arr.length; i++) {
			if ((visited & (1 << i)) == 0 && arr[currentCity][i] != 0) {
				minCharge = Integer.min(minCharge, arr[currentCity][i] + findMinCharge(arr, distance, i, visited | (1 << i)));
			}
		}

		return distance[currentCity][visited] = minCharge;
	}
}

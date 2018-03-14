package baekjoon.sj.slidingWindow.p_2096;

import java.util.Scanner;

//2096
public class Main {
	static final int stair = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][stair];
		int[][] minArr = new int[N][stair];
		int[][] maxArr = new int[N][stair];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < stair; j++) {
				arr[i][j] = sc.nextInt();
			}
			if (i > 0) {
				int beforeIndex = i - 1;
				// min
				calcMinArr(minArr, arr, i, beforeIndex);
				// max
				calcMaxArr(maxArr, arr, i, beforeIndex);

			} else {
				initArr(minArr, maxArr, arr, i);
			}

			if (i == N - 1) {
				int minValue, maxValue;
				minValue = Integer.min(Integer.min(minArr[i][0], minArr[i][1]), Integer.min(minArr[i][1], minArr[i][2]));
				maxValue = Integer.max(Integer.max(maxArr[i][0], maxArr[i][1]), Integer.max(maxArr[i][1], maxArr[i][2]));
				System.out.println(maxValue + " " + minValue);
			}
		}

	}

	private static void initArr(int[][] minArr, int[][] maxArr, int[][] arr, int i) {
		// min
		minArr[i][0] = arr[i][0];
		minArr[i][2] = arr[i][2];
		minArr[i][1] = arr[i][1];
		// max
		maxArr[i][0] = arr[i][0];
		maxArr[i][2] = arr[i][2];
		maxArr[i][1] = arr[i][1];
	}

	private static void calcMaxArr(int[][] maxArr, int[][] arr, int i, int beforeIndex) {
		maxArr[i][0] = Integer.max(maxArr[beforeIndex][0], maxArr[beforeIndex][1]) + arr[i][0];
		maxArr[i][2] = Integer.max(maxArr[beforeIndex][1], maxArr[beforeIndex][2]) + arr[i][2];
		maxArr[i][1] = Integer.max(Integer.max(maxArr[beforeIndex][0], maxArr[beforeIndex][1]),
				Integer.max(maxArr[beforeIndex][1], maxArr[beforeIndex][2]))
				+ arr[i][1];
	}

	private static void calcMinArr(int[][] minArr, int[][] arr, int i, int beforeIndex) {
		minArr[i][0] = Integer.min(minArr[beforeIndex][0], minArr[beforeIndex][1]) + arr[i][0];
		minArr[i][2] = Integer.min(minArr[beforeIndex][1], minArr[beforeIndex][2]) + arr[i][2];
		minArr[i][1] = Integer.min(Integer.min(minArr[beforeIndex][0], minArr[beforeIndex][1]),
				Integer.min(minArr[beforeIndex][1], minArr[beforeIndex][2]))
				+ arr[i][1];
	}
}

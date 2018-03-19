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
				calcMinArr(minArr, arr, i, beforeIndex);
				calcMaxArr(maxArr, arr, i, beforeIndex);
			} else {
				initArr(minArr, maxArr, arr, i);
			}

			if (i == N - 1) {
				System.out.println(getMaxValue(maxArr, i) + " " + getMinValue(minArr, i));
			}
		}
	}

	private static int getMinValue(int[][] minArr, int i) {
		return Integer.min(Integer.min(minArr[i][0], minArr[i][1]), Integer.min(minArr[i][1], minArr[i][2]));
	}

	private static int getMaxValue(int[][] maxArr, int i) {
		return Integer.max(Integer.max(maxArr[i][0], maxArr[i][1]), Integer.max(maxArr[i][1], maxArr[i][2]));
	}

	private static void initArr(int[][] minArr, int[][] maxArr, int[][] arr, int i) {
		minArr[i][0] = maxArr[i][0] = arr[i][0];
		minArr[i][2] = maxArr[i][2] = arr[i][2];
		minArr[i][1] = maxArr[i][1] = arr[i][1];
	}

	private static int getCalcMax(int[][] maxArr, int[][] arr, int i, int beforeIndex, int position) {
		return Integer.max(maxArr[beforeIndex][position], maxArr[beforeIndex][position + 1]);
	}

	private static void calcMaxArr(int[][] maxArr, int[][] arr, int i, int beforeIndex) {
		maxArr[i][0] = getCalcMax(maxArr, arr, beforeIndex, beforeIndex, 0) + arr[i][0];
		maxArr[i][2] = getCalcMax(maxArr, arr, beforeIndex, beforeIndex, 1) + arr[i][2];
		maxArr[i][1] = Integer.max(getCalcMax(maxArr, arr, beforeIndex, beforeIndex, 0), getCalcMax(maxArr, arr, beforeIndex, beforeIndex, 1))
				+ arr[i][1];
	}

	private static int getCalcMin(int[][] minArr, int[][] arr, int i, int beforeIndex, int position) {
		return Integer.min(minArr[beforeIndex][position], minArr[beforeIndex][position + 1]);
	}

	private static void calcMinArr(int[][] minArr, int[][] arr, int i, int beforeIndex) {
		minArr[i][0] = getCalcMin(minArr, arr, beforeIndex, beforeIndex, 0) + arr[i][0];
		minArr[i][2] = getCalcMin(minArr, arr, beforeIndex, beforeIndex, 1) + arr[i][2];
		minArr[i][1] = Integer.min(getCalcMin(minArr, arr, beforeIndex, beforeIndex, 0), getCalcMin(minArr, arr, beforeIndex, beforeIndex, 1))
				+ arr[i][1];
	}
}

package baekjoon.sk.dynamic.p_1932;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCase = scanner.nextInt();

		int[][] digitTriangle = new int[testCase][testCase];
		int[][] left = new int[testCase][testCase];
		int[][] right = new int[testCase][testCase];

		scanner.nextLine();

		for (int i = 0; i < testCase; i++) {

			String[] line = scanner.nextLine().split(" ");

			for (int j = 0; j < i + 1; j++) {
				digitTriangle[i][j] = Integer.parseInt(line[j]);
			}

		}

		findAccumulatedValue(digitTriangle, left, right, testCase);

		int Max = 0;

		for (int i = 0; i < testCase; i++) {
			if (Max < Math.max(left[testCase - 1][i], right[testCase - 1][i])) {
				Max = Math.max(left[testCase - 1][i], right[testCase - 1][i]);
			}
		}

		System.out.println(Max);

	}

	public static void findAccumulatedValue(int[][] digitTriangle,
			int[][] left, int[][] right, int testCase) {

		left[0][0] = digitTriangle[0][0];
		right[0][0] = digitTriangle[0][0];

		for (int i = 1; i < testCase; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j > 0)
					left[i][j] = Math.max(left[i - 1][j - 1],
							right[i - 1][j - 1]) + digitTriangle[i][j];

				if (j != i)
					right[i][j] = Math.max(left[i - 1][j], right[i - 1][j])
							+ digitTriangle[i][j];
			}
		}

	}

}

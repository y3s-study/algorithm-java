package baekjoon.sj.divideAndConquer.p_2447.v1;

import java.io.IOException;
import java.util.Scanner;

//2447
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// row rule
		int k = 0;
		int startRow = 0;
		int remainRow = 0;

		// col rule
		int colRange = 0;
		int startCol = 0;
		int tmpStartCol = 0;

		boolean[][] starArr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			startRow = (int) Math.pow(3, k);
			for (int j = 0; j < n; j++) {
				if (i == 0) {
					starArr[i][j] = true;
				} else {
					if (i == startRow || (i > startRow && i < startRow * 2)) {
						if (i == startRow && j == 0) {
							startCol = startRow;
							colRange = startCol;
							tmpStartCol = startCol;
						}

						if (j >= startCol && j <= (startCol - 1) + colRange) {
							starArr[i][j] = false;
							if (j == (startCol - 1) + colRange) {
								startCol += Math.pow(3, k + 1);
							}
							continue;
						}

						if (i == startRow) {
							starArr[i][j] = true;
						} else {
							starArr[i][j] = starArr[i - startRow][j];
						}
						remainRow = 0;
					} else {
						starArr[i][j] = starArr[i - remainRow][j];
					}
				}
			}

			if (i == startRow * 2 - 1) {
				k++;
				remainRow = i + 1;
			}
			startCol = tmpStartCol;
		}
		print(starArr);
	}

	static void print(boolean[][] starArr) throws IOException {
		StringBuilder sb = new StringBuilder(10000);

		for (int i = 0; i < starArr.length; i++) {
			for (int j = 0; j < starArr[i].length; j++) {
				if (starArr[i][j]) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

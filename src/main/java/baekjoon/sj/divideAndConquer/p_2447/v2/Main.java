package baekjoon.sj.divideAndConquer.p_2447.v2;

import java.util.Scanner;

//2447
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		StringBuilder sb = new StringBuilder("");
		boolean[][] star = new boolean[length][length];
		divideStar(length, star, 0, 0);

		print(star);
	}

	static void print(boolean[][] star) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				if (star[i][j]) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void divideStar(int length, boolean[][] star, int row, int col) {
		if (length == 1) {
			star[row][col] = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					star[row + i][col + j] = false;
					continue;
				}
				divideStar(length / 3, star, row + (length / 3) * i, col + (length / 3) * j);
			}
		}
	}
}

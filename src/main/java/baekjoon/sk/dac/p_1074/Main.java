package baekjoon.sk.dac.p_1074;

import java.util.Scanner;

public class Main {

	static int answer = 0;
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int R = scanner.nextInt();
		int C = scanner.nextInt();

		searchZ((int) Math.pow(2, N), R, C, 0, 0);

	}

	public static void searchZ(int N, int R, int C, int r, int c) {

		if (N == 2) {

			if (r == R && c == C) {
				System.out.println(answer);
				return;
			}
			answer++;

			if (r == R && c + 1 == C) {
				System.out.println(answer);
				return;
			}

			answer++;

			if (r + 1 == R && c == C) {
				System.out.println(answer);
				return;
			}

			answer++;

			if (r + 1 == R && c + 1 == C) {
				System.out.println(answer);
				return;
			}
			answer++;

			return;
		}

		searchZ(N / 2, R, C, r, c);
		searchZ(N / 2, R, C, r, c + N / 2);
		searchZ(N / 2, R, C, r + N / 2, c);
		searchZ(N / 2, R, C, r + N / 2, c + N / 2);

	}
}

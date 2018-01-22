package baekjoon.sk.dynamic.p_9461;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCase = scanner.nextInt();

		long[] Dp = new long[103];
				
		Dp[0] = Dp[1] = Dp[2] = Dp[3] = 1;
		Dp[4] = Dp[5] = 2;

		for (int i = 6; i <= 102; i++) {
			Dp[i] = Dp[i - 1] + Dp[i - 5];
		}

		while (testCase-- > 0) {
			int input = scanner.nextInt();
			System.out.println(Dp[input]);
		}
	}

}

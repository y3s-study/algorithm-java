package baekjoon.sk.dynamic.p_9251;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] str1 = scanner.nextLine().split("");
		String[] str2 = scanner.nextLine().split("");

		int[][] LCS = new int[str1.length+1][str2.length+1];

		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1].equals(str2[j - 1])) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;

				} else {
					LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);
				}
			}
		}

		System.out.println(LCS[str1.length][str2.length]);

	}
}

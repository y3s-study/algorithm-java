package baekjoon.sk.dac.p_2447;

import java.util.Scanner;

public class Main {

	static StringBuffer sb;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		sb = new StringBuffer();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int p = i, q = j;
				for (; p > 0; p /= 3, q /= 3)
					if (p % 3 == 1 && q % 3 == 1)
						break;
				sb.append(p > 0 ? ' ' : '*');
			}
			sb.append("\n");
		}

		 System.out.println(sb.toString());
		
	}

	/*
	 * static StringBuffer sb;
	 * 
	 * public static void main(String[] args) {
	 * 
	 * Scanner scanner = new Scanner(System.in);
	 * 
	 * int n = scanner.nextInt();
	 * 
	 * char[][] mat = new char[2201][2201];
	 * 
	 * sb = new StringBuffer();
	 * 
	 * solve(0, 0, n, mat);
	 * 
	 * for (int i = 0; i < n; i++) { for (int j = 0; j < n; j++) {
	 * sb.append(mat[i][j]); } sb.append("\n"); }
	 * 
	 * System.out.println(sb.toString());
	 * 
	 * }
	 * 
	 * public static void solve(int y, int x, int num, char[][] mat) { if (num
	 * == 1) { mat[y][x] = '*'; return; }
	 * 
	 * int div = num / 3;
	 * 
	 * for (int i = 0; i < 3; i++) { for (int j = 0; j < 3; j++) { if (i == 1 &&
	 * j == 1) {
	 * 
	 * } else solve(y + (i * div), x + (j * div), div, mat);
	 * 
	 * } } }
	 */

}

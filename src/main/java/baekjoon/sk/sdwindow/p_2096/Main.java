package baekjoon.sk.sdwindow.p_2096;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int max = 0;
		int min = 0;

		int n = sc.nextInt();

		int d[][] = new int[n + 1][4];
		int a[][] = new int[n + 1][4];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		d[0][1] = d[0][2] = d[0][3] = 0;

		for (int i = 1; i <= n; i++) {
			d[i][1] = Math.max(d[i - 1][1], d[i - 1][2]) + a[i][1];
			d[i][2] = Math.max(Math.max(d[i - 1][1], d[i - 1][2]), d[i - 1][3]) + a[i][2];
			d[i][3] = Math.max(d[i - 1][2], d[i - 1][3]) + a[i][3];
		}

		max = Math.max(d[n][1], Math.max(d[n][2], d[n][3]));

		for (int i = 1; i <= n; i++) {
			d[i][1] = Math.min(d[i - 1][1], d[i - 1][2]) + a[i][1];
			d[i][2] = Math.min(Math.min(d[i - 1][1], d[i - 1][2]), d[i - 1][3]) + a[i][2];
			d[i][3] = Math.min(d[i - 1][2], d[i - 1][3]) + a[i][3];
		}

		min = Math.min(d[n][1], Math.min(d[n][2], d[n][3]));
		System.out.println(max + " " + min);

	}

}

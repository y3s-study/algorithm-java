package baekjoon.sk.segmenttree.p_11659;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a[] = new int[100001];
		int s[] = new int[100001];

		int n, m, x, y;

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
			s[i] = s[i - 1] + a[i];
		}

		while (m-- > 0) {
			x = sc.nextInt();
			y = sc.nextInt();
			System.out.println(s[y] - s[x - 1]);
		}

	}

}

package baekjoon.sk.segmenttree.p_10986;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double n, m;

		n = sc.nextInt();

		m = sc.nextInt();

		double sum = 0;
		double c[] = new double[1000];

		Arrays.fill(c, 0);

		while (n-- > 0) {
			double a;
			a = sc.nextInt();
			sum += a;
			c[(int) (sum % m)]++;
		}

		double ret = c[0];

		for (int i = 0; i < m; i++)
			ret += (c[i] * (c[i] - 1)) / 2;

		System.out.printf("%.0f", ret);

	}

}

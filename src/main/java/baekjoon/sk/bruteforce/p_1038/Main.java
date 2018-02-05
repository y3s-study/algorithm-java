package baekjoon.sk.bruteforce.p_1038;

import java.util.Scanner;

public class Main {

	static long jump = 1;
	static long jumpCnt = 0;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		long N = scanner.nextInt();

		int cnt = 0;
		long n = 1;

		while (true) {

			if (checkReduceNum(n))
				cnt++;

			if (N == cnt)
				break;

			if (jump > 1) {
				n = (long)((n+jump) - ((n + jump) % Math.pow(10, jumpCnt)));
				jump = 1;
				jumpCnt = 0;
			} else {
				n++;
			}
		}

		System.out.println(n);

	}

	public static boolean checkReduceNum(long num) {

		long before;
		while (num != 0) {

			if (num / 10 == 0) {
				return true;
			}

			before = num % 10;

			num /= 10;

			if (num % 10 <= before) {
				jump *= 10;
				jumpCnt++;
				return false;
			}

		}

		return true;
	}

}

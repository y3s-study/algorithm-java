package baekjoon.sk.bruteforce.p_1038;

import java.util.Scanner;

public class Main {

	static long jump = 1;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		long N = scanner.nextInt();

		int cnt = 0;
		long n = 1;

		while (true) {

			if(N == 0) {
				System.out.println("0");
				break;
			}
			
			if (N > 1023) {
				System.out.println("-1");
				break;
			}

			if (checkReduceNum(n))
				cnt++;

			if (N == cnt)
				break;

			if (jump > 1) {
				n = (long) ((n + jump) - (n % jump));
				jump = 1;
			} else {
				n++;
			}
		}

		if (N > 0 && N < 1022)
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
				return false;
			}

		}
		
		return true;
	}

}

package baekjoon.sj.binarySearch.p_1654;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1654
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		long N = sc.nextLong();
		long[] lanLine = new long[K];

		for (int i = 0; i < lanLine.length; i++) {
			lanLine[i] = sc.nextLong();
		}

		System.out.println(findMaxLanLine(lanLine, N, 0, Long.MAX_VALUE - 1));
	}

	private static long findMaxLanLine(long[] lanLine, long N, long start, long end) {
		long mid = (start + end) / 2;
		if (start >= end) {
			return mid - 1;
		}

		long cnt = 0;
		for (int i = 0; i < lanLine.length; i++) {
			cnt += lanLine[i] / mid;
			if (cnt >= N) {
				break;
			}
		}

		if (cnt >= N) {
			return findMaxLanLine(lanLine, N, mid + 1, end);
		} else {
			return findMaxLanLine(lanLine, N, start, mid);
		}
	}
}

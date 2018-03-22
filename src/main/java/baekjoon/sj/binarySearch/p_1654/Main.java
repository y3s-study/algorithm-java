package baekjoon.sj.binarySearch.p_1654;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1654
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		long N = sc.nextInt();

		BigInteger[] lanLine = new BigInteger[K];
		BigInteger sum = new BigInteger("0");
		for (int i = 0; i < K; i++) {
			lanLine[i] = new BigInteger(sc.next());
			sum = sum.add(lanLine[i]);
		}

		System.out.println(findMaxLanLine(lanLine, N, new BigInteger("0"), sum));
	}

	private static BigInteger findMaxLanLine(BigInteger[] lanLine, long N, BigInteger start, BigInteger end) {
		BigInteger mid = start.add(end).divide(BigInteger.valueOf(2));
//		System.out.println("start: " + start + " end: " + end + " mid: " + mid);
		if (start.compareTo(end) >= 0) {
			return mid.subtract(BigInteger.valueOf(1));
		}
		BigInteger cnt = new BigInteger("0");
		for (int i = 0; i < lanLine.length; i++) {
			cnt = cnt.add(lanLine[i].divide(mid));
			if (cnt.compareTo(BigInteger.valueOf(N)) >= 0) {
				break;
			}
		}

		if (cnt.compareTo(BigInteger.valueOf(N)) >= 0) {
			return findMaxLanLine(lanLine, N, mid.add(BigInteger.valueOf(1)), end);
		} else {
			return findMaxLanLine(lanLine, N, start, mid);
		}
	}
}

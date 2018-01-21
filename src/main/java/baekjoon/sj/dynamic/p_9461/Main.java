package baekjoon.sj.dynamic.p_9461;

import java.util.Scanner;

//9461
public class Main {
	static int[] initValue = { 1, 1, 1, 2, 2 };
	static int maxSequenceNumber = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		long[] padovanSequence = new long[maxSequenceNumber];
		for (int i = 0; i < maxSequenceNumber; i++) {
			if (i < initValue.length) {
				padovanSequence[i] = initValue[i];
			} else {
				padovanSequence[i] = padovanSequence[i - 1] + padovanSequence[i - initValue.length];
			}
		}

		while (testCase-- > 0) {
			int length = sc.nextInt();
			System.out.println(padovanSequence[length - 1]);
		}
	}
}

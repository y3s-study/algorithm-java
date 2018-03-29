package baekjoon.sk.binarysearch.p_1654;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();

		int n = sc.nextInt();

		int A[] = new int[k];

		for (int i = 0; i < k; i++) {
			A[i] = sc.nextInt();
		}

		System.out.println(findMaxLength(k, n, A));

	}

	static int findMaxLength(int k, int n, int[] A) {

		long start = 0;
		long end = (long) (Math.pow(2, 31) - 1);

		long mid = 0;

		long cnt = 0;

		int max = 0;

		while (start <= end) {

			mid = (start + end) / 2;

			cnt = 0;

			for (int i = 0; i < k; i++) {
				cnt += A[i] / mid;
			}

			if (cnt >= n) {
				max = (int) Math.max(max, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return max;

	}

}

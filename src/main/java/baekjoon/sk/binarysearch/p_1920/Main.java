package baekjoon.sk.binarysearch.p_1920;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int A[] = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		Arrays.sort(A);

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(sc.nextInt(), A, 0, A.length - 1));
		}
	}

	public static int binarySearch(int a, int[] A, int start, int end) {

		int mid = (start + end) / 2;

		if (start > end)
			return 0;

		if (a < A[mid]) {
			return binarySearch(a, A, start, mid - 1);
		} else if (a == A[mid]) {
			return 1;
		} else {
			return binarySearch(a, A, mid + 1, end);
		}

	}

}

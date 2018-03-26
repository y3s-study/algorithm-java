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
			System.out.println(setHasNum(sc.nextInt(), A));
		}
	}

	public static int setHasNum(int a, int[] A) {

		// A라는 배열 안에 존재하는지 확인
		int result = binarySearch(a, A);

		return result;
	}

	public static int binarySearch(int a, int[] A) {

		if (A.length < 2) {
			if (A[0] == a)
				return 1;
			else
				return 0;
		}

		if (a < A[A.length / 2]) {
			int[] B = new int[A.length / 2];

			System.arraycopy(A, 0, B, 0, A.length / 2);

			return binarySearch(a, B);
		} else if (a == A[A.length / 2]) {
			return 1;
		} else {
			int[] C = new int[A.length - A.length / 2];

			System.arraycopy(A, A.length / 2 + 1, C, 0, A.length - A.length / 2
					- 1);

			return binarySearch(a, C);
		}

	}

}

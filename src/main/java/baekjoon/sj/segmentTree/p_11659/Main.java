package baekjoon.sj.segmentTree.p_11659;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/11659
 * 구간 합 구하기 4
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n + 1];

		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int size = findSegmentTreeSize(arr);
		int[] segArr = new int[(int) Math.pow(2, size)];

		initSegArr(segArr, arr, 1, 1, arr.length - 1);

		// for (int i : segArr) {
		// System.out.print(i + " ");
		// }

		while (m-- > 0) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			System.out.println(findSum(segArr, 1, 1, arr.length - 1, left, right));
		}

	}

	private static int findSum(int[] segArr, int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}

		if (left <= start && end <= right) {
			return segArr[node];
		}
		int mid = (start + end) / 2;
		return findSum(segArr, node * 2, start, mid, left, right) + findSum(segArr, node * 2 + 1, mid + 1, end, left, right);
	}

	private static int initSegArr(int[] segArr, int[] arr, int node, int start, int end) {
		if (start == end) {
			return segArr[node] = arr[start];
		}

		int mid = (start + end) / 2;

		return segArr[node] = initSegArr(segArr, arr, node * 2, start, mid) + initSegArr(segArr, arr, node * 2 + 1, mid + 1, end);
	}

	private static int findSegmentTreeSize(int[] arr) {
		int length = arr.length;
		int cnt = 0;
		while (length > (int) Math.pow(2, cnt)) {
			cnt++;
		}

		return cnt + 1;
	}
}

package baekjoon.sj.segmentTree.p_10986;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/10986
 * 나머지 합
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

		int size = findSize(arr);
		int[] segTree = new int[(int) Math.pow(2, size)];

		initSegTree(segTree, arr, 1, 1, arr.length - 1);

		int cnt = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (findSum(segTree, 1, 1, arr.length - 1, i, j) % m == 0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	private static int findSum(int[] segTree, int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}

		if (left <= start && end <= right) {
			return segTree[node];
		}

		int mid = (start + end) / 2;

		return findSum(segTree, node * 2, start, mid, left, right) + findSum(segTree, node * 2 + 1, mid + 1, end, left, right);
	}

	private static int initSegTree(int[] segTree, int[] arr, int node, int start, int end) {
		if (start == end) {
			return segTree[node] = arr[start];
		}
		int mid = (start + end) / 2;

		return segTree[node] = initSegTree(segTree, arr, node * 2, start, mid) + initSegTree(segTree, arr, node * 2 + 1, mid + 1, end);
	}

	private static int findSize(int[] arr) {
		int length = arr.length;
		int cnt = 0;
		while (length > Math.pow(2, cnt)) {
			cnt++;
		}

		return cnt + 1;
	}
}

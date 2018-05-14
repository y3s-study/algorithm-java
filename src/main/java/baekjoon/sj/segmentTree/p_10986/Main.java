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
		long[] sum = new long[arr.length];
		long[] remain = new long[arr.length];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum[i] = (arr[i] + sum[i - 1]);
		}

		for (int i = 1; i < remain.length; i++) {
			remain[(int) (sum[i] % m)]++;
		}

		remain[0]++; // why?
		long cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			cnt += (remain[i] * (remain[i] - 1)) / 2;
		}
		System.out.println(cnt);
	}
}

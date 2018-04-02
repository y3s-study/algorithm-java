package baekjoon.sj.binarySearch.p_2957.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2957
 */
public class Main {
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		int[] arr = new int[(int) Math.pow(2, n)+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			if (i == 1) {
				arr[i] = input;
			} else {
				insert(input, arr, 1);
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void insert(int number, int[] arr, int index) {
		if (arr[index] == 0) {
			arr[index] = number;
			return;
		}
		cnt++;
		if (number < arr[index]) {
			insert(number, arr, index * 2);
		} else {
			insert(number, arr, index * 2 + 1);
		}
	}
}

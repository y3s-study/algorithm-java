package baekjoon.sj.dynamic.p_1932;

import java.util.Scanner;

//1932
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] input = new int[n][];
		int[][] sum = new int[n][];

		int i, j;
		// 시작값 초기화
		input[0] = new int[1];
		sum[0] = new int[1];
		sum[0][0] = input[0][0] = sc.nextInt();

		for (i = 1; i < n; i++) {
			input[i] = new int[i + 1];
			sum[i] = new int[i + 1];
			for (j = 0; j < i + 1; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		int maxValue = sum[0][0];
		for (i = 1; i < n; i++) {
			for (j = 0; j < i + 1; j++) {
				if (j == 0) {
					sum[i][j] = sum[i - 1][j] + input[i][j];
				} else if (j == i) {
					sum[i][j] = sum[i - 1][j - 1] + input[i][j];
				} else {
					sum[i][j] = Integer.max(sum[i - 1][j - 1] + input[i][j], sum[i - 1][j] + input[i][j]);
				}
				maxValue = Integer.max(maxValue, sum[i][j]);
			}
		}
		System.out.println(maxValue);
	}
}

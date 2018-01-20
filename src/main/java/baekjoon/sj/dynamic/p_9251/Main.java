package baekjoon.sj.dynamic.p_9251;

import java.util.Scanner;

//9251
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input1 = sc.next().toCharArray();
		char[] input2 = sc.next().toCharArray();
		int[][] result = new int[input2.length + 1][input1.length + 1];

		for (int i = 1; i < input2.length + 1; i++) {
			for (int j = 1; j < input1.length + 1; j++) {
				if (input1[j - 1] == input2[i - 1]) {
					result[i][j] = result[i - 1][j - 1] + 1;
				} else {
					/*
					 * input1에서 input2를 찾는 값이 큰지 
					 * input2에서 input1을 찾는 값이 큰지에 따라
					 * 결과 저장
					 */
					result[i][j] = Integer.max(result[i - 1][j],
							result[i][j - 1]);
				}
			}
		}
		System.out.println(result[input2.length][input1.length]);
	}
}

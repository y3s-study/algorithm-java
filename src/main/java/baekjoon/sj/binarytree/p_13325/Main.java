package baekjoon.sj.binarytree.p_13325;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/13325
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int deep = sc.nextInt();
		int inputCnt = 0;

		for (int i = 0; i <= 20; i++) {
			inputCnt += Math.pow(2, i);
		}

		int[] arr = new int[inputCnt + 1];
		arr[1] = -1;
		sc.nextLine();
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int index = 2;
		while (st.hasMoreElements()) {
			arr[index++] = Integer.parseInt(st.nextToken());
			// System.out.println(arr[index-1]);
		}

		System.out.println(findMinWeight(arr, 1));
	}

	private static int findMinWeight(int[] arr, int index) {
		if (arr[index] == 0) {
			return 0;
		}
		System.out.println("arr[" + index + "]: " + arr[index]);
		int max = Integer.max(findMinWeight(arr, index * 2), findMinWeight(arr, index * 2 + 1));
		int curWeight = max * 2 + arr[index];
		System.out.println("max: "+max+" curWeight: "+curWeight);

		return curWeight;
	}
}

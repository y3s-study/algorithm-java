package baekjoon.sj.binarytree.p_13325;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/13325
 * 이진 트리
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int deep = sc.nextInt();
		int inputCnt = 0;

		inputCnt = (int) (Math.pow(2, deep + 1) - 1);

		int[] arr = new int[inputCnt + 1];
		arr[1] = -1;
		sc.nextLine();
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int index = 2;
		while (st.hasMoreElements()) {
			arr[index] = Integer.parseInt(st.nextToken());
			index++;
		}

		findMinWeight(arr, 1);
		
		int sum = 0;
		for (int i = 2; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

	private static int findMinWeight(int[] arr, int index) {
		if (index > arr.length - 1) {
			return 0;
		}
		int leftNodeWeight = findMinWeight(arr, index * 2);
		int rightNodeWeight = findMinWeight(arr, index * 2 + 1);
		int maxWeight = Integer.max(leftNodeWeight, rightNodeWeight);

		if (leftNodeWeight > rightNodeWeight) {
			if (index * 2 + 1 < arr.length) {
				arr[index * 2 + 1] += leftNodeWeight - rightNodeWeight;
			}
		} else {
			if (index * 2 < arr.length) {
				arr[index * 2] += rightNodeWeight - leftNodeWeight;
			}
		}
		return maxWeight + arr[index];
	}
}

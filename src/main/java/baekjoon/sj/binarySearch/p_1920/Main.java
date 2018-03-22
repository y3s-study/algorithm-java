package baekjoon.sj.binarySearch.p_1920;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1920
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		while (M-- > 0) {
			int findNumber = sc.nextInt();
			System.out.println(existFindNumber(arr, findNumber, 0, arr.length-1));
		}
	}

	private static int existFindNumber(int[] arr, int findNumber, int start, int end) {
		int mid = (start + end) / 2;
		if (start == end) {
			if(arr[mid] == findNumber){
				return 1;
			}
			return 0;
		}

		if (findNumber > arr[mid]) {
			return existFindNumber(arr, findNumber, mid + 1, end);
		} else if (findNumber < arr[mid]) {
			return existFindNumber(arr, findNumber, start, mid);
		} else {
			return 1;
		}
	}
}

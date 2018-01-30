package baekjoon.sj.divideAndConquer.p_1992;

import java.util.Scanner;

//1992
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] arr = new char[n][n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().toCharArray();
		}

		System.out.println(quadTree(arr, 0, 0, n - 1));
	}

	static String quadTree(char[][] arr, int startRow, int startCol, int size) {
		if (size == 0) {
			return String.valueOf(arr[startRow][startCol]);
		}
		String result = "";
		int pivot = (size + 1) / 2;
		// left - top
		result += "(" + quadTree(arr, startRow, startCol, pivot - 1);
		// right - top
		result += quadTree(arr, startRow, startCol + pivot, pivot - 1);
		// left - bottom
		result += quadTree(arr, startRow + pivot, startCol, pivot - 1);
		// right - bottom
		result += quadTree(arr, startRow + pivot, startCol + pivot, pivot - 1) + ")";

		return result.replaceAll("\\(0+\\)", "0").replaceAll("\\(1+\\)", "1");
	}
}

package baekjoon.sj.divideAndConquer.p_1992;

import java.util.Scanner;

//1992
public class Main {
	static boolean visit[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] arr = new char[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().toCharArray();
		}

		System.out.println(quadTree(arr, 0, 0, n - 1));
	}

	static String quadTree(char[][] arr, int startRow, int startCol, int size) {
		String result = "";
		int pivot = (size + 1) / 2;
		if (size == 0) {
			visit[startRow][startCol] = true;
			return result = "" + arr[startRow][startCol];
		}
		for (int row = startRow; row <= startRow + size; row++) {
			for (int col = startCol; col <= startCol + size; col++) {
				if (visit[row][col] == false) {
					// left - top
					if (row < startRow + pivot && col < startCol + pivot) {
						result += "(" + quadTree(arr, startRow, startCol, pivot - 1);
					}
					// right - top
					else if (row < startRow + pivot && col >= startCol + pivot) {
						result += quadTree(arr, startRow, startCol + pivot, pivot - 1);
					}
					// left - bottom
					else if (row >= startRow + pivot && col < startCol + pivot) {
						result += quadTree(arr, startRow + pivot, startCol, pivot - 1);
					}
					// right - bottom
					else if (row >= startRow + pivot && col >= startCol + pivot) {
						result += quadTree(arr, startRow + pivot, startCol + pivot, pivot - 1) + ")";
						result = result.replaceAll("\\(0+\\)", "0").replaceAll("\\(1+\\)", "1");
					}
				}
			}
		}

		return result;
	}
}

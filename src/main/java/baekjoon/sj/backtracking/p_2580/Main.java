package baekjoon.sj.backtracking.p_2580;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2580
 * 스토쿠
 */
public class Main {
	static int N = 9;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[N][N];
		boolean[][] rowNumber = new boolean[N][N];
		boolean[][] colNumber = new boolean[N][N];
		boolean[][] squareNumber = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] != 0) {
					rowNumber[i][arr[i][j] - 1] = colNumber[j][arr[i][j] - 1] = squareNumber[findSquareIndex(i, j)][arr[i][j] - 1] = true;
				}
			}
		}

		makeSudoku(arr, rowNumber, colNumber, squareNumber, 0);
	}

	private static int findSquareIndex(int row, int col) {
		return 3 * (row / 3) + col / 3;
	}

	private static void printArr(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void makeSudoku(int[][] arr, boolean[][] rowNumber, boolean[][] colNumber, boolean[][] squareNumber, int position) {
		if (position == N * N) {
			printArr(arr);
			return;
		}
		int row = position / N;
		int col = position % N;
		if (arr[row][col] != 0) {
			makeSudoku(arr, rowNumber, colNumber, squareNumber, position + 1);
		} else {
			for (int i = 0; i < N; i++) {
				if (rowNumber[row][i] == false && colNumber[col][i] == false && squareNumber[findSquareIndex(row, col)][i] == false) {
					rowNumber[row][i] = colNumber[col][i] = squareNumber[findSquareIndex(row, col)][i] = true;
					arr[row][col] = i + 1;
					makeSudoku(arr, rowNumber, colNumber, squareNumber, position + 1);
					arr[row][col] = 0;
					rowNumber[row][i] = colNumber[col][i] = squareNumber[findSquareIndex(row, col)][i] = false;
				}
			}
		}
	}
}

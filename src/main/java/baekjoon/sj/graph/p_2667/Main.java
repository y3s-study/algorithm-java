package baekjoon.sj.graph.p_2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//2667
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] arr = new char[n][n];
		boolean[][] visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().toCharArray();
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (visit[i][j] == false && arr[i][j] == '1') {
					list.add(findGroup(arr, visit, i, j, 1));
				}
			}
		}

		System.out.println(list.size());
		Collections.sort(list);
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	static boolean isOutOfArrayCheck(char[][] arr, int row, int col) {
		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
			return true;
		}
		return false;
	}

	static int[][] position = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	static int findGroup(char[][] arr, boolean[][] visit, int row, int col, int cnt) {

		visit[row][col] = true;
		for (int i = 0; i < position.length; i++) {
			int rowPosition = row + position[i][0];
			int colPosition = col + position[i][1];
			if (!isOutOfArrayCheck(arr, rowPosition, colPosition) && visit[rowPosition][colPosition] == false) {
				if (arr[rowPosition][colPosition] == '1') {
					cnt = findGroup(arr, visit, rowPosition, colPosition, cnt + 1);
				}
			}

		}

		return cnt;
	}
}

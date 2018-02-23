package baekjoon.sj.graph.p_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//7576
public class Main {
	static int minDate = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int col = sc.nextInt();
		int row = sc.nextInt();
		int[][] arr = new int[row][col];
		boolean[][] visit = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == -1) {
					visit[i][j] = true;
				}
			}
		}

		if (isAllTomatoRip(arr)) {
			System.out.println(0);
			return;
		}

		findMinDate(arr, visit);

		if (isAllVisit(visit)) {
			System.out.println(minDate);
		} else {
			System.out.println(-1);
		}
	}

	static boolean isAllVisit(boolean[][] visit) {

		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit[i].length; j++) {
				if (visit[i][j] == false) {
					return false;
				}
			}
		}

		return true;
	}

	static boolean isAllTomatoRip(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 1 && arr[i][j] != -1) {
					return false;
				}
			}
		}

		return true;
	}

	static int[][] position = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	static void findMinDate(int[][] arr, boolean[][] visit) {
		Queue<Pair> queue = new LinkedList<>();

		addStartPosition(queue, arr, visit);

		while (!queue.isEmpty()) {
			int row = queue.peek().getRow();
			int col = queue.peek().getCol();
			int cnt = queue.poll().getCnt();

			for (int i = 0; i < position.length; i++) {
				int rowPosition = row + position[i][0];
				int colPosition = col + position[i][1];

				if (!isOutOfArrayCheck(arr, rowPosition, colPosition) && visit[rowPosition][colPosition] == false) {
					visit[rowPosition][colPosition] = true;
					queue.add(new Pair(row + position[i][0], col + position[i][1], cnt + 1));
					if (minDate < cnt + 1) {
						minDate = cnt + 1;
					}
				}
			}
		}
	}

	static boolean isOutOfArrayCheck(int[][] arr, int row, int col) {

		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
			return true;
		}

		return false;
	}

	static void addStartPosition(Queue<Pair> queue, int[][] arr, boolean[][] visit) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					queue.add(new Pair(i, j, 0));
					visit[i][j] = true;
				}
			}
		}
	}
}

class Pair {
	private int row;
	private int col;
	private int cnt;

	Pair(int row, int col, int cnt) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
	}

	public int getCnt() {
		return cnt;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

}

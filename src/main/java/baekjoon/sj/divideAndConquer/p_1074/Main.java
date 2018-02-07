package baekjoon.sj.divideAndConquer.p_1074;

import java.util.Scanner;

//1074
public class Main {
	static int row;
	static int col;
	static int cnt = 0;
	static boolean find = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		row = sc.nextInt();
		col = sc.nextInt();
		int size = (int) Math.pow(2, n);

		findZPosition(0, size - 1, 0, size - 1);
		System.out.println(cnt);
	}

	static void findZPosition(int startRow, int endRow, int startCol, int endCol) {

		if (find) {
			return;
		}
		
		if (endRow != startRow + 1) {
			int midRow = (startRow + endRow) / 2;
			int midCol = (startCol + endCol) / 2;
			// left-top
			findZPosition(startRow, midRow, startCol, midCol);
			// right-top
			findZPosition(startRow, midRow, midCol + 1, endCol);
			// left-down
			findZPosition(midRow + 1, endRow, startCol, midCol);
			// right-down
			findZPosition(midRow + 1, endRow, midCol + 1, endCol);
		}

		if (endRow == startRow + 1) {
			for (int i = startRow; i <= endRow; i++) {
				for (int j = startCol; j <= endCol; j++) {
					if (i == row && j == col) {
						find = true;
						return;
					}
					cnt++;
				}
			}
		}
	}
}

package baekjoon.sk.backtracking.p_9663;

import java.util.*;

public class Main {

	static int ans, n;
	static int[] col;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			col = new int[15];
			col[1] = i;
			// 정점은 행을 기준. 
			// (i = 1) => 1행(1열), (i = 2) => 2행(1열), (i = 3) => 3행(1열)
			dfs(1);
		}
		System.out.println(ans);

	}

	public static void dfs(int row) {
		if (row == n) {
			++ans;
		} else {
			for (int i = 1; i <= n; i++) {
				col[row + 1] = i;
				if (isPossible(row + 1)) {
					dfs(row + 1);
				} else {
					col[row + 1] = 0;
				}
			}
		}
		col[row] = 0;
	}

	public static boolean isPossible(int c) {
		// col[1]의 의미는 1행 *열이다.
		// col[1] = 1 => 1행 1열, col[2] = 3 => 2행 3열

		// 이전 열들을 탐색하면서 배치 가능 여부 확인
		for (int i = 1; i < c; i++) {
			// 같은 행, 열
			if (col[i] == col[c]) {
				return false;
			}
			// 대각선
			if (Math.abs(col[i] - col[c]) == Math.abs(i - c)) {
				return false;
			}
		}
		return true;
	}

}

package baekjoon.sk.backtracking.p_2580;

import java.util.Scanner;

public class Main {

	public static boolean ch[][], cv[][], cx[][];
	public static int n = 9;
	public static int map[][];

	public static int cal_x(int x, int y) {
		return (x / 3) * 3 + y / 3;
	}

	public static void go(int d) {
		if (d == 81) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}

		int x = d / n;
		int y = d % n;

		if (map[x][y] != 0) {
			go(d + 1);
		} else {
			for (int k = 1; k <= 9; k++) {
				if (ch[x][k] == false && cv[y][k] == false && cx[cal_x(x, y)][k] == false) {
					ch[x][k] = cv[y][k] = cx[cal_x(x, y)][k] = true;
					map[x][y] = k;
					go(d + 1);
					map[x][y] = 0;
					ch[x][k] = cv[y][k] = cx[cal_x(x, y)][k] = false;
				}
			}
		}
	}

	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		ch = new boolean[n][10];
		cv = new boolean[n][10];
		cx = new boolean[n][10];

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();

				ch[i][map[i][j]] = true;
				cv[j][map[i][j]] = true;
				cx[cal_x(i, j)][map[i][j]] = true;
			}
		}

		go(0);

	}

}

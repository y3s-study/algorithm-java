package baekjoon.sk.dynamic3.p_2342;

import java.util.*;

public class Main {

	int n;
	static int ddr[] = new int[100001];
	static int dp[][][] = new int[5][5][100001];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tmp = -1;
		int count = 0;

		while (true) {
			tmp = sc.nextInt();

			if (tmp == 0)
				break;

			ddr[count] = tmp;
			
			count++;
		}

		System.out.println(Integer.toString(move(0, 0, 0)));

	}

	public static int move(int one, int other, int index) {

		if (ddr[index] == 0)
			return 0;

		int ret = dp[one][other][index];

		if(ret > 0) return ret;

		if (other == ddr[index] || one == ddr[index]) {
			ret = move(one, other, index + 1) + 1;
		} else {
			ret = moveCount(one, ddr[index])
					+ move(ddr[index], other, index + 1);

			ret = Math.min(
					ret,
					moveCount(other, ddr[index])
							+ move(one, ddr[index], index + 1));
		}

		return ret;
	}

	public static int moveCount(int current, int next) {

		if (current == 0)
			return 2;
		if (Math.abs(current - next) == 2)
			return 4;

		return 3;

	}

}

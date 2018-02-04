package baekjoon.sj.bruteForce.p_2309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//2309
public class Main {
	static int dwarfs = 9;
	static boolean find = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] heights = new int[dwarfs];
		while (dwarfs-- > 0) {
			heights[dwarfs] = sc.nextInt();
		}

		Arrays.sort(heights);
		findDwarfsHeights(heights, 0, new ArrayList<>(), 0);
	}

	static void findDwarfsHeights(int[] heights, int start, ArrayList<Integer> list, int sum) {
		if (list.size() == 7) {
			if (sum == 100) {
				find = true;
				for (Integer integer : list) {
					System.out.println(integer);
				}
			}
			return;
		}

		for (int i = start; i < heights.length; i++) {
			if (find) {
				break;
			}
			list.add(heights[i]);
			findDwarfsHeights(heights, i + 1, list, sum + heights[i]);
			list.remove(list.size() - 1);
		}
	}
}

package baekjoon.sk.bruteforce.p_2309;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] arr = new int[9];
		boolean[] barr = new boolean[9];

		for (int i = 0; i < 9; i++) {
			arr[i] = scanner.nextInt();
			barr[i] = true;
		}

		int sum = 0;
		boolean passTag = true;

		for (int i = 0; i < 9 && passTag; i++) {

			sum = 0;

			if (i != 0) {
				barr[i - 1] = true;
				barr[8] = true;
			}

			barr[i] = false;

			for (int j = i + 1; j < 9 && passTag; j++) {

				barr[j] = false;

				for (int k = 0; k < 9 && passTag; k++) {

					if (barr[k]) {
						sum += arr[k];
					}

				}

				if (sum == 100)
					passTag = false;
				else {
					sum = 0;
					barr[j] = true;
				}
			}

		}

		ArrayList<Integer> answer = new ArrayList<Integer>();

		for (int i = 0; i < 9; i++) {
			if (barr[i]) {
				answer.add(arr[i]);
			}
		}

		Collections.sort(answer);

		for (int tmp : answer) {
			System.out.println(tmp);
		}

	}

}

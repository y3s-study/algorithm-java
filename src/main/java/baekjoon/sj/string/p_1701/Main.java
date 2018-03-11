package baekjoon.sj.string.p_1701;

import java.util.Scanner;

//1701
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int[][] move = new int[input.length()][input.length()];

		int maxValue = 0;
		int j=0;
		int length = input.length();
		for (int i = 0; i < length; i++) {
			j=0;
			for(int k = 1; k < input.length(); k++){
				while (j > 0 && input.charAt(k) != input.charAt(j)) {
					j = move[i][j-1];
				}
				if (input.charAt(k) == input.charAt(j)) {
					move[i][k] = ++j;
					maxValue = Integer.max(maxValue, j);
				}
			}
			input = input.substring(1, input.length());
		}
		
		System.out.println(maxValue);

	}
}

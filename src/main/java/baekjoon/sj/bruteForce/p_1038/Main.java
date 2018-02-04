package baekjoon.sj.bruteForce.p_1038;

import java.util.Scanner;

//1038
public class Main {
	static int maxNumber = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int position = 0;
		long[] decreaseNumber = new long[1023];

		if (input < decreaseNumber.length) {
			for (long i = 0; position < decreaseNumber.length; i++) {
				if (i <= 10) {
					decreaseNumber[position] = position++;
				} else {
					int j;
					char[] number = ("" + i).toCharArray();
					for (j = 1; j < number.length; j++) {
						if (number[j - 1] <= number[j]) {
							i -= i % (long) Math.pow(10, number.length - j);
							i += (long) Math.pow(10, number.length - j) - 1;
							// i -= i % (long) Math.pow(10, number.length - j) + (long) Math.pow(10, number.length - j);
							break;
						}
					}
					if (j == number.length) {
						decreaseNumber[position++] = i;
					}
				}
			}
			System.out.println(decreaseNumber[input]);
		} else {
			System.out.println("-1");
		}
	}
}

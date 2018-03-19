package baekjoon.sb.string.p_1701_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		
		System.out.println(getLongestSubstringLength(inputStr));
	}
	
	public static int getLongestSubstringLength(String input) {
		String str = new String(input);
		int maxLength = 0;
		
		for(int i = 0; i < input.length(); i++) {
			String subStr = str.substring(i, input.length());
			if( maxLength > subStr.length()) {
				break;
			}
			maxLength = Math.max(maxLength, getMax(subStr));
		}
		return maxLength;
	}
	
	public static int getMax(String pattern) {
		int m = pattern.length();
		int j = 0;
		char[] p = new char[m];
		int[] pi = new int[m];
		int max = 0;

		p = pattern.toCharArray();

		for (int i = 1; i < m; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j]) {
				max = Math.max(max, pi[i] = ++j);
			}
		}
		return max;
	}
}

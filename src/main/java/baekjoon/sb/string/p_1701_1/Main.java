package baekjoon.sb.string.p_1701_1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		
		System.out.println(getLongestSubstringLength(inputStr));
	}

	public static int getLongestSubstringLength(String input) {

		Set<String> set = new HashSet<>();
		String str = new String(input);
		int maxLength = 0;

		for(int i = input.length() - 1; i >= 0; i--) {
			for(int j = 0; j < input.length()-i; j++) {
				String subStr = str.substring(j, j+i+1);
				if(subStr.length() < maxLength) {
					continue;
				}
				if(set.contains(subStr)) {
					if(maxLength < subStr.length()) {
						maxLength = subStr.length();
					}
				} else {
					set.add(subStr);
				}
			}
		}

		return maxLength;
	}
}

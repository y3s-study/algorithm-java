package baekjoon.sb.string.p_11478;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		
		System.out.println(getNotEqualSubstringCount(inputStr));
	}
	
	public static int getNotEqualSubstringCount(String input) {
		
		Set<String> set = new HashSet<>();
		String str = input;
		
		for(int i = 0; i < input.length(); i++) { 			// i + 1 = 자르는 글자 개수
			for(int j = 0; j < input.length() - i; j++) {
				if(set.contains(str.substring(j, j+i+1))) { // 한글자씩 늘려가며 substring
					continue;
				} else {
					set.add(str.substring(j, j+i+1));
				}
			}
		}
		
		return set.size();
	}
}

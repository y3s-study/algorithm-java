package baekjoon.sj.string.p_11478;

import java.util.HashSet;
import java.util.Scanner;

//11478
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		HashSet<String> hs = new HashSet<>();

		for (int i = 0; i < input.length(); i++) {
			for (int j = i+1; j <= input.length(); j++) {
				hs.add(input.substring(i, j));
			}
		}
		
		System.out.println(hs.size());
	}
}

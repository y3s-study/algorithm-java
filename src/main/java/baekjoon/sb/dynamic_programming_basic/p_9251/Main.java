package baekjoon.sb.dynamic_programming_basic.p_9251;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] str1 = sc.nextLine().toCharArray();
		char[] str2 = sc.nextLine().toCharArray();
		
		int[][] arr = new int[str1.length+1][str2.length+1];
		
		for(int i = 1; i <= str1.length; i++) {
			for(int j = 1; j <= str2.length; j++) {
				if(str1[i-1] == str2[j-1]) {
					arr[i][j] = arr[i-1][j-1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
				}
			}
		}
		
		System.out.println(arr[str1.length][str2.length]);

	}

}

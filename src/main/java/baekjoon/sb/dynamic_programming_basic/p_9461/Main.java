package baekjoon.sb.dynamic_programming_basic.p_9461;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for(int j = 0; j < n; j++) {
				if(j < 3) {
					arr[j] = 1;
				}
				else {
					arr[j] = arr[j-2] + arr[j-3];
				}
			}
			System.out.println(arr[n-1]);
		}

	}

}

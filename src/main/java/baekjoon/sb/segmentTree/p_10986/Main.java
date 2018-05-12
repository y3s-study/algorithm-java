package baekjoon.sb.segmentTree.p_10986;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 	// 수의 개수
		int M = sc.nextInt();	// 나누는 수
		
		long sum = 0;
		long[] arr = new long[1000];
		
		for(int i = 0; i < N; i++) {
			int input = sc.nextInt();
			sum += input;
			arr[(int)(sum%M)]++;
		}
		
		long ret = arr[0];
		for(int i = 0; i < M; i++) {
			ret += (arr[i] * (arr[i]-1)) / 2;
		}
		
		System.out.println(ret);
	}

}


	

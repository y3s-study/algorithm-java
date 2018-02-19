package baekjoon.sb.brute_force.p_1038;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int decreaseNum = -1;
		long j = 0;
		
		for(j = 0; j <= 9876543210L && N != decreaseNum; j++) {
			boolean check = true;
			if(j < 10) {
				decreaseNum++;
				continue;
			}
			
			int e = 1;
			while(j / Math.pow(10, e+1) >= 1) {
				e++;
			}
			
			long num = j;
			while( e > 0 ) {
				long n = (long) Math.pow(10, e);
				int front = (int) (num / n);
				int second = (int) ((num % n) * 10 / n);
				
				if(front > second) {
					num %= n;
					e--;
				} else {
					j /= n;
					j *= n;
					j += (n-1);
					check = false;
					break;
				}
			}
			
			if(check == true) {
				decreaseNum++;
			}
		}
		
		if(decreaseNum != N) {
			System.out.println(-1);
		} else {
			System.out.println(j-1);
		}
		

	}

}

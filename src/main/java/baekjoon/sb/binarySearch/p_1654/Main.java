package baekjoon.sb.binarySearch.p_1654;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt(); // 이미 가지고 있는 랜선의 개수
		int N = sc.nextInt(); // 필요한 랜선의 개수
		int[] lanLength = new int[K];
		
		for(int i = 0; i < K; i++) {
			lanLength[i] = sc.nextInt();
		}
		
		System.out.println(getMaxLanLength(lanLength, K, N));

	}
	
	public static int getMaxLanLength(int[] lanLength, int K, int N) {
		long left = 0;
		long right = (long)Math.pow(2, 31)-1;
		long mid = 0;
		
		int maxLength = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			int cnt = 0;
			for(int i = 0; i < K; i++) {
				cnt += lanLength[i] / mid;
			}
			
			if(cnt >= N) {
				maxLength = Math.max(maxLength, (int)mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return maxLength;
	}
}

package baekjoon.sb.dynamic_programming.p_2098;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 도시의 수
		
		int[][] W = new int[N+1][N+1]; // W[i][j] - i에서 j로 가기 위한 비용
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				W[i][j] = sc.nextInt();
			}
		}
		
		int[][] shortestPath = new int[N+1][1 << N]; // shortestPath[current][visited] - 현재 위치 current에서 방문했던 도시들이 visited일 때, 부분 경로 최소값
		for(int i = 0; i <= N; i++) {
			Arrays.fill(shortestPath[i], -1);
		}
		
		System.out.println(getShortestPath(W, shortestPath, N, 1, 1));
	}
	
	public static int getShortestPath(int[][] W, int[][] shortestPath, int N, int current, int visited) {
		
		if(visited == (1 << N) - 1) { // 모든 정점을 방문한 경우
			return W[current][1];
		}
		
		if(shortestPath[current][visited] >= 0) { // 방문 했던 경로이므로 return
			return shortestPath[current][visited];
		}
		
		int ret = Integer.MAX_VALUE;
		
		for(int i = 1; i <= N; i++) {
			if((visited & (1 << (i - 1))) != 0) { // 이미 방문한 경로 jump
				continue;
			}
			
			if(W[current][i] == 0) { // 0이면 길이 없음
				continue;
			}
			
			int temp = W[current][i] + getShortestPath(W, shortestPath, N, i, visited + (1 << (i - 1)));
			ret = Math.min(ret, temp);
		}
		
		return shortestPath[current][visited] = ret;
	}

}

package baekjoon.sb.queue.p_1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static int N;
	private static int M;
	private static int[][] adj;
	private static int[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 개수
		M = sc.nextInt(); // 간선 개수
		int V = sc.nextInt(); // 시작 정점 번호
		sc.nextLine();
		
		adj = new int[N][N];
		visited = new int[N];
		
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			sc.nextLine();
			
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
		
		dfs(V-1);
		System.out.println("");
		
		initArray(visited);
		
		bfs(V-1);
		
		sc.close();
	}
	
	public static void dfs(int start) {
		visited[start] = 1;
		System.out.print(start+1 + " ");
		for(int i = 0; i < N; i++) {
			if(visited[i] == 0 && adj[start][i] == 1) {
				dfs(i);
			}
		} 
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>(); 
		q.offer(start);
		
		while( !q.isEmpty() ) {
			int n = q.poll();
			visited[n] = 1;
			System.out.print(n+1 + " ");
			for(int i = 0; i < N; i++) {
				if(visited[i] == 0 && adj[n][i] == 1) {
					if( !q.contains(i) ) {
						q.offer(i);
					}
					
				}
			}
		}
	}
	
	public static void initArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}

}

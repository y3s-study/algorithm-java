package baekjoon.sb.graph.p_1766;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 문제의 수
		int M = sc.nextInt(); // 문제 순서에 대한 정보 개수
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int[] indegree = new int[N];
		Arrays.fill(indegree, 0);
		
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());			
		}
		
		for(int i = 0; i < M; i++) {
			int A = sc.nextInt() - 1; // 인덱스이므로 -1
			int B = sc.nextInt() - 1;
			graph.get(A).add(B);
			indegree[B]++;
		}
		
		for(int i = 0; i < N; i++) {
			if(indegree[i] == 0) {
				pq.offer(i);
				indegree[i] = -1; // 방문한 것을 -1로 표시
			}
		}
		
		topologicalSort(graph, pq, indegree);
	}
	
	public static void topologicalSort(ArrayList<ArrayList<Integer>> graph, PriorityQueue<Integer> pq, int[] indegree) {
		
		while(!pq.isEmpty()) {
			int s = pq.poll();
			System.out.print((s+1) + " ");
			
			ArrayList<Integer> list = graph.get(s);
			for(int i : list) {
				indegree[i]--;
				if(indegree[i] == 0) {
					pq.offer(i);
					indegree[i] = -1;
				}
			}
		}
	}
}

package baekjoon.sb.dynamic_programming_basic.p_1005;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	private static int[] time;
	private static int[] maxTime;
	
	private static LinkedList<Integer>[] graph;
	private static int[] indegree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt(); // 건물개수
			int K = sc.nextInt(); // 규칙개수
			time = new int[N];
			maxTime = new int[N];
			indegree = new int[N];
			graph = new LinkedList[N];
			
			for(int j = 0; j < N; j++) {
				time[j] = sc.nextInt();
				graph[j] = new LinkedList<>();
			}
		
			for(int k = 0; k < K; k++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				graph[x].add(y);
				indegree[y]++;
			}
			
			int goal = sc.nextInt();				
			topologicalSort(goal-1);
			
			System.out.println(maxTime[goal-1]);
			
		}
	}
	
	public static void topologicalSort(int goal) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
				maxTime[i] = time[i];
			}
		}
		
		while(!q.isEmpty() && indegree[goal] != 0) {
			int zeroNode = q.poll();
			
			for(int linkedNode : graph[zeroNode]) {
				if(maxTime[zeroNode] + time[linkedNode] > maxTime[linkedNode]) {
					maxTime[linkedNode] = maxTime[zeroNode] + time[linkedNode];
				}
				
				indegree[linkedNode]--;
				
				if(indegree[linkedNode] == 0) {
					q.offer(linkedNode);
				}
			}
		}
	}
}

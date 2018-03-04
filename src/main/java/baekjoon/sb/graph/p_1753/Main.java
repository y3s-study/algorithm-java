package baekjoon.sb.graph.p_1753;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertexCnt = sc.nextInt();
		int edgeCnt = sc.nextInt();
		int start = sc.nextInt();
		PriorityQueue<Node> graph[] = new PriorityQueue[vertexCnt];
		
		for(int i = 0; i < vertexCnt; i++) {
			graph[i] = new PriorityQueue<>();
		}
		
		int weight[] = new int[vertexCnt];
		Arrays.fill(weight, 3000001);
		
		for(int i = 0; i < edgeCnt; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			graph[u-1].offer(new Node(v-1,w));
		}
		
		dijkstra(graph, weight, start-1);
		for(int i = 0; i < vertexCnt; i++) {
			if(weight[i] == 3000001) {
				System.out.println("INF");
			} else {
				System.out.println(weight[i]);
			}
		}
	}
	
	public static void dijkstra(PriorityQueue<Node> graph[], int[] weight, int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		weight[start] = 0;
		
		while(!q.isEmpty()) {
			int s = q.poll();
			
			for(Node node : graph[s]) {
				if(weight[node.getV()] > node.getWeight() + weight[s]) {
					q.offer(node.getV());
				}
				weight[node.getV()] = Math.min(weight[s] + node.getWeight(), weight[node.getV()]);
			}
		}
	}

}

class Node implements Comparable<Node>{
	private int V;
	private int weight;
	
	public Node(int V, int W) {
		this.V = V;
		this.weight = W;
	}
	
	public int getV() {
		return V;
	}

	public int getWeight() {
		return weight;
	}

	public int compareTo(Node node) {
		return this.weight - node.weight; // 오름차순
	}
}
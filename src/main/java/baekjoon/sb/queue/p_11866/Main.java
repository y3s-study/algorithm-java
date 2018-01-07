package baekjoon.sb.queue.p_11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while(!q.isEmpty()) {
			for( int i = 0; i < M-1; i++ ) {
				q.add(q.poll());
			}
			print(q, N);
		}
		
		sc.close();
	}
	
	public static void print(Queue<Integer> que, int N) {
		if( que.size() == N ) {
			System.out.print("<");
		}
		
		System.out.print(que.poll());
		
		if( !que.isEmpty() ) {
			System.out.print(", ");
		}
		else {
			System.out.print(">");
		}
	}

}

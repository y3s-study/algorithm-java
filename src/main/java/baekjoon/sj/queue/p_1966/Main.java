package baekjoon.sj.queue.p_1966;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//1966
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int n, m;
		int cnt = 0;
		PriorityQueue<priorityQueue> pq;
		Queue<Pair> queue;
		for (int i = 0; i < testCase; i++) {
			pq = new PriorityQueue<>();
			queue = new LinkedList<>();
			cnt = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			for (int j = 0; j < n; j++) {
				int input = sc.nextInt();
				pq.offer(new priorityQueue(input));
				if (m == j) {
					queue.offer(new Pair(input, 1));
				} else {
					queue.offer(new Pair(input, 0));
				}
			}

			while (true) {
				if (pq.peek().getInput() == queue.peek().getInput()) {
					cnt++;
					if (queue.peek().getCheck() == 1) {
						break;
					}
					pq.poll();
					queue.poll();
				} else {
					queue.offer(queue.poll());
				}
			}
			System.out.println(cnt);
		}
	}

	static class priorityQueue implements Comparable<priorityQueue> {
		private int input;

		public priorityQueue(int input) {
			this.input = input;
		}

		public int getInput() {
			return input;
		}

		@Override
		public int compareTo(priorityQueue o) {
			// TODO Auto-generated method stub
			if (this.getInput() > o.getInput()) {
				return -1;
			} else if (this.getInput() < o.getInput()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	static class Pair {
		private int input;
		private int check;

		public Pair(int input, int check) {
			this.input = input;
			this.check = check;
		}

		public int getInput() {
			return input;
		}

		public int getCheck() {
			return check;
		}

	}
}

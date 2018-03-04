package baekjoon.sk.queue.p_11866;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int permutation = scanner.nextInt();

		int jump = scanner.nextInt();

		Queue<Integer> q = new LinkedList();

		for (int i = 0; i < permutation; i++) {
			q.offer(i + 1);
		}

		int cnt = 0;

		System.out.print("<");

		while (!q.isEmpty()) {

			if (q.size() == 1) {
				System.out.print(q.poll());
			} else if (cnt == (jump - 1)) {
				System.out.print(q.poll() + ", ");
				cnt = 0;
			} else {
				q.offer(q.poll());
				cnt++;
			}

		}

		System.out.print(">");

	}
}

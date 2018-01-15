package baekjoon.sk.stack.p_1966;

import java.util.*;

public class Main {

	public static class Print {
		int priority;
		int position;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int TestCase = scanner.nextInt();

		while (TestCase-- > 0) {

			Queue<Print> q = new LinkedList<Print>();

			int queueSize = scanner.nextInt();
			int findPos = scanner.nextInt();

			scanner.nextLine();

			String[] line = scanner.nextLine().split(" ");

			for (int i = 0; i < queueSize; i++) {

				Print tmpPrint = new Print();

				tmpPrint.position = i;
				tmpPrint.priority = Integer.parseInt(line[i]);

				q.offer(tmpPrint);
			}

			findOrderPrint(q, findPos);

		}

	}

	public static void findOrderPrint(Queue<Print> q, int findPos) {

		int firstPriority = q.peek().priority;

		int printCnt = 0;

		while (true) {
			if (findBiggerPriority(q, firstPriority)) {
				q.offer(q.poll());
				firstPriority = q.peek().priority;
			} else {

				if (q.peek().position == findPos) {
					printCnt++;
					break;
				} else {
					q.poll();
					printCnt++;
					firstPriority = q.peek().priority;
				}
			}
		}

		System.out.println(printCnt);

	}

	public static boolean findBiggerPriority(Queue<Print> q, int firstPriority) {

		boolean result = false;

		int size = q.size() - 1;

		q.offer(q.poll());

		while (size-- > 0) {

			if (q.peek().priority > firstPriority) {
				result = true;
			}

			q.offer(q.poll());

		}

		return result;

	}
}

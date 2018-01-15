package baekjoon.sk.deque.p_10866;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCase = scanner.nextInt();

		List<String> dequeue = new ArrayList<String>();
		
		scanner.nextLine();

		while (testCase-- > 0) {

			String[] cmd = scanner.nextLine().split(" ");

			switch (cmd[0]) {

			case "push_back":
				dequeue.add(cmd[1]);
				break;

			case "push_front":
				dequeue.add(0, cmd[1]);
				break;

			case "pop_back":
				if (!dequeue.isEmpty()) {
					System.out.println(dequeue.get(dequeue.size() - 1));
					dequeue.remove(dequeue.size() - 1);
				} else
					System.out.println("-1");
				break;
			case "pop_front":
				if (!dequeue.isEmpty()) {
					System.out.println(dequeue.get(0));
					dequeue.remove(0);
				} else
					System.out.println("-1");
				break;
			case "size":
				System.out.println(dequeue.size());
				break;

			case "empty":
				if (dequeue.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
				break;

			case "back":
				if (!dequeue.isEmpty()) {
					System.out.println(dequeue.get(dequeue.size() - 1));
				} else
					System.out.println("-1");
				break;
			case "front":
				if (!dequeue.isEmpty()) {
					System.out.println(dequeue.get(0));
				} else
					System.out.println("-1");
				break;
			}
		}
	}
}

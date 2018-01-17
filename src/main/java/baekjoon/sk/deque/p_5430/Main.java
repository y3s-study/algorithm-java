package baekjoon.sk.deque.p_5430;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCase = scanner.nextInt();

		scanner.nextLine();

		while (testCase-- > 0) {

			String[] command = scanner.nextLine().split("");

			int N = scanner.nextInt();

			scanner.nextLine();

			String inputArr = scanner.nextLine();

			String[] refinedArr = inputArr.substring(1, inputArr.length() - 1)
					.split(",");

			Deque<String> deque = new LinkedList<String>();

			if (!refinedArr[0].equals("")) {
				for (String tmp : refinedArr) {
					deque.add(tmp);
				}
			}

			boolean firstLast = false;
			boolean emptyError = false;

			for (String tmp : command) {
				if (tmp.equals("R")) {
					firstLast = !firstLast;
				} else {

					if (deque.isEmpty()) {
						System.out.println("error");
						emptyError = true;
						break;
					}

					if (firstLast) {
						deque.pollLast();
					} else {
						deque.pollFirst();
					}
				}
			}

			StringBuilder sb = new StringBuilder("");

			if (!emptyError) {

				if (deque.size() != 0) {
					int size = deque.size() - 1;
					while (size-- > 0) {
						sb.append((firstLast) ? (deque.pollLast() + ",")
								: (deque.poll() + ","));
					}
					sb.append((firstLast) ? deque.pollLast() : deque.poll());
				}

				System.out.println("[" + sb.toString() + "]");

			}

		}
	}
}

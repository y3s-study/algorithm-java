package baekjoon.sk.deque.p_5430;

import static java.util.stream.Collectors.joining;
import java.util.*;

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

			inputArr = inputArr.replace("[", "");
			inputArr = inputArr.replace("]", "");

			String[] refinedArr = inputArr.split(",");

			Deque<String> deque = new LinkedList<String>();

			for (String tmp : refinedArr) {
				if (!tmp.equals(""))
					deque.add(tmp);
			}

			boolean firstLast = true;
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
						deque.pollFirst();
					} else {
						deque.pollLast();
					}
				}
			}

			if (!emptyError) {
				if (firstLast)
					System.out.println(deque.stream().map(String::valueOf)
							.sorted().collect(joining(",", "[", "]")));
				else
					System.out.println(deque.stream().map(String::valueOf)
							.sorted(Comparator.reverseOrder())
							.collect(joining(",", "[", "]")));
			}
			
		}
	}
}

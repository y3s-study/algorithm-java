package baekjoon.sk.queue.p_10828;

import java.util.*;

public class Main {

	public static void main(String args[]) {

		List<String> stack = new ArrayList<String>();

		Scanner scanner = new Scanner(System.in);

		int testCase = scanner.nextInt(), i;

		scanner.nextLine();
		
		for (i = 0; i < testCase; i++) {
			String command[] = scanner.nextLine().split(" ");

			switch (command[0]) {
			case "push":
				stack.add(command[1]);
				break;
			case "pop":
				if (stack.size() == 0)
					System.out.println("-1");
				else {
					System.out.println(stack.get(stack.size() - 1));
					stack.remove(stack.size() - 1);
				}
				break;

			case "top":
				if (stack.size() != 0)
					System.out.println(stack.get(stack.size() - 1));
				else
					System.out.println("-1");
				break;

			case "size":
				System.out.println(stack.size());
				break;

			case "empty":
				if (stack.size() == 0)
					System.out.println("1");
				else
					System.out.println("0");
				break;
			}
		}
	}

}

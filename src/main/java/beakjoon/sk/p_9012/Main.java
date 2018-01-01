package beakjoon.sk.p_9012;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCase = scanner.nextInt();

		scanner.nextLine();

		for (int i = 0; i < testCase; i++) {

			List<String> stack = new ArrayList<String>();

			String line;

			int ptr = 0, flag = 0;

			line = scanner.nextLine();

			String[] temp = line.split("");

			while (ptr < line.length()) {

				if (temp[ptr].equals("(")) {
					stack.add("(");
					ptr++;
				} else if (temp[ptr].equals(")")) {
					if (stack.size() == 0) {
						flag = 1;
						break;
					} else {
						stack.remove(stack.size() - 1);
						ptr++;
					}
				}
			}

			if (stack.size() != 0 || flag == 1) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}

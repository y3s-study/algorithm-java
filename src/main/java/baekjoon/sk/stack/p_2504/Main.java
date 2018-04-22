package baekjoon.sk.stack.p_2504;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		List<String> stack = new ArrayList<String>();

		String line = scanner.nextLine();

		if (isVPS(line)) {

			int depth = 0, level = 0, x = 0, flag = 0;

			List<Integer> add_stack = new ArrayList<Integer>();
			List<Integer> ptr_stack = new ArrayList<Integer>();

			String[] temp = line.split("");

			for (int i = 0; i < temp.length; i++) {

				if (temp[i].equals("(")) {

					if (flag == 1) {
						level = 0;
						ptr_stack.add(depth);
						add_stack.add(x);
						x = 0;
					}

					stack.add("(");
					depth++;

					flag = 0;
				} else if (temp[i].equals("[")) {

					if (flag == 1) {
						level = 0;
						ptr_stack.add(depth);
						add_stack.add(x);
						x = 0;
					}

					stack.add("[");
					depth++;

					flag = 0;

				} else if (temp[i].equals(")")) {

					stack.remove(stack.size() - 1);

					if (level == 0) {
						x = 2;
					} else {
						x *= 2;
					}
					level++;
					depth--;

					if (!ptr_stack.isEmpty()
							&& depth == ptr_stack.get(ptr_stack.size() - 1)) {
						if (!add_stack.isEmpty()) {
							x += add_stack.get(add_stack.size() - 1);
							add_stack.remove(add_stack.size() - 1);
							ptr_stack.remove(ptr_stack.size() - 1);
						}
					}

					flag = 1;

				} else if (temp[i].equals("]")) {

					stack.remove(stack.size() - 1);

					if (level == 0) {
						x = 3;
					} else {
						x *= 3;
					}
					level++;
					depth--;

					if (!ptr_stack.isEmpty()
							&& depth == ptr_stack.get(ptr_stack.size() - 1)) {
						if (!add_stack.isEmpty()) {
							x += add_stack.get(add_stack.size() - 1);
							add_stack.remove(add_stack.size() - 1);
							ptr_stack.remove(ptr_stack.size() - 1);
						}
					}

					flag = 1;
				}

			}

			System.out.println(x);

		} else {
			System.out.println("0");
		}

	}

	private static boolean isVPS(String input) {

		List<String> stack = new ArrayList<String>();

		int ptr = 0, flag = 0;

		String[] temp = input.split("");

		while (ptr < input.length()) {

			if (temp[ptr].equals("(")) {
				stack.add("(");
				ptr++;
			} else if (temp[ptr].equals("[")) {
				stack.add("[");
				ptr++;
			} else if (temp[ptr].equals(")")) {
				if (stack.size() == 0) {
					flag = 1;
					break;
				} else {
					if (!stack.get(stack.size() - 1).equals("(")) {
						flag = 1;
						break;
					}
					stack.remove(stack.size() - 1);
					ptr++;
				}
			} else if (temp[ptr].equals("]")) {
				if (stack.size() == 0) {
					flag = 1;
					break;
				} else {
					if (!stack.get(stack.size() - 1).equals("[")) {
						flag = 1;
						break;
					}
					stack.remove(stack.size() - 1);
					ptr++;
				}
			}
		}

		if (stack.size() != 0 || flag == 1) {
			return false;
		} else {
			return true;
		}
	}

}

package beakjoon.sk.p_1874;

import java.util.*;

public class Main {
	public static void main(String args[]) {

		List<String> stack = new ArrayList<String>();
		List<String> answer = new ArrayList<String>();

		int flag = 0;

		Scanner scanner = new Scanner(System.in);

		int testCase = scanner.nextInt();

		String input[] = new String[testCase];

		scanner.nextLine();

		for (int i = 0; i < testCase; i++)
			input[i] = scanner.nextLine();

		int ptr = 0, seq = 1;

		while (ptr != testCase) {
			if (seq < Integer.parseInt(input[ptr])) {
				stack.add(Integer.toString(seq));
				answer.add("+");
				seq++;
			} else if (seq == Integer.parseInt(input[ptr])) {
				stack.add(Integer.toString(seq));
				answer.add("+");

				if (input[ptr].equals(stack.get(stack.size() - 1))) {
					stack.remove(stack.size() - 1);
					answer.add("-");
					seq++;
					ptr++;
				}
			} else {
				if (input[ptr].equals(stack.get(stack.size() - 1))) {
					stack.remove(stack.size() - 1);
					answer.add("-");
					ptr++;
				} else {
					System.out.println("NO");
					flag = 1;
					break;
				}
			}
		}

		if (flag != 1) {
			for (String tmp : answer) {
				System.out.println(tmp);
			}
		}

	}
}

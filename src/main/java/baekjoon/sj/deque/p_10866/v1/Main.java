package baekjoon.sj.deque.p_10866.v1;

import java.util.ArrayList;
import java.util.Scanner;

//10866	arraylist 사용
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		ArrayList<String> list = new ArrayList<>();
		String[] input;
		sc.nextLine();

		while (testCase-- > 0) {
			input = sc.nextLine().split(" ");
			switch (input[0]) {
			case "push_front":
				list.add(0, input[1]);
				break;
			case "push_back":
				list.add(input[1]);
				break;
			case "pop_front":
				System.out.println(list.isEmpty() ? -1 : list.remove(0));
				break;
			case "pop_back":
				System.out.println(list.isEmpty() ? -1 : list.remove(list.size() - 1));
				break;
			case "size":
				System.out.println(list.size());
				break;
			case "empty":
				System.out.println(list.isEmpty() ? 1 : 0);
				break;
			case "front":
				System.out.println(list.isEmpty() ? -1 : list.get(0));
				break;
			case "back":
				System.out.println(list.isEmpty() ? -1 : list.get(list.size() - 1));
				break;
			default:
				break;
			}
		}
	}
}

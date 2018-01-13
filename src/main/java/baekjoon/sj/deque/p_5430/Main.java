package baekjoon.sj.deque.p_5430;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//5430
/*
	2
	R
	0
	[]
	D
	0
	[]
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		Deque<String> deque = new LinkedList<String>();

		while (testCase-- > 0) {
			deque.clear();
			char[] p = sc.next().replaceAll("RR", "").toCharArray();
			int n = sc.nextInt();
			String inputStr = sc.next();
			inputStr = inputStr.replace("[", "");
			inputStr = inputStr.replace("]", "");
			String[] inputArr = inputStr.split(",");

			int length;
			if (!inputArr[0].equals("")) {
				length = inputArr.length;
				for (int i = 0; i < length; i++) {
					deque.offer(inputArr[i]);
				}
			}

			boolean reverse = false;
			boolean isNull = false;
			length = p.length;
			for (int i = 0; i < length; i++) {
				if (p[i] == 'R') {
					reverse = !reverse;
				} else if (p[i] == 'D') {
					if (!deque.isEmpty()) {
						if (reverse) {
							deque.pollLast();
						} else {
							deque.poll();
						}
					} else {
						System.out.println("error");
						isNull = true;
						break;
					}
				}
			}
			StringBuilder sb = new StringBuilder("");
			if (!isNull) {
				if(deque.size() != 0){
					int size = deque.size() -1;
					while (size-- > 0) {
						sb.append((reverse) ? (deque.pollLast() + ",") : (deque
								.poll() + ","));
					}
					sb.append((reverse) ? deque.pollLast() : deque.poll());
				}
				System.out.println("[" + sb.toString() + "]");
			}
		}
	}
}

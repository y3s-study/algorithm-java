package baekjoon.sj.deque.p_1021;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//1021
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Deque<Integer> deque = new LinkedList<>(); // push 맨 앞, offer 맨뒤
		
		while (n-- > 0) {
			deque.push(n + 1);
		}

		int totalMoveCnt = 0;
		int value;
		int leftMoveCnt;
		int rightMoveCnt;
		while (m-- > 0) {
			value = sc.nextInt();
			if (deque.peek() != value) {
				if ((leftMoveCnt = leftMoveCnt(deque, value)) > (rightMoveCnt = rightMoveCnt(deque, value))) {
					moveRight(deque, rightMoveCnt);
					totalMoveCnt += rightMoveCnt;
				} else {
					moveLeft(deque, leftMoveCnt);
					totalMoveCnt += leftMoveCnt;
				}
			} else {
				deque.poll();
			}
		}
		System.out.println(totalMoveCnt);
	}

	static int leftMoveCnt(Deque<Integer> deque, int value) {
		int cnt = 0;
		boolean findNumber = false;
		for (int i = 0; i < deque.size(); i++) {
			if (deque.peek() == value) {
				findNumber = true;
			}
			if (!findNumber) {
				cnt++;
			}
			deque.offer(deque.poll());
		}
		return cnt;
	}

	static int rightMoveCnt(Deque<Integer> deque, int value) {
		int cnt = 0;
		boolean findNumber = false;
		for (int i = 0; i < deque.size(); i++) {
			if (deque.peek() == value) {
				findNumber = true;
			}
			if (!findNumber) {
				cnt++;
			}
			deque.push(deque.pollLast());
		}
		return cnt;
	}

	static void moveLeft(Deque<Integer> deque, int value) {
		while (value-- > 0) {
			deque.offer(deque.poll());
		}
		deque.poll();
	}

	static void moveRight(Deque<Integer> deque, int value) {
		while (value-- > 0) {
			deque.push(deque.pollLast());
		}
		deque.poll();
	}
}

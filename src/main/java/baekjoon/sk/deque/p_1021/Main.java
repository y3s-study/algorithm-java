package baekjoon.sk.deque.p_1021;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// deque 사이즈
		int n = scanner.nextInt();

		// 뽑아 내고자 하는 원호의 수
		int m = scanner.nextInt();

		Deque<Integer> deque = new LinkedList<Integer>();

		// deque 초기화
		for (int i = 1; i < n + 1; i++) {
			deque.add(i);
		}

		// 출력 카운트
		int cnt = 0;

		// 출력해야되는 위치 순서 입력
		for (int i = 0; i < m; i++) {
			cnt = cnt + countMove(deque, scanner.nextInt());
		}

		System.out.println(cnt);

	}

	public static int countMove(Deque<Integer> deque, int pos) {

		int leftMove = 0;
		int rightMove = 0;

		while (!deque.peekFirst().equals(pos)) {
			deque.addLast(deque.pollFirst());
			leftMove++;
		}

		rightMove = deque.size() - leftMove;
		
		deque.pollFirst();

		return Math.min(rightMove, leftMove);
	}

}

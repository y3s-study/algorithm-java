package baekjoon.sj.deque.p_10866.v2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//10866 queue 2개 사용
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		Queue<String> queue = new LinkedList();
		Queue<String> tmpQueue = new LinkedList();
		String[] input;
		sc.nextLine();

		while (testCase-- > 0) {
			input = sc.nextLine().split(" ");
			switch (input[0]) {
			case "push_front":
				push_front(queue, tmpQueue, input[1]);
				break;
			case "push_back":
				queue.offer(input[1]);
				break;
			case "pop_front":
				System.out.println(queue.isEmpty() ? -1 : queue.poll());
				break;
			case "pop_back":
				System.out.println(queue.isEmpty() ? -1 : pop_back(queue,
						tmpQueue));
				tmpQueueCopyAndClear(queue, tmpQueue);
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.isEmpty() ? 1 : 0);
				break;
			case "front":
				System.out.println(queue.isEmpty() ? -1 : queue.peek());
				break;
			case "back":
				System.out
						.println(queue.isEmpty() ? -1 : back(queue, tmpQueue));
				tmpQueueCopyAndClear(queue, tmpQueue);
				break;
			default:
				break;
			}
		}
	}

	static void tmpQueueCopyAndClear(Queue<String> queue, Queue<String> tmpQueue) {
		while (!tmpQueue.isEmpty()) {
			queue.offer(tmpQueue.poll());
		}
		
		tmpQueue.clear();
//		Queue<String> tmp = new LinkedList<>();
//		
//		tmp = tmpQueue;
//		tmpQueue = queue;
//		queue = tmp;
	}

	static void push_front(Queue<String> queue, Queue<String> tmpQueue, String input) {
		tmpQueue.offer(input);

		while (!queue.isEmpty()) {
			tmpQueue.offer(queue.poll());
		}

		tmpQueueCopyAndClear(queue, tmpQueue);
	}

	static String pop_back(Queue<String> queue, Queue<String> tmpQueue) {
		while (queue.size() != 1) {
			tmpQueue.offer(queue.poll());
		}

		return queue.poll();
	}

	static String back(Queue<String> queue, Queue<String> tmpQueue) {
		while (queue.size() != 1) {
			tmpQueue.offer(queue.poll());
		}
		tmpQueue.offer(queue.peek());

		return queue.poll();
	}
}

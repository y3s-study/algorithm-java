package baekjoon.sj.p_11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//11866
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>(); // offer: 넣기, poll: 꺼내기, // peek: 맨 아래 객체 반환
		int moveCnt = 0;				// 실제 이동한 횟수
		int position = -1; 				// 최초에 0을 방문하기 위하여
		int indexPosition = (position + 1) % n;
		int[] visitArr = new int[n]; 	// 0: 방문하지 않음, 1: 방문함
		while (queue.size() < n) {
			while (moveCnt < m) {
				indexPosition = (position + 1) % n;
				if (visitArr[indexPosition] == 0) {
					moveCnt++;
				}
				position = indexPosition;
			}
			visitArr[indexPosition] = 1;
			moveCnt = 0;
			queue.offer(position + 1);
		}
		System.out.print("<");
		while (!queue.isEmpty()) {
			System.out.print(queue.poll());
			if (queue.isEmpty()) {
				System.out.print(">");
			} else {
				System.out.print(", ");
			}
		}
	}
}

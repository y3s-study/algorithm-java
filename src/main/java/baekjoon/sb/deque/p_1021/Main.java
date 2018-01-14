package baekjoon.sb.deque.p_1021;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String[] selectList = sc.nextLine().split(" ");
		
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=1; i <= N; i++) {
			q.addLast(i);
		}
		
		int cnt = 0;
		for(String s : selectList) {
			int selectNumber = Integer.parseInt(s);
			
			while(selectNumber != q.getFirst()) {
				int firstDiff = q.indexOf(selectNumber);
				int lastDiff = q.size() - 1 - firstDiff;
				
				if (firstDiff < lastDiff+1) {
					q.addLast(q.removeFirst()); // left rotate
				} else {
					q.addFirst(q.removeLast()); // right roate
				}
				cnt++;
			}
			q.removeFirst();
		}
		
		System.out.println(cnt);
	}
	
}

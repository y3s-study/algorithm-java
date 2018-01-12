package baekjoon.sj.deque.p_5430;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//5430
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		Deque<String> deque = new LinkedList<String>();

		while (testCase-- > 0) {
			deque.clear();
			char[] p = sc.next().toCharArray();
			int n = sc.nextInt();
			String inputStr = sc.next();
			String[] inputArr = inputStr.substring(1, inputStr.length() - 1).toString().split(",");
			
			for (int i = 0; i < inputArr.length; i++) {
				if(!inputArr[i].equals("")){
					deque.offer(inputArr[i]);
				}
			}

			String result = "";
			boolean isNull = false;
			for (int i = 0; i < p.length; i++) {
				if (p[i] == 'R') {
					Reverse(deque);
				} else if (p[i] == 'D') {
					if (!deque.isEmpty()) {
						deque.poll();
					} else {
						System.out.println("error");
						isNull = true;
						break;
					}
				}
			}
			if (!isNull) {
				while(deque.size() != 1){
					result += deque.poll()+",";
				}
				result += deque.poll();
				System.out.println("["+result+"]");
			}
		}
	}

	static void Reverse(Deque<String> deque) {
		Deque<String> reverseDeque = new LinkedList<>();
		
		int size = deque.size();
		while(size-- > 0){
			reverseDeque.offer(deque.pollLast());
		}
		deque.clear();
		
		while(!reverseDeque.isEmpty()){
			deque.offer(reverseDeque.poll());
		}
	}
}

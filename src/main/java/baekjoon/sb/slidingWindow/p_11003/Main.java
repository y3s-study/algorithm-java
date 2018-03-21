package baekjoon.sb.slidingWindow.p_11003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken()); // N 개의 수
		int L = Integer.parseInt(tokenizer.nextToken()); // 한 번에 볼 수 있는 개수
		StringBuilder sb = new StringBuilder();

		Deque<Integer> dq = new LinkedList<>();
		
		tokenizer = new StringTokenizer(reader.readLine());
		int[] numbers = new int[N];
		
		
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.valueOf(tokenizer.nextToken());
			if(!dq.isEmpty() && dq.getFirst() <= i-L) {
				dq.pollFirst();
			}
			while(!dq.isEmpty() && numbers[dq.getLast()] >= numbers[i]) {
				dq.pollLast();
			}
			dq.offerLast(i);
			sb.append(numbers[dq.getFirst()] + " ");
		}
		
		System.out.println(sb.toString());
	}

}

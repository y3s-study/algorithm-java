package baekjoon.sb.divideAndConquer.p_6549;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.LongStream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		while((n = sc.nextInt()) != 0) {
			long[] input = LongStream.generate(sc::nextLong).limit(n).toArray();

			Stack<Integer> st = new Stack<>();

			long ret = 0;
			st.push(-1);
			
			int i;
			for(i = 0; i < n; i++) {
				while(!st.isEmpty() && st.peek() > -1 && input[i] < input[st.peek()]) {
					int tmp = st.pop();
					if(!st.isEmpty()) {
						ret = Math.max(ret, (long)input[tmp] * (i-st.peek()-1));
					}
				}

				st.push(i);
			}

			while(!st.isEmpty()) {
				int tmp = st.pop();
				if(!st.isEmpty()) {
					ret = Math.max(ret, (long)input[tmp] * (i-st.peek()-1));
				}
			}

			System.out.println(ret);
		}
	}
	
}

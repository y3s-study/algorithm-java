package baekjoon.sb.queue.p_1966;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int N = sc.nextInt();
			int index = sc.nextInt();
			sc.nextLine();
			
			Queue<Input> q = new ArrayDeque<>();
			
			String[] priority = sc.nextLine().split(" ");
			for(int j = 0; j < N; j++) {
				q.add(new Input(j+1, Integer.parseInt(priority[j])));
			}
			
			int ret = 1;
			Input maxInput = getMaxPriorityInput(q);
			
			while(true) {
				
				if( maxInput.equals(q.peek()) )
				{
					if( index + 1 == q.peek().getN() && maxInput.equals(getMaxPriorityInput(q)) ) {
						break;
					}
					q.poll();
					ret++;
					maxInput = getMaxPriorityInput(q);
				}
				else {
					q.add(q.poll());
				}
			}
			
			System.out.println(ret);
			
		}
		
		sc.close();
	}
	
	public static Input getMaxPriorityInput(Queue<Input> que) {
		Input maxInput = que.peek();
		for (Input i : que) {
			if (maxInput.getPriority() < i.getPriority()) {
				maxInput = i;
			}

		}
		return maxInput;
	}

}

class Input {
	private int n;
	private int priority;
	
	
	public Input() {
		
	}
	
	public Input(int n, int priority) {
		this.n = n;
		this.priority = priority;
	}

	public void setInput(Input i) {
		this.n = i.n;
		this.priority = i.priority;
	}
	
	public int getN() {
		return n;
	}
	
	public int getPriority() {
		return priority;
	}
}
package baekjoon.sb.stack.p_10828;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		String input = null;
		String [] inputArray;
		Stack stack = new Stack();
		
		n = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<n; i++) {
			input = sc.nextLine();
			inputArray = input.split(" ");
			
			switch(inputArray[0]) {
				case "push":
					stack.push(Integer.parseInt(inputArray[1]));
					break;
				case "pop":
					System.out.println(stack.pop());
					break;
				case "size":
					System.out.println(stack.getSize());
					break;
				case "empty":
					System.out.println(stack.isEmpty());
					break;
				case "top":
					System.out.println(stack.top());
					break;
			}
			
		}
		
		sc.close();

	}

}

class Stack {
	
	private ArrayList<Integer> list = new ArrayList<>();
	private int top = -1;
	
	public void push(int i) {
		list.add(i);
		top++;
	}
	
	public int pop() {
		int n = -1;
		if(top >= 0) {
			n = list.get(top);
			list.remove(top--);
		}
		return n;
	}
	
	public int getSize() {
		return top+1;
	}
	
	public int isEmpty() {
		if(top == -1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int top() {
		if(top >= 0) {
			return list.get(top);
		}
		else {
			return -1;
		}
	}
}

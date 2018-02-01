package baekjoon.sb.stack.p_1874;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int input = 0;
		ArrayList<Character> list = new ArrayList<>();
		int index = 1;
		Stack<Integer> s = new Stack<>();
		boolean ret = true;
		
		for(int i=0; i<num; i++) {
			input = sc.nextInt();
			if(index <= input) {
				while(index <= input) {
					s.push(index++);
					list.add('+');
				}
				if(index-1 == input) {
					s.pop();
					list.add('-');
				}
			}
			else {
				if(!s.isEmpty() && s.peek() == input) {
					while(!s.isEmpty()) {
						int pop = s.pop();
						list.add('-');
						if(pop == input) {
							break;
						}
					}
				}
				else {
					ret = false;
				}
			}
			
		}
		
		if(ret) {
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		else {
			System.out.println("NO");
		}
		
		
		sc.close();

	}

}

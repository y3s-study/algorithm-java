package baekjoon.sb.p_2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] inputArr = input.toCharArray();
		int len = input.length();
		Stack<Character> s = new Stack<>();
		char current = 0;
		char next = 0;
		int mul = 1;
		int sum = 0;
		
		for(int i=0; i<len; i++) {
			current = inputArr[i];
			if(i < len-1) {
				next = inputArr[i+1];
			}
			
			if(current == '(') {
				s.push(current);
				mul = mul*2;
				
				if(next == ')') {
					sum = sum + mul;
				}
			}
			else if(current == '[') {
				s.push(current);
				mul = mul*3;
				
				if(next == ']') {
					sum = sum + mul;
				}
			}
			else if(current == ')' && !s.isEmpty() && s.peek() == '(') {
				s.pop();
				mul = mul/2;
			}
			else if(current == ']' && !s.isEmpty() && s.peek() == '[') {
				s.pop();
				mul = mul/3;
			}
			else {
				System.out.println(0);
				return;
			}
		}
		
		if(s.isEmpty()) {
			System.out.println(sum);
		}
		else {
			System.out.println(0);
		}

	}

}

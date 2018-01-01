package baekjoon.sb.p_9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		String input;
		char[] inputArr;
		int len=0;
		Stack<Character> stack = new Stack<>();
		boolean ret = true;
		
		for(int i=0; i<T; i++) {
			input=sc.nextLine();
			inputArr = input.toCharArray();
			len = input.length();
			ret = true;
			
			for(int j=0; j<len; j++) {
				if(inputArr[j] == '(') {
					stack.push(inputArr[j]);
				} else {
					if(stack.isEmpty()) {
						ret = false;
						break;
					}
					if(stack.pop() != '(') {
						ret = false;
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) {
				ret = false;
			}
			stack.removeAllElements();
			
			if(ret == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}

	}

}

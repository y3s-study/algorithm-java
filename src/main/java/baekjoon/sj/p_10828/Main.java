package baekjoon.sj.p_10828;

import java.util.Scanner;
import java.util.Stack;

//stack
//10828
public class Main {
	static String[] arr = {"push", "pop", "size", "empty", "top"};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i;
		String input;
		Stack<String> stack = new Stack<String>();
		for(i=0; i<n; i++){
			input = sc.next();
			if(input.equals(arr[0])){
				stack.add(sc.next());
			}else if(input.equals(arr[1])){
				if(stack.empty()){
					System.out.println(-1);
				}else{
					System.out.println(stack.remove(stack.size()-1));
				}
			}else if(input.equals(arr[2])){
				System.out.println(stack.size());
			}else if(input.equals(arr[3])){
				if(stack.empty()){
					System.out.println(1);
				}else{
					System.out.println(0);
				}
			}else if(input.equals(arr[4])){
				if(stack.empty()){
					System.out.println(-1);
				}else{
					System.out.println(stack.get(stack.size()-1));
				}
			}
		}
	}
}

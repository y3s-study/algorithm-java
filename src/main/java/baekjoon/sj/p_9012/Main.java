package baekjoon.sj.p_9012;

import java.util.Scanner;
import java.util.Stack;

//9012
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, j;
		char[][] input = new char[n][];
		Stack<Integer> stack = new Stack<>();	//0:(  1: ) 
		
		for(i=0; i<n; i++){
			input[i] = sc.next().toCharArray();
			for(j=0; j<input[i].length; j++){
				if(input[i][j] == '('){
					stack.add(0);
				}else{
					if(stack.empty()){
						break;
					}else{
						stack.remove(stack.size()-1);
					}
				}
			}
			if(j == input[i].length && stack.empty()){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
//			stack.removeAllElements();
			stack.clear();
		}
	}
}

package baekjoon.sj.stack.p_2504;

import java.util.Scanner;
import java.util.Stack;

//2504
public class Main {
	//앞이 정수일 경우에는 값을 더하거나 곱해야 하기 때문에 필요한 메소드
	//rule은 1: +2, 2: *2, 3: +3, 4: *3
	//rule 5는 "3(())"의 경우에 뒤에꺼를 계산한 후 에 앞에 정수 3과 더하기 위한 규칙
	public static void frontInteger(Stack<String> stack, int rule){
		int value = Integer.parseInt(stack.peek());
		switch (rule) {
		case 1:
			value += 2;
			break;
		case 2:
			value *= 2;
			break;
		case 3:
			value += 3;
			break;
		case 4:
			value *= 3;
			break;
		case 5:
			value += Integer.parseInt(stack.get(stack.size()-2));
			stack.pop();	//앞 정수 삭제
			break;
		}
		stack.pop();	//앞 정수 삭제
		stack.push(String.valueOf(value));
	}
	//괄호를 삭제하기 위한 메소드
	public static void removeBracket(Stack<String> stack, int j){
		stack.remove(j);	//(,[ 삭제
		stack.pop();	//),] 삭제
	}
	//괄호 사이에 정수가 있는지 괄호만 있는지에 따라 분리되는 메소드
	//rule 1: 바로 앞인 경우, 2: 앞앞인 경우
	public static boolean isInteger(Stack<String> stack, int rule){
		boolean result=false;
		switch (rule) {
		case 1:
			if(!stack.peek().equals("(") && !stack.peek().equals("[")){
				result = true;
			}
			break;
		case 2:
			if(!stack.get(stack.size()-2).equals("(") && !stack.get(stack.size()-2).equals("[")){
				result = true;
			}
			break;
		}
		return result;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<>();
		char[] input = sc.next().toCharArray();
		int i, j;
		int result = 0;
		boolean isValid = true;
		for(i=0; i<input.length; i++){
			//해당 문자가 ),]인 경우
			if(input[i] == ')' || input[i] == ']'){
				stack.push(String.valueOf(input[i]));
				for(j=stack.size()-1; j>=0; j--){
					if(input[i] == ')'){
						if(stack.get(j).equals("(")){
							removeBracket(stack, j);
							//바로 앞이 숫자인지 ( 인지에 따라서 list에 넣는 값이 달라짐.
							if(j == stack.size()){
								if(stack.size() > 1 && isInteger(stack, 1)){
									frontInteger(stack, 1);
								}else{
									stack.push("2");
								}
							}else{
								//()사이에 숫자가 들어가 있음.
								//올바르지 않은 괄호인 경우에 예외처리
								try{
									frontInteger(stack, 2);
									if(stack.size() > 1 && isInteger(stack, 2)){
										frontInteger(stack, 5);
									}
								}catch(Exception e){
									isValid = false;
								}
							}
							break;
						}else if(stack.get(j).equals("[")){
							isValid = false;
							break;
						}
					}else if(input[i] == ']'){
						if(stack.get(j).equals("[")){
							removeBracket(stack, j);		//괄호 삭제
							//바로 앞이 숫자인지 [ 인지에 따라서 list에 넣는 값이 달라짐.
							if(j == stack.size()){
								if(stack.size() > 1 && isInteger(stack, 1)){
									frontInteger(stack, 3);
								}else{
									stack.add("3");
								}
							}else{
								//[]사이에 숫자가 들어가 있음.
								//올바르지 않은 괄호인 경우에 예외처리
								try{
									frontInteger(stack, 4);
									if(stack.size() > 1 && isInteger(stack, 2)){
										frontInteger(stack, 5);
									}
								}catch(Exception e){
									isValid = false;
								}
							}
							break;
						}else if(stack.get(j).equals("(")){
							isValid = false;
							break;
						}
					}
				}
			}else{
				stack.push(String.valueOf(input[i]));
			}
		}
		if(isValid){
			for(i=0; i<stack.size(); i++){
				//올바르지 않은 괄호인 경우에 예외처리
				try{
					result += Integer.parseInt(stack.get(i));
				}catch(Exception e){
					System.out.println(0);
					return;
				}
			}
			System.out.println(result);
		}else{
			System.out.println(0);
		}
	}
}

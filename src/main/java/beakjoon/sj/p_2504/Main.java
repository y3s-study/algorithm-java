package beakjoon.sj.p_2504;

import java.util.ArrayList;
import java.util.Scanner;

//2504
public class Main {
	//앞이 정수일 경우에는 값을 더하거나 곱해야 하기 때문에 필요한 메소드
	//rule은 1: +2, 2: *2, 3: +3, 4: *3
	//rule 5는 "3(())"의 경우에 뒤에꺼를 계산한 후 에 앞에 정수 3과 더하기 위한 규칙
	public static void frontInteger(ArrayList<String> list, int rule){
		int value = 0;
		switch (rule) {
		case 1:
			value = Integer.parseInt(list.get(list.size()-1))+2;
			break;
		case 2:
			value = Integer.parseInt(list.get(list.size()-1))*2;
			break;
		case 3:
			value = Integer.parseInt(list.get(list.size()-1))+3;
			break;
		case 4:
			value = Integer.parseInt(list.get(list.size()-1))*3;
			break;
		case 5:
			value = Integer.parseInt(list.get(list.size()-1)) + Integer.parseInt(list.get(list.size()-2));
			list.remove(list.size()-1);	//앞 정수 삭제
			break;
		default:
			break;
		}
		list.remove(list.size()-1);	//앞 정수 삭제
		list.add(String.valueOf(value));
	}
	//괄호를 삭제하기 위한 메소드
	public static void removeBracket(ArrayList<String> list, int j){
		list.remove(j);	//(,[ 삭제
		list.remove(list.size()-1);	//),] 삭제
	}
	//괄호 사이에 정수가 있는지 괄호만 있는지에 따라 분리되는 메소드
	//rule 1: 바로 앞인 경우, 2: 앞앞인 경우
	public static boolean isInteger(ArrayList<String> list, int rule){
		boolean result=false;
		switch (rule) {
		case 1:
			if(!list.get(list.size()-1).equals("(") && !list.get(list.size()-1).equals("[")){
				result = true;
			}
			break;
		case 2:
			if(!list.get(list.size()-2).equals("(") && !list.get(list.size()-2).equals("[")){
				result = true;
			}
			break;
		default:
			break;
		}
		return result;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		char[] input = sc.next().toCharArray();
		int i, j;
		int result = 0;
		boolean isValid = true;
		for(i=0; i<input.length; i++){
			//해당 문자가 ),]인 경우
			if(input[i] == ')' || input[i] == ']'){
				list.add(String.valueOf(input[i]));
				for(j=list.size()-1; j>=0; j--){
					if(input[i] == ')'){
						if(list.get(j).equals("(")){
							removeBracket(list, j);
							//바로 앞이 숫자인지 ( 인지에 따라서 list에 넣는 값이 달라짐.
							if(j == list.size()){
								if(list.size() > 1 && isInteger(list, 1)){
									frontInteger(list, 1);
								}else{
									list.add("2");
								}
							}else{
								//()사이에 숫자가 들어가 있음.
								//올바르지 않은 괄호인 경우에 예외처리
								try{
									frontInteger(list, 2);
									if(list.size() > 1 && isInteger(list, 2)){
										frontInteger(list, 5);
									}
								}catch(Exception e){
									isValid = false;
								}
							}
							break;
						}else if(list.get(j).equals("[")){
							isValid = false;
							break;
						}
					}else if(input[i] == ']'){
						if(list.get(j).equals("[")){
							removeBracket(list, j);		//괄호 삭제
							//바로 앞이 숫자인지 [ 인지에 따라서 list에 넣는 값이 달라짐.
							if(j == list.size()){
								if(list.size() > 1 && isInteger(list, 1)){
									frontInteger(list, 3);
								}else{
									list.add("3");
								}
							}else{
								//[]사이에 숫자가 들어가 있음.
								//올바르지 않은 괄호인 경우에 예외처리
								try{
									frontInteger(list, 4);
									if(list.size() > 1 && isInteger(list, 2)){
										frontInteger(list, 5);
									}
								}catch(Exception e){
									isValid = false;
								}
							}
							break;
						}else if(list.get(j).equals("(")){
							isValid = false;
							break;
						}
					}
				}
			}else{
				list.add(String.valueOf(input[i]));
			}
		}
		if(isValid){
			for(i=0; i<list.size(); i++){
				//올바르지 않은 괄호인 경우에 예외처리
				try{
					result += Integer.parseInt(list.get(i));
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

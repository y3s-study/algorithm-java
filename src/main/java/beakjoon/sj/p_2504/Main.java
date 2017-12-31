package beakjoon.sj.p_2504;

import java.util.ArrayList;
import java.util.Scanner;

//2504
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		char[] input = sc.next().toCharArray();
		int i, j;
		int result = 0;
		int value;
		boolean isValid = true;
		for(i=0; i<input.length; i++){
			//해당 문자가 ),]인 경우
			if(input[i] == ')' || input[i] == ']'){
				list.add(String.valueOf(input[i]));
				for(j=list.size()-1; j>=0; j--){
					if(input[i] == ')'){
						if(list.get(j).equals("(")){
							list.remove(j);	//( 삭제
							list.remove(list.size()-1);	//) 삭제
							//바로 앞이 숫자인지 ( 인지에 따라서 list에 넣는 값이 달라짐.
							if(j == list.size()){
								if(list.size() > 1 && !list.get(list.size()-1).equals("(") && !list.get(list.size()-1).equals("[")){
									value = Integer.parseInt(list.get(list.size()-1))+2;
									list.remove(list.size()-1);
									list.add(String.valueOf(value));
								}else{
									list.add("2");
								}
							}else{
								//()사이에 숫자가 들어가 있음.
								try{
									value = Integer.parseInt(list.get(list.size()-1))*2;
									list.remove(list.size()-1);	//맨뒤 삭제
									list.add(String.valueOf(value));
									if(list.size() > 1){
										if(!list.get(list.size()-2).equals("[") && !list.get(list.size()-2).equals("(")){
											value = Integer.parseInt(list.get(list.size()-1)) + Integer.parseInt(list.get(list.size()-2));
											list.remove(list.size()-1);list.remove(list.size()-1);
											list.add(String.valueOf(value));
										}
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
							list.remove(j);	//[ 삭제
							list.remove(list.size()-1);	//] 삭제
							//바로 앞이 숫자인지 [ 인지에 따라서 list에 넣는 값이 달라짐.
							if(j == list.size()){
								if(list.size() > 1 && !list.get(list.size()-1).equals("(") && !list.get(list.size()-1).equals("[")){
									value = Integer.parseInt(list.get(list.size()-1))+3;
									list.remove(list.size()-1);
									list.add(String.valueOf(value));
								}else{
									list.add("3");
								}
							}else{
								//[]사이에 숫자가 들어가 있음.
								try{
									value = Integer.parseInt(list.get(list.size()-1))*3;
									list.remove(list.size()-1);	//맨뒤 삭제
									list.add(String.valueOf(value));
									if(list.size() > 1){
										if(!list.get(list.size()-2).equals("[") && !list.get(list.size()-2).equals("(")){
											value = Integer.parseInt(list.get(list.size()-1)) + Integer.parseInt(list.get(list.size()-2));
											list.remove(list.size()-1);list.remove(list.size()-1);
											list.add(String.valueOf(value));
										}
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

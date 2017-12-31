package beakjoon.sj.p_1874;

import java.util.ArrayList;
import java.util.Scanner;

//1874
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i;
		int[] stack = new int[n];	//0: 빈값, 1: 입력됨, -1: 출력됨.
		ArrayList<String> result = new ArrayList<>();
		int input;
		int position=0;
		boolean isPlus = true;		//입력값과 현재 위치와 비교를 위한 변수	//초기 입력은 항상 0보다 크기 때문에 true 로 설정
		for(i=0; i<n; i++){
			input = sc.nextInt();
			while(true){
				if(position+1 < input){
					//비었을 경우에만 추가
					if(stack[position] == 0){
						stack[position] = 1;
						result.add("+");
					}
					position++;
					isPlus = true;
				}else if(position+1 > input){
					//값이 있을 경우에만
					if(stack[position-1] == 1){
						stack[position-1] = -1;
						result.add("-");
					}
					position--;
					isPlus = false;
				}else{
					if(isPlus){
						stack[position] = -1;
						result.add("+");
						result.add("-");
					}
					break;
				}
			}
		}
		//입력과 푸시가 가능한 것은 입출력의 반복으로 n*2의 크기가 된다.
		if(result.size() == n*2){
			for(i=0; i<result.size(); i++){
				System.out.println(result.get(i));
			}
		}else{
			System.out.println("NO");
		}
		
	}
}

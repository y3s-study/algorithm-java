package baekjoon.sb.divideAndConquer.p_1992;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][];
		String input;
		sc.nextLine();
		
		for(int i = 0; i < N; i++) {
			input = sc.nextLine();
			arr[i] = new int[N];
			for(int j = 0; j < N; j++) {
				arr[i][j] = Character.getNumericValue(input.charAt(j));
			}
		}
		
		makeQuadTree(arr, 0, 0, N);
	
	}
	
	public static void makeQuadTree(int[][] arr, int x, int y, int size) {
		
		int temp = arr[x][y];
		boolean equal = true;
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(temp == arr[i][j]) {
					continue;
				} else {
					equal = false;
					break;
				}
			}
			if(equal == false) {
				break;
			}
		}
		
		if(equal == true) {
			System.out.print(temp);
		} else {
			System.out.print("(");
			makeQuadTree(arr, x, y, size/2);
			makeQuadTree(arr, x, y + size/2, size/2);
			makeQuadTree(arr, x + size/2, y, size/2);
			makeQuadTree(arr, x + size/2, y + size/2, size/2);
			System.out.print(")");
		}
	}

}

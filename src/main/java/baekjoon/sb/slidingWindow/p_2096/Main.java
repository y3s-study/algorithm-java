package baekjoon.sb.slidingWindow.p_2096;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] inputArr = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				inputArr[i][j] = sc.nextInt();
			}
		}
	
		
		int[][] maxArr = deepCopy(inputArr);
		int[][] minArr = deepCopy(inputArr);
	
		getDownValue(inputArr, N, maxArr, minArr);
		
		int max = Math.max(Math.max(maxArr[N-1][0], maxArr[N-1][1]), maxArr[N-1][2]);
		int min = Math.min(Math.min(minArr[N-1][0], minArr[N-1][1]), minArr[N-1][2]);
		
		System.out.print(max + " " + min);
	}
	
	public static void getDownValue(int[][] inputArr, int N, int[][] maxArr, int[][] minArr) {
				
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					maxArr[i][j] += Math.max(maxArr[i-1][j], maxArr[i-1][j+1]);
					minArr[i][j] += Math.min(minArr[i-1][j], minArr[i-1][j+1]);
				} else if(j == 1) {
					maxArr[i][j] += Math.max(Math.max(maxArr[i-1][j-1], maxArr[i-1][j]), maxArr[i-1][j+1]);
					minArr[i][j] += Math.min(Math.min(minArr[i-1][j-1], minArr[i-1][j]), minArr[i-1][j+1]);
				} else {
					maxArr[i][j] += Math.max(maxArr[i-1][j-1], maxArr[i-1][j]);
					minArr[i][j] += Math.min(minArr[i-1][j-1], minArr[i-1][j]);
				}
			}
		}
	}
	
	public static int[][] deepCopy(int[][] matrix) {
	    return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
	}
}

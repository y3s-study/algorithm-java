package baekjoon.sb.dynamic_programming.p_2342;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(System.in);
		int[][][] arr = new int[5][5][100000]; // 왼발, 오른발 올 수 있는 상태 각각 5개씩, 최대 단계 100000
		int[] input = new int[100000];
		int i = 0;
		while(true) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			
			input[i++] = n;
		}
		
		for(int[][] arr2 : arr) {
			for(int[] arr3 : arr2) {
				Arrays.fill(arr3, -1);
			}
		}
		
		System.out.println(getMinValue(arr, i, input, 0, 0, 0));
	}
	
	public static int getMinValue(int[][][] arr, int N, int[] input, int idx, int left, int right) {
	
		if(N == idx) {
			return 0;
		}
		
		if(arr[left][right][idx] != -1) {
			return arr[left][right][idx];
		}
		
		if(left == 0 && right == 0) {
			return arr[left][right][idx] = getMinValue(arr, N, input, idx+1, input[idx], right) + 2;
		}
		
		if(left == input[idx]) {
			return arr[left][right][idx] = getMinValue(arr, N, input, idx+1, left, right) + 1;
		} else if(right == input[idx]) {
			return arr[left][right][idx] = getMinValue(arr, N, input, idx+1, left, right) + 1;
		}
		
		int leftValue = 0;
		if(left == 0) {
			leftValue = getMinValue(arr, N, input,idx+1, input[idx], right) + 2;
		} else if (Math.abs(left-input[idx]) == 2) {
			leftValue = getMinValue(arr, N, input, idx+1, input[idx], right) + 4;
		} else {
			leftValue = getMinValue(arr, N, input, idx+1, input[idx], right) + 3;
		}
		
		int rightValue = 0;
		if(right == 0) {
			rightValue = getMinValue(arr, N, input, idx+1, left, input[idx]) + 2;
		}  else if (Math.abs(right-input[idx]) == 2) {
			rightValue = getMinValue(arr, N, input, idx+1, left, input[idx]) + 4;
		} else {
			rightValue = getMinValue(arr, N, input, idx+1, left, input[idx]) + 3;
		}
		
		return arr[left][right][idx] = Math.min(leftValue, rightValue);
	}
}

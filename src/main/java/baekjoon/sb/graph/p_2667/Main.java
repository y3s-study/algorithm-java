package baekjoon.sb.graph.p_2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		char[][] matrix = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			char[] input = sc.nextLine().toCharArray();
			for(int j = 0; j < N; j++) {
				matrix[i][j] = input[j];
			}
		}
		
		Boolean[][] visited = new Boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int ret = calc(matrix, visited, i, j, N);
				if(ret != 0) {
					list.add(ret);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i : list) {
			System.out.println(i);
		}
		
	}
	
	public static int calc(char[][] matrix, Boolean[][] visited, int y, int x, int N) {
		if(x >= N || y >= N || x < 0 || y < 0) {
			return 0;
		}
		if(visited[y][x] == true) {
			return 0;
		}
		
		int ret = 0;
		if(matrix[y][x] == '1') {
			visited[y][x] = true;
			ret++;
			ret += calc(matrix, visited, y-1, x, N);
			ret += calc(matrix, visited, y, x-1, N);
			ret += calc(matrix, visited, y+1, x, N);
			ret += calc(matrix, visited, y, x+1, N);
		}
		
		return ret;
	}

}

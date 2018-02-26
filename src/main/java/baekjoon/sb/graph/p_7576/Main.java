package baekjoon.sb.graph.p_7576;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int col = sc.nextInt();
		int row = sc.nextInt();
		int[][] matrix = new int[row][col];
		boolean[][] visited = new boolean[row][col];
		Queue<Point> q = new LinkedList<>();
		int unripeCnt = 0;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				matrix[i][j] = sc.nextInt();
				if(matrix[i][j] == 1) {
					q.offer(new Point(i,j));
					visited[i][j] = true;
				} else if(matrix[i][j] == 0) {
					unripeCnt++;
				}
			}
		}
		
		System.out.println(getDay(matrix, visited, q, row, col, unripeCnt));
	}
	
	public static int getDay(int[][] matrix, boolean[][] visited, Queue<Point> q, int row, int col, int unripeCnt) {
		int[] xAxis = {0, 0, -1, 1};
		int[] yAxis = {-1, 1, 0, 0};
		
		int day = 0;
		while(!q.isEmpty()) {
			Queue<Point> nextQ = new LinkedList<>();
			int qSize = q.size();
			for(int j = 0; j < qSize; j++) {
				Point p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int x = (int)p.getX() + xAxis[i];
					int y = (int)p.getY() + yAxis[i];
					
					if(x < 0 || x >= row || y < 0 || y >= col) {
						continue;
					}
					if(visited[x][y] || matrix[x][y] == -1) {
						continue;
					}
					visited[x][y] = true;
					matrix[x][y] = 1;
					unripeCnt--;
					nextQ.offer(new Point(x, y));
				}
			}
			
			q.addAll(nextQ);
			day++;
		}
		
		if(unripeCnt == 0) {
			return day-1;
		} else {
			return -1;
		}
	}
}

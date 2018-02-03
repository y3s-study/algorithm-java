package baekjoon.sb.divideAndConquer.p_1074;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int size = (int) Math.pow(2.0, (double)N);

		getVisitOrder(0, size, 0, 0, r, c);
		
	}
	
	public static void getVisitOrder(int index, int size, int startX, int startY, int row, int col) {
		
		if(startX == col && startY == row) {
			System.out.println(index);
			return;
		}
		
		
		if(startX + size > col && startX <= col
		&& startY + size > row && startY <= row) {			
			size /= 2;
			
			getVisitOrder(index + size * size * 0, size, startX, startY, row, col);
			getVisitOrder(index + size * size * 1, size, startX + size, startY, row, col);
			getVisitOrder(index + size * size * 2, size, startX, startY + size, row, col);
			getVisitOrder(index + size * size * 3, size, startX + size, startY + size, row, col);
		} 
	}

}

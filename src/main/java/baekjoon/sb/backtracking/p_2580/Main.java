package baekjoon.sb.backtracking.p_2580;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[10][10];
		
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Sudoku sudoku = new Sudoku(arr);
		sudoku.solve();
		sudoku.print();
	}
	
}

class Sudoku {
	private int[][] sudoku;
	private int emptyRow;
	private int emptyCol;
	
	
	public Sudoku(int[][] arr) {
		this.sudoku = arr;
	}
	
	public boolean solve() {
		
		if(checkEmpty()) {
			return true;
		}

		int row = emptyRow;
		int col = emptyCol;
		
		for( int n = 1; n < 10; n++) {
			if(enableInsert(n, row, col)) {
				sudoku[row][col] = n;
				if(solve()) {
					return true;
				} else {
					sudoku[row][col] = 0;
				}
			}
				
		}
		
		return false;
	}
	
	public boolean enableInsert(int n, int row, int col) {
		if( checkRow(n, row) && checkCol(n, col) && checkSquare(n, row, col) ) {
			return true;
		} else {			
			return false;
		}
	}
	
	public boolean checkRow(int n, int row) {
		for(int i = 1; i < 10; i++) {
			if(sudoku[row][i] == n) {
				return false;
			}
		}
		return true;
	}

	
	public boolean checkCol(int n, int col) {
		for(int i = 1; i < 10; i++) {
			if(sudoku[i][col] == n) {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean checkSquare(int n, int row, int col) {
		int xPos = ((col - 1) / 3) * 3;
		int yPos = ((row - 1) / 3) * 3;

		for(int i = 1; i < 4; i++) {
			for(int j = 1; j < 4; j++) {
				if(sudoku[yPos+i][xPos+j] == n) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public boolean checkEmpty() {
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				if(sudoku[i][j] == 0) {
					emptyRow = i;
					emptyCol = j;
					return false;
				}
			}
		}
		return true;
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				sb.append(sudoku[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}
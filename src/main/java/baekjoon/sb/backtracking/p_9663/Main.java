package baekjoon.sb.backtracking.p_9663;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		NQueen nQueen = new NQueen(N);
		nQueen.solve(1);
		System.out.println(nQueen.getCnt());
	}

}

class NQueen {
	private int N;
	private boolean[][] board;
	private int cnt;
	
	public NQueen(int N) {
		this.N = N;
		this.board = new boolean[N+1][N+1];
		this.cnt = 0;
	}
	
	public void solve(int depth) {
		if(depth == N+1) {
			cnt++;
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(checkBoard(depth, i)) {
				board[depth][i] = true;
				solve(depth+1);
				board[depth][i] = false;
			}
		}
	}
	
	public boolean checkBoard(int row, int col) {
		if( checkCol(col) && checkDiagonal(row, col)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkCol(int col) {
		for(int i = 1; i <= N; i++) {
			if(board[i][col] == true) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkDiagonal(int row, int col) {
		int sum = row + col;
		int sub = row - col;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(board[i][j] == true) {
					if(sum == i+j || sub == i-j) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public int getCnt() {
		return cnt;
	}
}
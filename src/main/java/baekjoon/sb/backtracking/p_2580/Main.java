package baekjoon.sb.backtracking.p_2580;

import java.awt.Point;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
	}
	
}

class Sudoku {
	private int[][] sudoku;
	private Set<Point> set;
	private Set<Integer> checkSet;
	
	public Sudoku(int[][] arr) {
		this.sudoku = arr;
		set = new HashSet<>();
		checkEmpty();
	}
	
	public void solve() {
		while(set.size() != 0) {
			solveRow();
			solveCol();
			solveSquare();
		}
		
		print();
	}
	
	public void solveRow() {
		checkEmpty();
		for(Point pt : set) {
			checkSet = IntStream.range(1, 10).mapToObj(e -> (Integer) e).collect(Collectors.toSet());
			
			for(int i = 1; i < 10; i++) {
				if(checkSet.contains(sudoku[pt.x][i])) {
					checkSet.remove(sudoku[pt.x][i]);
				}
			}
			if(checkSet.size() == 1) {
				for(Integer i : checkSet) {
					sudoku[pt.x][pt.y] = i.intValue();
				}
			}
		}
	}
	
	public void solveCol() {
		checkEmpty();
		for(Point pt : set) {
			checkSet = IntStream.range(1, 10).mapToObj(e -> (Integer) e).collect(Collectors.toSet());
			
			for(int i = 1; i < 10; i++) {
				if(checkSet.contains(sudoku[i][pt.y])) {
					checkSet.remove(sudoku[i][pt.y]);
				}
			}
			if(checkSet.size() == 1) {
				for(Integer i : checkSet) {
					sudoku[pt.x][pt.y] = i.intValue();
				}
			}
		}
	}
	
	public void solveSquare() {
		checkEmpty();
		for(Point pt : set) {
			checkSet = IntStream.range(1, 10).mapToObj(e -> (Integer) e).collect(Collectors.toSet());
			int xPos = (pt.x - 1) / 3;
			int yPos = (pt.y - 1) / 3;
			
			for(int i = xPos*3+1; i < xPos*3+4; i++) {
				for(int j = yPos*3+1; j < yPos*3+4; j++) {
					if(checkSet.contains(sudoku[i][j])) {
						checkSet.remove(sudoku[i][j]);
					}
				}
			}
			
			if(checkSet.size() == 1) {
				for(Integer i : checkSet) {
					sudoku[pt.x][pt.y] = i.intValue();
				}
			}
		}
	}
	
	public void checkEmpty() {
		set.clear();
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				if(sudoku[i][j] == 0) {
					set.add(new Point(i, j));
				}
			}
		}
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
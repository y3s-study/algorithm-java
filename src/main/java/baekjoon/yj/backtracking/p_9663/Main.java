package baekjoon.yj.backtracking.p_9663;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/9663
 * N-Queen
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new NQueen(new Scanner(System.in).nextInt()).getCount());
    }
}

class NQueen {
    private int n;
    private boolean[][] board;

    NQueen(int n) {
        this.n = n;
        this.board = new boolean[n][n];
    }

    int getCount() {
        return getCount(0);
    }

    private int getCount(int row) {
        if (row == n) {
            return 1;
        }

        int sum = 0;

        for (int column = 0; column < n; column++) {
            if (isPossiblePosition(row, column)) {
                board[row][column] = true;
                sum += getCount(row + 1);
                board[row][column] = false;
            }
        }

        return sum;
    }

    private boolean isPossiblePosition(int row, int column) {
        return !doesQueenExistInColumn(column) && !doesQueenExistInLeftDiagonal(row, column) && !doesQueenExistInRightDiagonal(row, column);
    }

    private boolean doesQueenExistInColumn(int column) {
        for (int row = 0; row < n; row++) {
            if (board[row][column]) {
                return true;
            }
        }
        return false;
    }

    private boolean doesQueenExistInLeftDiagonal(int row, int column) {
        while (row >= 0 && column >= 0) {
            if (board[row][column]) {
                return true;
            }
            row--;
            column--;
        }
        return false;
    }

    private boolean doesQueenExistInRightDiagonal(int row, int column) {
        while (row >= 0 && column < n) {
            if (board[row][column]) {
                return true;
            }
            row--;
            column++;
        }
        return false;
    }
}

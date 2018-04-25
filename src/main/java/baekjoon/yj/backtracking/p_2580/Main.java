package baekjoon.yj.backtracking.p_2580;

import java.util.*;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

/**
 * https://www.acmicpc.net/problem/2580
 * 스도쿠
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        Sudoku sudoku = new Sudoku(board);
        sudoku.getResult();
    }
}

class Sudoku {
    private int[][] board;
    private Map<Integer, Set<Integer>> row;
    private Map<Integer, Set<Integer>> col;
    private Map<Integer, Set<Integer>> square;

    Sudoku(int[][] board) {
        this.board = board;
        this.row = new HashMap<>();
        this.col = new HashMap<>();
        this.square = new HashMap<>();
        initialize();
    }

    private void initialize() {
        range(0, 9).forEach(i -> {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            square.put(i, new HashSet<>());
        });

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                final int value = this.board[i][j];

                row.get(i).add(value);
                col.get(j).add(value);
                square.get(squareIndex(i, j)).add(value);
            }
        }
    }

    private static int squareIndex(int x, int y) {
        return (x / 3) * 3 + y / 3;
    }

    void getResult() {
        fillBoard(0, 0);
    }

    private void fillBoard(int x, int y) {
        if (x == 9 || y == 9) {
            String result = stream(this.board)
                    .map(row -> stream(row)
                            .mapToObj(String::valueOf)
                            .collect(joining(" ")))
                    .collect(joining("\n"));

            System.out.println(result);
            System.exit(0);
        }

        final int nextX = x + (y / 8);
        final int nextY = (y + 1) % 9;

        if (board[x][y] != 0) {
            fillBoard(nextX, nextY);
        } else {
            rangeClosed(1, 9).forEach(value -> {
                if (!row.get(x).contains(value) && !col.get(y).contains(value) && !square.get(squareIndex(x, y)).contains(value)) {
                    row.get(x).add(value);
                    col.get(y).add(value);
                    square.get(squareIndex(x, y)).add(value);

                    board[x][y] = value;
                    fillBoard(nextX, nextY);
                    board[x][y] = 0;

                    row.get(x).remove(value);
                    col.get(y).remove(value);
                    square.get(squareIndex(x, y)).remove(value);
                }
            });
        }
    }
}

package baekjoon.sj.backtracking.p_2580;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

	@Test
	public void testCase1() {
		int[][] board = new int[][]{
                {0, 3, 5, 4, 6, 9, 2, 7, 8},
                {7, 8, 2, 1, 0, 5, 6, 0, 9},
                {0, 6, 0, 2, 7, 8, 1, 3, 5},
                {3, 2, 1, 0, 4, 6, 8, 9, 7},
                {8, 0, 4, 9, 1, 3, 5, 0, 6},
                {5, 9, 6, 8, 2, 0, 4, 1, 3},
                {9, 1, 7, 6, 5, 2, 0, 8, 0},
                {6, 0, 3, 7, 0, 1, 9, 5, 2},
                {2, 5, 8, 3, 9, 4, 7, 6, 0}
        };

        String result = new Sudoku(board).getArrayString();
        System.out.println(result);
        assertThat(result).isEqualTo(
                "1 3 5 4 6 9 2 7 8 \n" +
                "7 8 2 1 3 5 6 4 9 \n" +
                "4 6 9 2 7 8 1 3 5 \n" +
                "3 2 1 5 4 6 8 9 7 \n" +
                "8 7 4 9 1 3 5 2 6 \n" +
                "5 9 6 8 2 7 4 1 3 \n" +
                "9 1 7 6 5 2 3 8 4 \n" +
                "6 4 3 7 8 1 9 5 2 \n" +
                "2 5 8 3 9 4 7 6 1 \n"
        );
	}
}

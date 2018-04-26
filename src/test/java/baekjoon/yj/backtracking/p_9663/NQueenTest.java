package baekjoon.yj.backtracking.p_9663;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(Parameterized.class)
public class NQueenTest {

    @Parameter
    public int n;

    @Parameter(1)
    public int expected;


    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {1, 1},
                {2, 0},
                {3, 0},
                {4, 2},
                {5, 10},
                {6, 4},
                {7, 40},
                {8, 92},
                {9, 352},
                {10, 724},
                {11, 2680},
                {12, 14200},
                {13, 73712},
                {14, 365596},
        };
    }

    @Test
    public void test() {
        assertThat(new NQueen(n).getCount()).isEqualTo(expected);
    }
}
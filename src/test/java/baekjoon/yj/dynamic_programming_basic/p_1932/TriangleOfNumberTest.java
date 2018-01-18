package baekjoon.yj.dynamic_programming_basic.p_1932;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangleOfNumberTest {

    @Test(timeout = 2000)
    public void maxValueTest1() {
        int[][] triangleArray = new int[][]{
                {1}
        };

        int result = new TriangleOfNumber(triangleArray).maxValue();

        assertThat(result).isEqualTo(1);
    }

    @Test(timeout = 2000)
    public void maxValueTest2() {
        int[][] triangleArray = new int[][]{
                {1},
                {2, 3},
                {4, 5, 6}
        };

        int result = new TriangleOfNumber(triangleArray).maxValue();

        assertThat(result).isEqualTo(10);
    }

    @Test(timeout = 2000)
    public void maxValueTest3() {
        int[][] triangleArray = new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        int result = new TriangleOfNumber(triangleArray).maxValue();

        assertThat(result).isEqualTo(30);
    }

    @Test(timeout = 2000)
    public void maxValueWorstCaseTest() {
        int[][] triangleArray = createWorstCaseArray();

        int result = new TriangleOfNumber(triangleArray).maxValue();

        assertThat(result).isEqualTo(125250);
    }

    /**
     * Create worst case array having 500 row.
     * @return worst case 2-dimensional array
     * <p>
     * 1
     * 1 2
     * 1 2 3
     * ...
     * ...
     * 1 2 3 4 6 7 ... 500
     */
    private int[][] createWorstCaseArray() {
        int[][] triangleArray = new int[500][];

        for (int i = 0; i < 500; i++) {
            triangleArray[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                triangleArray[i][j] = j + 1;
            }
        }

        return triangleArray;
    }
}
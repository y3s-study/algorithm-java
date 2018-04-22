package baekjoon.yj.dynamic_programming.p_2098;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TravelingSalesmanTest {

    @Test
    public void addCostRow() {
        int[][] costs = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 10, 15, 20},
                {0, 5, 0, 9, 10},
                {0, 6, 13, 0, 12},
                {0, 8, 8, 9, 0},
        };
        TravelingSalesman ts = new TravelingSalesman(4, costs);
        assertThat(ts.getMinimumCost()).isEqualTo(35);
    }
}
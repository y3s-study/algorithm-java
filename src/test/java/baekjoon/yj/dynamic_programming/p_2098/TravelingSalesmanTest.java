package baekjoon.yj.dynamic_programming.p_2098;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TravelingSalesmanTest {

    @Test
    public void create() {
        new TravelingSalesman(4);
    }

    @Test
    public void addCostRow() {
        TravelingSalesman ts = new TravelingSalesman(4);
        ts.addCostRow(0, "0 10 15 20");
        ts.addCostRow(1, "5  0  9 10");
        ts.addCostRow(2, "6 13  0 12");
        ts.addCostRow(3, "8  8  9  0");

        assertThat(ts.getMinimumCost()).isEqualTo(35);
    }
}
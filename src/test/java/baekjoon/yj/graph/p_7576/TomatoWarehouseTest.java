package baekjoon.yj.graph.p_7576;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TomatoWarehouseTest {

    @Test
    public void testCase1() {
        int data[][] = new int[][]{
                {1, 0},
                {0, 0}
        };

        int minimumDate = TomatoWarehouse.of(2, 2, data).getMinimumRipeDate();

        assertThat(minimumDate).isEqualTo(2);
    }

    @Test
    public void testCase2() {
        int data[][] = new int[][]{
                {1, 0},
                {0, -1}
        };

        int minimumDate = TomatoWarehouse.of(2, 2, data).getMinimumRipeDate();

        assertThat(minimumDate).isEqualTo(1);
    }

    @Test
    public void testCase3() {
        int data[][] = new int[][]{
                {1, -1},
                {-1, 0}
        };

        int minimumDate = TomatoWarehouse.of(2, 2, data).getMinimumRipeDate();

        assertThat(minimumDate).isEqualTo(-1);
    }

    @Test
    public void testCase4() {
        int data[][] = new int[][]{
                {-1, -1},
                {-1, -1}
        };

        int minimumDate = TomatoWarehouse.of(2, 2, data).getMinimumRipeDate();

        assertThat(minimumDate).isEqualTo(0);
    }

    @Test
    public void testCase5() {
        int data[][] = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1}
        };

        int minimumDate = TomatoWarehouse.of(6, 4, data).getMinimumRipeDate();

        assertThat(minimumDate).isEqualTo(8);
    }

    @Test
    public void testCase6() {
        int data[][] = new int[][]{
                {0, -1, 0, 0, 0, 0},
                {-1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1}
        };

        int minimumDate = TomatoWarehouse.of(6, 4, data).getMinimumRipeDate();

        assertThat(minimumDate).isEqualTo(-1);
    }

    @Test
    public void testCase7() {
        int data[][] = new int[][]{
                {1, -1, 0, 0, 0, 0},
                {0, -1, 0, 0, 0, 0},
                {0, 0, 0, 0, -1, 0},
                {0, 0, 0, 0, -1, 1}
        };

        int minimumDate = TomatoWarehouse.of(6, 4, data).getMinimumRipeDate();

        assertThat(minimumDate).isEqualTo(6);
    }

    @Test
    public void testCase8() {
        int data[][] = new int[][]{
                {-1, 1, 0, 0, 0},
                {0, -1, -1, -1, 0},
                {0, -1, -1, -1, 0},
                {0, -1, -1, -1, 0},
                {0, 0, 0, 0, 0}
        };

        int minimumDate = TomatoWarehouse.of(5, 5, data).getMinimumRipeDate();

        assertThat(minimumDate).isEqualTo(14);
    }
}
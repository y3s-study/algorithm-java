package baekjoon.yj.dynamic_programming_basic.p_1005;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ACMCraftTest {

    @Test(timeout = 2000)
    public void test() {
        int[] buildTimeMap = new int[]{0, 10, 1, 100, 10};

        boolean[][] buildOrderGraph = createGraphWithSize(4);
        buildOrderGraph[1][2] = true;
        buildOrderGraph[1][3] = true;
        buildOrderGraph[2][4] = true;
        buildOrderGraph[3][4] = true;

        int minimumBuildingTime = getMinimumBuildingTime(buildTimeMap, buildOrderGraph, 4);

        assertThat(minimumBuildingTime).isEqualTo(120);
    }

    @Test(timeout = 2000)
    public void test2() {
        int[] buildTimeMap = new int[]{0, 10, 20, 1, 5, 8, 7, 1, 43};

        boolean[][] buildOrderGraph = createGraphWithSize(8);
        buildOrderGraph[1][2] = true;
        buildOrderGraph[1][3] = true;
        buildOrderGraph[2][4] = true;
        buildOrderGraph[2][5] = true;
        buildOrderGraph[3][6] = true;
        buildOrderGraph[5][7] = true;
        buildOrderGraph[6][7] = true;
        buildOrderGraph[7][8] = true;

        int minimumBuildingTime = getMinimumBuildingTime(buildTimeMap, buildOrderGraph, 7);

        assertThat(minimumBuildingTime).isEqualTo(39);
    }

    @Test(timeout = 2000)
    public void test3() {
        int[] buildTimeMap = new int[]{0, 10, 1, 1, 100, 10, 10, 100, 1, 1, 1};

        boolean[][] buildOrderGraph = createGraphWithSize(10);
        buildOrderGraph[1][2] = true;
        buildOrderGraph[2][3] = true;
        buildOrderGraph[3][6] = true;
        buildOrderGraph[4][3] = true;
        buildOrderGraph[4][7] = true;
        buildOrderGraph[4][9] = true;
        buildOrderGraph[5][4] = true;
        buildOrderGraph[6][9] = true;
        buildOrderGraph[7][8] = true;
        buildOrderGraph[8][9] = true;
        buildOrderGraph[10][7] = true;

        int minimumBuildingTime = getMinimumBuildingTime(buildTimeMap, buildOrderGraph, 9);

        assertThat(minimumBuildingTime).isEqualTo(212);
    }

    private boolean[][] createGraphWithSize(int size) {
        return new boolean[size + 1][size + 1];
    }

    private int getMinimumBuildingTime(int[] buildTimeMap, boolean[][] buildOrderGraph, int buildingNumber) {
        ACMCraft acmCraft = new ACMCraft(buildTimeMap, buildOrderGraph);
        return acmCraft.getBuildTime(buildingNumber);
    }
}
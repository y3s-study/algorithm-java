package baekjoon.yj.dynamic_programming_basic.p_1005;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1005
 * ACM Craft
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();

        while (testCount-- > 0) {
            int buildingCount = scanner.nextInt();
            int buildOrderRuleCount = scanner.nextInt();

            // build time for each building
            int[] buildTimeMap = new int[buildingCount + 1];
            for (int i = 1; i <= buildingCount; i++) {
                int buildTime = scanner.nextInt();
                buildTimeMap[i] = buildTime;
            }

            // build order graph
            boolean[][] buildOrderGraph = new boolean[buildingCount + 1][buildingCount + 1];
            while (buildOrderRuleCount-- > 0) {
                int buildingNumber1 = scanner.nextInt();
                int buildingNumber2 = scanner.nextInt();
                buildOrderGraph[buildingNumber1][buildingNumber2] = true;
            }

            int targetBuildingNumber = scanner.nextInt();
            int buildTime = new ACMCraft(buildTimeMap, buildOrderGraph).getBuildTime(targetBuildingNumber);

            System.out.println(buildTime);
        }
    }
}

class ACMCraft {
    private int buildTimeMap[];
    private boolean[][] buildOrderGraph;
    private Map<Integer, Integer> cache;

    ACMCraft(int[] buildTimeMap, boolean[][] buildOrderGraph) {
        this.buildTimeMap = buildTimeMap;
        this.buildOrderGraph = buildOrderGraph;
        this.cache = new HashMap<>();
    }

    public int getBuildTime(int buildingNumber) {
        if (buildingNumber < 1) {
            return 0;
        }

        if (cache.containsKey(buildingNumber)) {
            return cache.get(buildingNumber);
        }

        int prevMaxBuildTime = 0;

        for (int i = 1; i < buildOrderGraph.length; i++) {
            if (buildOrderGraph[i][buildingNumber]) {
                prevMaxBuildTime = Integer.max(prevMaxBuildTime, getBuildTime(i));
            }
        }

        prevMaxBuildTime += buildTimeMap[buildingNumber];

        cache.put(buildingNumber, prevMaxBuildTime);
        return prevMaxBuildTime;
    }
}

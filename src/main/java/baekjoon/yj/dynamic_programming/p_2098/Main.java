package baekjoon.yj.dynamic_programming.p_2098;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2098
 * 외판원 순회
 */
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int cityCount = Integer.parseInt(scanner.nextLine());

        final TravelingSalesman ts = new TravelingSalesman(cityCount);

        for (int i = 0; i < cityCount; i++) {
            ts.addCostRow(i, scanner.nextLine());
        }

        System.out.println(ts.getMinimumCost());
    }
}

class TravelingSalesman {
    private static final int START_CITY = 0;

    private int cityCount;
    private int[][] matrix;
    private boolean[] visited;

    TravelingSalesman(int cityCount) {
        this.cityCount = cityCount;
        this.matrix = new int[cityCount][cityCount];
        this.visited = new boolean[cityCount];
    }

    void addCostRow(int rowIndex, String costRow) {
        matrix[rowIndex] = Arrays.stream(costRow.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    int getMinimumCost() {
        return getMinimumCost(START_CITY, 1);
    }

    private int getMinimumCost(int currentCity, int count) {
        setVisit(currentCity);

        if (count == cityCount) {
            unsetVisit(currentCity);
            return matrix[currentCity][START_CITY];
        }

        int minimumCost = Integer.MAX_VALUE;

        for (int nextCity = 0; nextCity < cityCount; nextCity++) {
            if (isNotVisited(nextCity)) {
                int nextCost = matrix[currentCity][nextCity] + getMinimumCost(nextCity, count + 1);
                minimumCost = Integer.min(minimumCost, nextCost);
                unsetVisit(nextCity);
            }
        }

        return minimumCost;
    }

    private void setVisit(int currentCity) {
        visited[currentCity] = true;
    }

    private void unsetVisit(int currentCity) {
        visited[currentCity] = false;
    }

    private boolean isNotVisited(int city) {
        return !visited[city];
    }
}
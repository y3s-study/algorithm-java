package baekjoon.yj.dynamic_programming.p_2098;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.*;

/**
 * https://www.acmicpc.net/problem/2098
 * 외판원 순회
 */
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int cityCount = scanner.nextInt();

        int[][] costs = new int[cityCount + 1][cityCount + 1];
        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                costs[i][j] = scanner.nextInt();
            }
        }

        final TravelingSalesman ts = new TravelingSalesman(cityCount, costs);
        System.out.println(ts.getMinimumCost());
    }
}

class TravelingSalesman {
    private static final int START_CITY = 1;

    private int cityCount;
    private int[][] costs;
    private int[][] cache;

    TravelingSalesman(int cityCount, int[][] costs) {
        this.cityCount = cityCount;
        this.costs = costs;
        this.cache = new int[cityCount + 1][1 << cityCount];
        for (int i = 1; i <= cityCount; i++) {
            Arrays.fill(cache[i], -1);
        }
    }

    int getMinimumCost() {
        return getMinimumCost(START_CITY, 0b1);
    }

    private int getMinimumCost(int currentCity, int visitationMask) {
        if (visitedAllCities(visitationMask)) {
            return costs[currentCity][START_CITY];
        }

        if (cache[currentCity][visitationMask] >= 0) {
            return cache[currentCity][visitationMask];
        }

        // TODO : why ??
        int minimumCost = 1_000_000_000;

        for (int nextCity = 1; nextCity <= cityCount; nextCity++) {
            if (notVisit(visitationMask, nextCity) && hasPath(currentCity, nextCity)) {
                int nextVisitationMark = getNextVisitationMark(visitationMask, nextCity);
                int nextCost = costs[currentCity][nextCity] + getMinimumCost(nextCity, nextVisitationMark);
                minimumCost = min(minimumCost, nextCost);
            }
        }

        return cache[currentCity][visitationMask] = minimumCost;
    }

    private boolean hasPath(int currentCity, int nextCity) {
        return costs[currentCity][nextCity] != 0;
    }

    private int getNextVisitationMark(int visitationMask, int nextCity) {
        return visitationMask + (1 << (nextCity - 1));
    }

    private boolean notVisit(int visitationMask, int nextCity) {
        return (visitationMask & (1 << (nextCity - 1))) == 0;
    }

    private boolean visitedAllCities(int visitationMark) {
        return visitationMark == (1 << cityCount) - 1;
    }

}
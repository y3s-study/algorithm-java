package baekjoon.yj.dac.p_2447;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2447
 * 별찍기 - 10
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Star().print(new Scanner(System.in).nextInt()));
    }
}

class Star {
    public String print(int n) {
        char[][] starsMap = initializeMap(n);
        fillStars(starsMap, n);
        return mapToString(starsMap);
    }

    private char[][] initializeMap(int n) {
        char[][] starsMap = new char[n][n];

        for (char[] row : starsMap) {
            Arrays.fill(row, ' ');
        }

        return starsMap;
    }

    private void fillStars(char[][] map, int n) {
        fillStars(map, n, 0, 0);
    }

    private void fillStars(char[][] map, int n, int baseX, int baseY) {
        if (n == 1) {
            map[baseX][baseY] = '*';
            return;
        }

        int weight = n / 3;

        for (int offsetY = 0; offsetY < 3; offsetY++) {
            for (int offsetX = 0; offsetX < 3; offsetX++) {
                if (offsetY == 1 && offsetX == 1) {
                    continue;
                }

                // 실제 좌표를 구한다.
                int positionX = (offsetX * weight) + baseX;
                int positionY = (offsetY * weight) + baseY;

                // 실제 좌표에 별을 그린다.
                fillStars(map, weight, positionX, positionY);
            }
        }
    }

    private String mapToString(char[][] starsMap) {
        StringBuilder builder = new StringBuilder();

        for (char[] row : starsMap) {
            builder.append(row).append('\n');
        }

        return builder.toString();
    }
}

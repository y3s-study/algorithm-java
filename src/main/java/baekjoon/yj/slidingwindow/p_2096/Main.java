package baekjoon.yj.slidingwindow.p_2096;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/2096
 * 내려가기
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();

        int[][] maxMap = new int[N][3];
        int[][] minMap = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                maxMap[i][j] = minMap[i][j] = scanner.nextInt();
            }
        }

        GetDown getDown = new GetDown(maxMap, minMap);
        System.out.println(getDown.getMaxScore() + " " + getDown.getMinScore());
    }
}

@SuppressWarnings("all")
class GetDown {
    private int[][] maxMap;
    private int[][] minMap;

    GetDown(int[][] maxMap, int[][] minMap) {
        this.maxMap = maxMap;
        this.minMap = minMap;
        updateScore();
    }

    private void updateScore() {
        for (int i = 1; i < maxMap.length; i++) {
            for (int j = 0; j < 3; j++) {
                List<Integer> maxList = new ArrayList<>();
                List<Integer> minList = new ArrayList<>();

                maxList.add(maxMap[i-1][1]);
                minList.add(minMap[i-1][1]);

                if (j < 2) {
                    maxList.add(maxMap[i-1][0]);
                    minList.add(minMap[i-1][0]);
                }

                if (j > 0) {
                    maxList.add(maxMap[i-1][2]);
                    minList.add(minMap[i-1][2]);
                }

                maxMap[i][j] += maxList.stream().max(Comparator.naturalOrder()).get();
                minMap[i][j] += minList.stream().min(Comparator.naturalOrder()).get();
            }
        }
    }

    public int getMaxScore() {
        return Arrays.stream(maxMap[maxMap.length - 1]).max().getAsInt();
    }

    public int getMinScore() {
        return Arrays.stream(minMap[minMap.length - 1]).min().getAsInt();
    }
}
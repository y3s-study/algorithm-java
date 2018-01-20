package baekjoon.yj.dynamic_programming_basic.p_9251.v1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        LCSFinder lcsFinder = new LCSFinder(str1, str2);
        int length = lcsFinder.getLCSLength();

        System.out.println(length);
    }
}

class LCSFinder {
    private String str1;
    private String str2;
    private int[][] cache;

    LCSFinder(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        this.cache = new int[str1.length()][str2.length()];

        // initialize cache value to -1
        for (int[] row : this.cache) {
            Arrays.fill(row, -1);
        }
    }

    public int getLCSLength() {
        return getMaxLength(0, 0);
    }

    private int getMaxLength(int i, int j) {
        if (str1.length() == i || str2.length() == j) {
            return 0;
        }

        if (cache[i][j] > -1) {
            return cache[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return cache[i][j] = getMaxLength(i + 1, j + 1) + 1;
        }

        int str1BasedMaxLength = getMaxLength(i, j + 1);
        int str2BasedMaxLength = getMaxLength(i + 1, j);
        return cache[i][j] = Integer.max(str1BasedMaxLength, str2BasedMaxLength);
    }
}

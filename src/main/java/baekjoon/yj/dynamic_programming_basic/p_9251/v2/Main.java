package baekjoon.yj.dynamic_programming_basic.p_9251.v2;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/9251
 * LCS(Longest Common Subsequence, 최장 공통 부분 수열)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        final LCSFinder lcsFinder = new LCSFinder();
        final int length = lcsFinder.getLengthOfLCS(str1, str2);

        System.out.println(length);
    }
}

class LCSFinder {
    public int getLengthOfLCS(String str1, String str2) {
        str1 = " " + str1;
        str2 = " " + str2;

        int[][] cache = new int[str1.length()][str2.length()];

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                } else {
                    cache[i][j] = Integer.max(cache[i - 1][j], cache[i][j - 1]);
                }
            }
        }

        return cache[str1.length() - 1][str2.length() - 1];
    }
}

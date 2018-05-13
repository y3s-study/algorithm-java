package baekjoon.yj.segmenttree.p_10986;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10986
 * 나머지 합
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long[] S = new long[M];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += scanner.nextInt();
            S[(int) (sum % M)]++;
        }

        long result = S[0];

        for (int i = 0; i < M; i++) {
            result += ((S[i] * (S[i] - 1)) / 2);
        }

        System.out.println(result);
    }
}

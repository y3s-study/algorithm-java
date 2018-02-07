package baekjoon.yj.dac.p_1074;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1074
 * Z
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(new Z().getOrder(n, r, c));
    }
}

class Z {
    public int getOrder(int n, int r, int c) {
        int size = (int) Math.pow(2, n);
        return getOrder(size, r, c, 0, 0);
    }

    private int getOrder(int size, int r, int c, int x, int y) {
        if (x == c && y == r) {
            return 0;
        }

        int half = size / 2;
        int xHalf = x + half;
        int yHalf = y + half;
        int quartileArea = half * half;

        if (c < xHalf && r < yHalf) {
            return getOrder(half, r, c, x, y);
        }

        if (c >= xHalf && r < yHalf) {
            return quartileArea + getOrder(half, r, c, xHalf, y);
        }

        if (c < xHalf && r >= yHalf) {
            return (quartileArea * 2) + getOrder(half, r, c, x, yHalf);
        }

        return (quartileArea * 3) + getOrder(half, r, c, xHalf, yHalf);
    }
}

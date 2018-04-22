package baekjoon.sk.binarytree.p_3038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(in.readLine());

            dp(N, 1, N);
            
            System.out.println(sb.toString());
        }
    }

    public static void dp(int level, int cur, int n) {
        if (level == 1) {
            set(cur);
        } else {
            int start = (1 << n) - (1 << (n - level + 1));
            int lmax = (1 << (n - level));
            set(lmax - cur + 1 + start);
            dp(level - 1, cur, n);
            dp(level - 1, cur + (1 << (n - level)), n);
        }
    }

    public static void set(int cur) {
        sb.append(cur).append(' ');
    }
}

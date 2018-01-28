package baekjoon.yj.dac.p_1992;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        String[][] source = new String[size][];

        for (int i = 0; i < size; i++) {
            source[i] = scanner.next().split("");
        }

        System.out.println(new QuadTreeCompressor().compress(source));
    }
}

class QuadTreeCompressor {
    public String compress(String[][] source) {
        return compress(source, source.length, 0, 0);
    }

    private String compress(String[][] source, int n, int baseX, int baseY) {
        if (n == 1) {
            return source[baseX][baseY];
        }

        int weight = n / 2;

        // divide to four parts
        String subResult1 = compress(source, weight, baseX, baseY);
        String subResult2 = compress(source, weight, baseX, baseY + weight);
        String subResult3 = compress(source, weight, baseX + weight, baseY);
        String subResult4 = compress(source, weight, baseX + weight, baseY + weight);

        // conquer
        String result = subResult1 + subResult2 + subResult3 + subResult4;
        return result.equals("0000") ? "0" : result.equals("1111") ? "1" : "(" + result + ")";
    }
}

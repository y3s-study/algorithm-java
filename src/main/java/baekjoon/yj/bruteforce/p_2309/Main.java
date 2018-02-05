package baekjoon.yj.bruteforce.p_2309;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

/**
 * https://www.acmicpc.net/problem/2309
 * 일곱 난쟁이
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] source = IntStream.generate(scanner::nextInt).limit(9).toArray();
        stream(new SevenDwarfs().getSevenDwarfs(source)).forEach(System.out::println);
    }
}

class SevenDwarfs {
    public int[] getSevenDwarfs(int[] source) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int[] dwarfs = excludeTwoDwarfs(source, asList(source[i], source[j]));

                if (stream(dwarfs).sum() == 100) {
                    return stream(dwarfs).sorted().toArray();
                }
            }
        }

        throw new RuntimeException();
    }

    private int[] excludeTwoDwarfs(int[] source, List<Integer> excludes) {
        return stream(source).filter(height -> !excludes.contains(height)).toArray();
    }
}

package baekjoon.yj.dynamic_programming_basic.p_9461.v2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        PadovanSequence padovan = new PadovanSequence();
        Scanner scanner = new Scanner(System.in);

        int testCount = scanner.nextInt();

        IntStream.generate(scanner::nextInt).limit(testCount).mapToLong(padovan::value).forEach(System.out::println);
    }
}

class PadovanSequence {
    private Map<Integer, Long> cache = new HashMap<>();

    public long value(int order) {
        return cache.computeIfAbsent(order, key -> key < 4 ? 1L : value(key - 3) + value(key - 2));
    }
}

package baekjoon.yj.segmenttree.p_10986;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * https://www.acmicpc.net/problem/10986
 * 나머지 합
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] data = IntStream.generate(scanner::nextInt).limit(N).toArray();

        PrefixSumCalculator prefixSumCalculator = new PrefixSumCalculator(M, data);
        System.out.println(prefixSumCalculator.getRangeCount());
    }
}

class PrefixSumCalculator {
    private final int M;
    private final int[] data;

    PrefixSumCalculator(int m, int[] data) {
        this.M = m;
        this.data = data;
    }

    long getRangeCount() {
        long[] S = prefixSum();

        long[] R = stream(S).map(s -> s % M).toArray();

        Map<Long, Long> remainCount = stream(R).boxed().collect(groupingBy(r -> r, counting()));

        long result = remainCount.getOrDefault(0L, 0L);

        result += remainCount.values().stream()
                .map(count -> (count * (count - 1)) / 2)
                .mapToLong(Long::valueOf)
                .sum();

        return result;
    }

    private long[] prefixSum() {
        long[] S = new long[data.length];
        long sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            S[i] = sum;
        }

        return S;
    }
}

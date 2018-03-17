package baekjoon.yj.slidingwindow.p_2096;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.acmicpc.net/problem/2096
 * 내려가기
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();

        int[][] map = IntStream.range(0, N)
                .mapToObj(i -> IntStream.generate(scanner::nextInt).limit(3).toArray())
                .toArray(int[][]::new);

        GetDown getDown = new GetDown(map);
        int minScore = getDown.getScore(Comparator.naturalOrder());
        int maxScore = getDown.getScore(Comparator.reverseOrder());
        System.out.println(maxScore + " " + minScore);
    }
}

class GetDown {
    private int[][] map;
    private int[][] cache;

    GetDown(int[][] map) {
        this.map = map;
        this.cache = new int[map.length][map.length];
        initCache();
    }

    public int getScore(Comparator<Integer> comparator) {
        initCache();

        return Stream.of(
                getScore(0, 0, comparator),
                getScore(0, 1, comparator),
                getScore(0, 2, comparator)
        ).collect(Collectors.toCollection(() -> new PriorityQueue<>(comparator))).poll();
    }

    private int getScore(int i, int j, Comparator<Integer> comparator) {
        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (i == map.length - 1) {
            return cache[i][j] = map[i][j];
        }

        Queue<Integer> pq = new PriorityQueue<>(comparator);

        pq.offer(getScore(i + 1, 1, comparator));
        if (j < 2) pq.offer(getScore(i + 1, 0, comparator));
        if (j > 0) pq.offer(getScore(i + 1, 2, comparator));

        return cache[i][j] = pq.poll() + map[i][j];
    }

    private void initCache() {
        Arrays.stream(cache).forEach(row -> Arrays.fill(row, -1));
    }
}
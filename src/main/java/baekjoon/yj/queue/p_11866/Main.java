package baekjoon.yj.queue.p_11866;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/11866
 * 조세퍼스 문제 0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String josephusPermutation = josephusPermutation(scanner.nextInt(), scanner.nextInt());
        System.out.println(josephusPermutation);
    }

    static String josephusPermutation(int n, int m) {
        Queue<String> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(String.valueOf(i));
        }

        List<String> josephusPermutation = new ArrayList<>();
        int counter = 0;

        while(!queue.isEmpty()) {
            String element = queue.poll();

            if (++counter % m != 0) {
                queue.offer(element);
            } else {
                josephusPermutation.add(element);
            }
        }

        return String.format("<%s>", String.join(", ", josephusPermutation));
    }
}

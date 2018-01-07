package baekjoon.yj.queue.p_1158;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

/**
 * https://www.acmicpc.net/problem/1158
 * 조세퍼스 문제
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String josephusPermutation = josephusPermutation(scanner.nextInt(), scanner.nextInt());
        System.out.println(josephusPermutation);
    }

    static String josephusPermutation(int n, int m) {
        Queue<Integer> queue = IntStream.rangeClosed(1, n).boxed().collect(toCollection(LinkedList::new));
        Queue<Integer> result = new LinkedList<>();

        for (int i = 1; !queue.isEmpty(); i++) {
            if (i % m == 0) {
                result.offer(queue.poll());
            } else {
                queue.offer(queue.poll());
            }
        }

        return result.stream().map(String::valueOf).collect(joining(", ", "<", ">"));
    }
}

package baekjoon.yj.deque.p_1021;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * https://www.acmicpc.net/problem/1021
 * 회전하는 큐
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queueSize = scanner.nextInt();
        int pickCount = scanner.nextInt();

        Deque<Integer> deque = IntStream.rangeClosed(1, queueSize).boxed().collect(Collectors.toCollection(LinkedList::new));
        List<Integer> pickList = IntStream.generate(scanner::nextInt).limit(pickCount).boxed().collect(toList());

        System.out.println(getAnswer(deque, pickList));
    }

    static int getAnswer(Deque<Integer> deque, List<Integer> pickList) {
        return pickList.stream().mapToInt(pick -> getMinimumOperationCount(deque, pick)).sum();
    }

    private static int getMinimumOperationCount(Deque<Integer> deque, Integer pick) {
        int rightRotationCount = 0;

        while (!deque.peekFirst().equals(pick)) {
            deque.offerLast(deque.pollFirst());
            rightRotationCount++;
        }

        int leftRotationCount = deque.size() - rightRotationCount;

        deque.pollFirst();

        return Integer.min(leftRotationCount, rightRotationCount);
    }
}

package baekjoon.yj.slidingwindow.p_11003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11003
 * 최소값 찾기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int numbersCount = Integer.parseInt(tokenizer.nextToken());
        int windowSize = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        int[] numbers = new int[numbersCount];

        for (int i = 0; i < numbersCount; i++) {
            numbers[i] = Integer.valueOf(tokenizer.nextToken());
        }

        String result = new FindMin().find(numbers, windowSize);
        System.out.println(result);
    }
}

class FindMin {
    public String find(int[] numbers, int windowSize) {
        Deque<Pair> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst().index < i - windowSize + 1) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && dq.peekLast().value >= numbers[i]) {
                dq.pollLast();
            }

            dq.offerLast(new Pair(i, numbers[i]));
            sb.append(dq.peekFirst().value).append(" ");
        }

        return sb.toString();
    }
}

class Pair {
    int index;
    int value;

    Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
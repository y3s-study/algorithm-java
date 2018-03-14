package baekjoon.yj.slidingwindow.p_11003;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/11003
 * 최소값 찾기
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersCount = scanner.nextInt();
        int windowSize = scanner.nextInt();

        List<Integer> numbers = IntStream.generate(scanner::nextInt).limit(numbersCount).boxed().collect(Collectors.toList());

        FindMin findMin = new FindMin();
        List<Integer> integers = findMin.find(numbers, windowSize);
        for (Integer integer : integers) {
            System.out.printf("%d ", integer);
        }
    }
}

class FindMin {
    public List<Integer> find(List<Integer> numbers, int windowSize) {
        Queue<Integer> slidingWindow = new LinkedList<>();
        Queue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            slidingWindow.offer(number);
            pq.offer(number);

            result.add(pq.peek());

            if (slidingWindow.size() == windowSize) {
                if (slidingWindow.peek().equals(pq.peek())) {
                    slidingWindow.poll();
                    pq.poll();
                } else {
                    slidingWindow.poll();
                }
            }
        }

        return result;
    }
}

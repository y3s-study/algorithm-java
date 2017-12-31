package beakjoon.yj.p_1874;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/1874
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();
        int[] inputs = IntStream.generate(scanner::nextInt).limit(numberOfInputs).toArray();
        System.out.println(getOperations(inputs));
    }

    static String getOperations(int[] inputs) {
        final Stack<Integer> stack = new Stack<>();
        final List<String> results = new ArrayList<>();

        int max = 0;
        for (Integer input : inputs) {
            if (max < input) {
                for (int i = max + 1; i <= input; i++) {
                    stack.push(i);
                    results.add("+");
                }
                max = input;
            }

            if (!stack.peek().equals(input)) {
                return "NO";
            }

            stack.pop();
            results.add("-");
        }

        return String.join("\n", results);
    }
}

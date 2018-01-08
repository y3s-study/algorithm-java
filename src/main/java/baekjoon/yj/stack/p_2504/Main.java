package baekjoon.yj.stack.p_2504;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/2504
 */
public class Main {
    private static final List<String> ITEMS_TO_PUSH = Arrays.asList("(", "[");

    public static void main(String[] args) {
        System.out.println(valueOfParentheses(new Scanner(System.in).nextLine()));
    }

    static int valueOfParentheses(String string) {
        try {
            return calculateValue(string);
        } catch (EmptyStackException | NumberFormatException e) {
            return 0;
        }
    }

    private static int calculateValue(String string) {
        Stack<String> stack = new Stack<>();

        for (String item : string.split("")) {
            if (ITEMS_TO_PUSH.contains(item)) {
                stack.push(item);
                continue;
            }

            if (stack.peek().equals(oppositePairOf(item))) {
                return 0;
            }

            pushCalculatedValue(stack, item);
        }

        return sumOfAll(stack);
    }

    private static void pushCalculatedValue(Stack<String> stack, String item) {
        if (stack.peek().equals(pairOf(item))) {
            stack.push(valueOf(stack.pop()));
        } else {
            stack.push(String.valueOf(sumOfStackFrame(stack, item) * intValueOf(stack.pop())));
        }
    }

    private static int sumOfStackFrame(Stack<String> stack, String item) {
        int sum = 0;

        while (!stack.peek().equals(pairOf(item))) {
            sum += Integer.parseInt(stack.pop());
        }

        return sum;
    }

    private static int sumOfAll(Stack<String> stack) {
        int sum = 0;

        while (!stack.isEmpty()) {
            sum += Integer.parseInt(stack.pop());
        }

        return sum;
    }

    private static String valueOf(String s) {
        return s.equals("(") ? "2" : "3";
    }

    private static int intValueOf(String s) {
        return Integer.parseInt(valueOf(s));
    }

    private static String pairOf(String s) {
        return s.equals(")") ? "(" : "[";
    }

    private static String oppositePairOf(String s) {
        return s.equals(")") ? "[" : "(";
    }
}

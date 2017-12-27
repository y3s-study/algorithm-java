package beakjoon.yj.p_9012;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9012
 * 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();
        scanner.nextLine();

        while (numberOfInputs-- > 0) {
            String result = isVPS(scanner.nextLine());
            System.out.println(result);
        }
    }

    private static String isVPS(String input) {
        try {
            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }

            return stack.size() == 0 ? "YES" : "NO";
        } catch (EmptyStackException e) {
            return "NO";
        }
    }
}

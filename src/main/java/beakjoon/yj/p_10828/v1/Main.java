package beakjoon.yj.p_10828.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10828
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 */
public class Main {
    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numberOfCommand = scanner.nextInt();
        scanner.nextLine();

        while (numberOfCommand-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            String arg = tokens.length > 1 ? tokens[1] : null;

            printResult(elements, command, arg);
        }
    }

    private static void printResult(List<String> elements, String command, String arg) {
        switch (command) {
            case "push":
                elements.add(arg);
                break;
            case "pop":
                System.out.println(elements.isEmpty() ? -1 : elements.remove(elements.size() - 1));
                break;
            case "size":
                System.out.println(elements.size());
                break;
            case "empty":
                System.out.println(elements.isEmpty() ? 1 : 0);
                break;
            case "top":
                System.out.println(elements.isEmpty() ? -1 : elements.get(elements.size() - 1));
                break;
        }
    }
}

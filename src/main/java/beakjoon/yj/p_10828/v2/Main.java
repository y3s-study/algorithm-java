package beakjoon.yj.p_10828.v2;

import java.util.*;
import java.util.function.Consumer;

/**
 * https://www.acmicpc.net/problem/10828
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 */
public class Main {
    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();

        Map<String, Consumer<String>> commands = new HashMap<>();
        commands.put("push", e -> elements.add(e));
        commands.put("pop", arg -> System.out.println(elements.isEmpty() ? -1 : elements.remove(elements.size() - 1)));
        commands.put("size", arg -> System.out.println(elements.size()));
        commands.put("empty", arg -> System.out.println(elements.isEmpty() ? 1 : 0));
        commands.put("top", arg -> System.out.println(elements.isEmpty() ? -1 : elements.get(elements.size() - 1)));

        Scanner scanner = new Scanner(System.in);
        int numberOfCommand = scanner.nextInt();
        scanner.nextLine();

        while (numberOfCommand-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            String arg = tokens.length > 1 ? tokens[1] : null;
            commands.get(command).accept(arg);
        }
    }
}

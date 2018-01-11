package baekjoon.sb.deque.p_10866;

import java.util.*;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		List<String> elements = new ArrayList<>();

		Map<String, Consumer<String>> commands = new HashMap<>();
		commands.put("push_back", e -> elements.add(e));
		commands.put("push_front", e -> elements.add(0, e));
		commands.put("pop_back", arg -> System.out.println(elements.isEmpty() ? -1 : elements.remove(elements.size() - 1)));
		commands.put("pop_front", arg -> System.out.println(elements.isEmpty() ? -1 : elements.remove(0)));
		commands.put("size", arg -> System.out.println(elements.size()));
		commands.put("empty", arg -> System.out.println(elements.isEmpty() ? 1 : 0));
		commands.put("back", arg -> System.out.println(elements.isEmpty() ? -1 : elements.get(elements.size() - 1)));
		commands.put("front", arg -> System.out.println(elements.isEmpty() ? -1 : elements.get(0)));

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



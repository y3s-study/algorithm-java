package baekjoon.yj.deque.p_5430;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

/**
 * https://www.acmicpc.net/problem/5430
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = Integer.parseInt(scanner.nextLine());

        while (testCount-- > 0) {
            String functions = scanner.nextLine();
            scanner.nextLine();
            String elements = scanner.nextLine();

            String result = AC.of(functions, elements).compute();
            System.out.println(result);
        }
    }
}

class AC {
    private String[] functions;
    private Deque<String> deque;
    private Direction direction;

    static AC of(String functionsStr, String elements) {
        final String[] functions = functionsStr.split("");
        final Deque<String> deque = Arrays.stream(elements.replaceAll("[\\[\\]]", "").split(","))
                .filter(s -> !s.equals(""))
                .collect(toCollection(LinkedList::new));

        return new AC(functions, deque, Direction.FRONT);
    }

    private AC(String[] functions, Deque<String> deque, Direction direction) {
        this.functions = functions;
        this.deque = deque;
        this.direction = direction;
    }

    String compute() {
        try {
            Arrays.stream(functions).forEach(this::takeActionByFunction);

            final List<String> remains = direction.getRemains(deque);
            return String.format("[%s]", String.join(",", remains));
        } catch (NoSuchElementException e) {
            return "error";
        }
    }

    private void takeActionByFunction(String function) {
        if (function.equals("R")) {
            direction = direction.flip();
        }

        if (function.equals("D")) {
            direction.removeOneElementFromDeque(deque);
        }
    }
}

/**
 * Deque의 탐색 방향을 나타내는 Enum
 * - FRONT : Deque의 앞 부분 부터 연산
 * - BACK : Deque의 뒷 부분 부터 연산
 */
enum Direction {
    FRONT {
        @Override
        Direction flip() {
            return BACK;
        }

        @Override
        void removeOneElementFromDeque(Deque<String> deque) {
            deque.removeFirst();
        }

        @Override
        List<String> getRemains(Deque<String> deque) {
            List<String> remains = new ArrayList<>();
            while (!deque.isEmpty()) {
                remains.add(deque.pollFirst());
            }
            return remains;
        }
    },
    BACK {
        @Override
        Direction flip() {
            return FRONT;
        }

        @Override
        void removeOneElementFromDeque(Deque<String> deque) {
            deque.removeLast();
        }

        @Override
        List<String> getRemains(Deque<String> deque) {
            List<String> remains = new ArrayList<>();
            while (!deque.isEmpty()) {
                remains.add(deque.pollLast());
            }
            return remains;
        }
    };

    abstract Direction flip();
    abstract void removeOneElementFromDeque(Deque<String> deque);
    abstract List<String> getRemains(Deque<String> deque);
}

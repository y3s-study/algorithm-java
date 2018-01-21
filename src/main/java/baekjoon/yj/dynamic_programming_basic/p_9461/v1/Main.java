package baekjoon.yj.dynamic_programming_basic.p_9461.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PadovanSequence padovanSequence = new PadovanSequence();

        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();

        while (testCount-- > 0) {
            long padovanValue = padovanSequence.getValueOfOrder(scanner.nextInt());
            System.out.println(padovanValue);
        }
    }
}

class PadovanSequence {
    private Map<Integer, Long> cache;

    PadovanSequence() {
        this.cache = new HashMap<>();
    }

    public long getValueOfOrder(int order) {
        if (cache.containsKey(order)) {
            return cache.get(order);
        }

        long value;

        if (order < 4) {
            value = 1L;
        } else {
            value = getValueOfOrder(order - 3) + getValueOfOrder(order - 2);
        }

        cache.put(order, value);
        return cache.get(order);
    }
}

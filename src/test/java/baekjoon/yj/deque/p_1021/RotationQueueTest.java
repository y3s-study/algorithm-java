package baekjoon.yj.deque.p_1021;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RotationQueueTest {
    @Test
    public void test() {
        Deque<Integer> deque = createDeque(10);
        List<Integer> pickList = Arrays.asList(1, 2, 3);

        int answer = Main.getAnswer(deque, pickList);

        assertThat(answer).isEqualTo(0);
    }

    @Test
    public void test2() {
        Deque<Integer> deque = createDeque(10);
        List<Integer> pickList = Arrays.asList(4, 5, 6);

        int answer = Main.getAnswer(deque, pickList);

        assertThat(answer).isEqualTo(3);
    }

    @Test
    public void test3() {
        Deque<Integer> deque = createDeque(1);
        List<Integer> pickList = Collections.singletonList(1);

        int answer = Main.getAnswer(deque, pickList);

        assertThat(answer).isEqualTo(0);
    }

    @Test
    public void test4() {
        Deque<Integer> deque = createDeque(5);
        List<Integer> pickList = Arrays.asList(5, 3);

        int answer = Main.getAnswer(deque, pickList);

        assertThat(answer).isEqualTo(3);
    }

    private LinkedList<Integer> createDeque(int size) {
        return IntStream.rangeClosed(1, size).boxed().collect(Collectors.toCollection(LinkedList::new));
    }
}
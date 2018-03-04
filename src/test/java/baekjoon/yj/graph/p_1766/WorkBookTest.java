package baekjoon.yj.graph.p_1766;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WorkBookTest {
    @Test
    public void testCase1() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(4, ImmutableList.of(2));
        graph.put(3, ImmutableList.of(1));

        int[] inDegreeCount = new int[5];
        inDegreeCount[1] = 1;
        inDegreeCount[2] = 1;

        List<Integer> problemSolvingOrder = new WorkBook(graph, inDegreeCount).getProblemSolvingOrder();

        assertThat(problemSolvingOrder).containsExactly(3, 1, 4, 2);
    }

    @Test
    public void testCase2() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(3, ImmutableList.of(1));
        graph.put(5, ImmutableList.of(3));
        graph.put(4, ImmutableList.of(2));

        int[] inDegreeCount = new int[6];
        inDegreeCount[1] = 1;
        inDegreeCount[2] = 1;
        inDegreeCount[3] = 1;

        List<Integer> problemSolvingOrder = new WorkBook(graph, inDegreeCount).getProblemSolvingOrder();

        assertThat(problemSolvingOrder).containsExactly(4, 2, 5, 3, 1);
    }
}
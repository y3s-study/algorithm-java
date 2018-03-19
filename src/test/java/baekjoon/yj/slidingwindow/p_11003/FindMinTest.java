package baekjoon.yj.slidingwindow.p_11003;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FindMinTest {
    @Test(timeout = 3000)
    public void test() {
        FindMin findMin = new FindMin();
        List<Integer> result = findMin.find(ImmutableList.of(1, 5, 2, 3, 6, 2, 3, 7, 3, 5, 2, 6), 3);
        assertThat(result).containsExactly(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 2, 2);
    }

    @Test(timeout = 3000)
    public void testTimeOut() {
        FindMin findMin = new FindMin();

        List<Integer> numbers = IntStream.rangeClosed(1, 5_000_000).boxed().collect(Collectors.toList());
        findMin.find(numbers, 3);
    }
}
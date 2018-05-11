package baekjoon.yj.segmenttree.p_11659;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class RangeSumCalculatorTest {
    @Test
    public void canCreate() {
        new RangeSumCalculator(Lists.newArrayList(5, 4, 3, 2, 1));
    }

    @Test
    public void test1() {
        final RangeSumCalculator sut = new RangeSumCalculator(Lists.newArrayList(5, 4, 3, 2, 1));

        assertThat(sut.getSumOfRange(1, 3)).isEqualTo(12);
        assertThat(sut.getSumOfRange(2, 4)).isEqualTo(9);
        assertThat(sut.getSumOfRange(5, 5)).isEqualTo(1);
    }

    @Test(timeout = 1000)
    public void test2() {
        final List<Integer> data = IntStream.rangeClosed(1, 100_000).boxed().collect(toList());
        final RangeSumCalculator sut = new RangeSumCalculator(data);

        for (int i = 0; i < 100_000; i++) {
            assertThat(sut.getSumOfRange(1, 100_000)).isEqualTo(705082704);
        }
    }
}
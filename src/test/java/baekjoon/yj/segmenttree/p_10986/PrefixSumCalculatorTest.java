package baekjoon.yj.segmenttree.p_10986;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrefixSumCalculatorTest {
    @Test
    public void test1() {
        PrefixSumCalculator sut = new PrefixSumCalculator(3, new int[]{1, 2, 3, 1, 2});
        assertThat(sut.getRangeCount()).isEqualTo(7);
    }

    @Test
    public void test2() {
        PrefixSumCalculator sut = new PrefixSumCalculator(5, new int[]{1, 2, 5, 1, 2, 10, 6, 7, 8, 21, 9, 10, 20});
        assertThat(sut.getRangeCount()).isEqualTo(17);
    }

    @Test(timeout = 1000)
    public void test3() {
        PrefixSumCalculator sut = new PrefixSumCalculator(1000, IntStream.rangeClosed(2, 1_000_000).toArray());
        assertThat(sut.getRangeCount()).isEqualTo(1_699_500_000);
    }
}
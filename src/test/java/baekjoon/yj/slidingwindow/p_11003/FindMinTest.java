package baekjoon.yj.slidingwindow.p_11003;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FindMinTest {
    private FindMin findMin;

    @Before
    public void setUp() {
        findMin = new FindMin();
    }

    @Test(timeout = 3000)
    public void test() {
        String result = findMin.find(new int[]{1, 5, 2, 3, 6, 2, 3, 7, 3, 5, 2, 6}, 3);
        assertThat(result).isEqualTo("1 1 1 2 2 2 2 2 3 3 2 2 ");
    }

    @Test(timeout = 3000)
    public void testTimeOut() {
        String result = findMin.find(IntStream.rangeClosed(1, 5_000_000).toArray(), 3);
        System.out.print(result);
    }
}
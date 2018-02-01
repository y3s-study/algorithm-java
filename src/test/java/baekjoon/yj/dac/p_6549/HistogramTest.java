package baekjoon.yj.dac.p_6549;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HistogramTest {
    private long expectedArea;
    private Histogram sut;

    @Parameters(name = "{0}")
    public static Object[][] provideData() {
        return new Object[][]{
                {0, arrayOf(0)},
                {5, arrayOf(5)},
                {10, arrayOf(5, 5)},
                {7, arrayOf(3, 7)},
                {8, arrayOf(2, 1, 4, 5, 1, 3, 3)},
                {4000, arrayOf(1000, 1000, 1000, 1000)},
                {1400, arrayOf(100, 20, 200, 45, 30, 100, 300, 400, 20, 80, 700, 1000, 20, 40, 60)},
                {250500, IntStream.rangeClosed(1, 1_000).toArray()},
                {6252500, IntStream.rangeClosed(1, 5000).toArray()}
        };
    }

    public HistogramTest(long expectedArea, int[] heights) {
        this.expectedArea = expectedArea;
        this.sut = new Histogram(heights);
    }

    @Test
    public void testEachCase() {
        assertThat(sut.getLargestArea()).isEqualTo(expectedArea);
    }

    private static int[] arrayOf(int ... i) {
        return i;
    }
}

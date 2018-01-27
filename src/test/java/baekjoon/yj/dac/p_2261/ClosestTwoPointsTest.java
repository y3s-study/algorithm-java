package baekjoon.yj.dac.p_2261;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ClosestTwoPointsTest {
    private ClosestTwoPoints sut;

    @Before
    public void setUp() {
        sut = new ClosestTwoPoints();
    }

    @Test
    public void testCase1() {
        sut.addPoint(0, 0);
        sut.addPoint(10, 10);
        sut.addPoint(0, 10);
        sut.addPoint(10, 0);

        assertThat(sut.closestDistance()).isEqualTo(100L);
    }

    @Test
    public void testCase2() {
        sut.addPoint(0, 5);
        sut.addPoint(1, 4);
        sut.addPoint(0, 3);
        sut.addPoint(1, 2);
        sut.addPoint(3, 5);

        assertThat(sut.closestDistance()).isEqualTo(2L);
    }

    @Test
    public void testWorstCase() {
        IntStream.rangeClosed(1, 200).forEach(x -> IntStream.rangeClosed(1, 500).forEach(y -> sut.addPoint(x, y)));
        assertThat(sut.closestDistance()).isEqualTo(1L);
    }
}

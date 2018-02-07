package baekjoon.yj.dac.p_1074;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZTest {
    private Z sut;

    @Before
    public void setUp() {
        sut = new Z();
    }

    @Test
    public void testSmallestCase() {
        assertThat(sut.getOrder(1, 0, 0)).isEqualTo(0);
        assertThat(sut.getOrder(1, 0, 1)).isEqualTo(1);
        assertThat(sut.getOrder(1, 1, 0)).isEqualTo(2);
        assertThat(sut.getOrder(1, 1, 1)).isEqualTo(3);
    }

    @Test
    public void testVisitAllQuartile() {
        assertThat(sut.getOrder(4, 3, 5)).isEqualTo(27);
    }

    @Test(timeout = 2000)
    public void testWorstCase() {
        assertThat(sut.getOrder(15, 32767, 32767)).isEqualTo(1073741823);
    }
}

package baekjoon.yj.bruteforce.p_1038;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DecreasingNumberTest {

    private DecreasingNumber sut;

    @Before
    public void setUp() {
        sut = new DecreasingNumber();
    }

    @Test
    public void testCase1() {
        assertThat(sut.getNumber(0)).isEqualTo(0);
        assertThat(sut.getNumber(9)).isEqualTo(9);
    }

    @Test
    public void testCase2() {
        assertThat(sut.getNumber(10)).isEqualTo(10);
        assertThat(sut.getNumber(18)).isEqualTo(42);
    }

    @Test
    public void testCase3() {
        assertThat(sut.getNumber(100)).isEqualTo(750);
        assertThat(sut.getNumber(500)).isEqualTo(87631);
        assertThat(sut.getNumber(750)).isEqualTo(975321);
        assertThat(sut.getNumber(999)).isEqualTo(98764310);
        assertThat(sut.getNumber(1022)).isEqualTo(9876543210L);
    }

    @Test
    public void testCase4() {
        assertThat(sut.getNumber(1023)).isEqualTo(-1);
        assertThat(sut.getNumber(10_000)).isEqualTo(-1);
        assertThat(sut.getNumber(100_000)).isEqualTo(-1);
        assertThat(sut.getNumber(1_000_000)).isEqualTo(-1);
    }
}
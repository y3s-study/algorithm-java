package baekjoon.yj.dynamic_programming_basic.p_9251.v2;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LCSFinderTest {
    private LCSFinder lcsFinder;

    @Before
    public void setup() {
        lcsFinder = new LCSFinder();
    }

    @Test
    public void emptyStringTest() {
        assertThat(lcsFinder.getLengthOfLCS("", "")).isEqualTo(0);
        assertThat(lcsFinder.getLengthOfLCS("", "ABC")).isEqualTo(0);
        assertThat(lcsFinder.getLengthOfLCS("ABC", "")).isEqualTo(0);
    }

    @Test
    public void sameStringTest() {
        assertThat(lcsFinder.getLengthOfLCS("ABC", "ABC")).isEqualTo(3);
    }

    @Test
    public void differentStringTest() {
        assertThat(lcsFinder.getLengthOfLCS("ABC", "DEF")).isEqualTo(0);
    }

    @Test(timeout = 1000)
    public void testCase1() {
        assertThat(lcsFinder.getLengthOfLCS("ACAYKP", "CAPCAK")).isEqualTo(4);
    }

    @Test(timeout = 1000)
    public void testCase2() {
        assertThat(lcsFinder.getLengthOfLCS("ACAYKPACAIEPQIOEJFIQSFXACMBC", "ACAYKPMNVKJFRDVBFGFHGEIJDJ")).isEqualTo(9);
    }

    @Test(timeout = 1000)
    public void testWorstCase() {
        // given
        String str1 = Stream.generate(() -> "A").limit(1000).collect(Collectors.joining());
        String str2 = Stream.generate(() -> "B").limit(1000).collect(Collectors.joining());

        // when
        int length = lcsFinder.getLengthOfLCS(str1, str2);

        // then
        assertThat(length).isEqualTo(0);
    }
}

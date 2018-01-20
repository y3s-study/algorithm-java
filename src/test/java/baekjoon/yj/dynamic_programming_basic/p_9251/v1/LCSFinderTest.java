package baekjoon.yj.dynamic_programming_basic.p_9251.v1;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LCSFinderTest {
    @Test
    public void emptyStringTest() {
        assertThat(new LCSFinder("", "").getLCSLength()).isEqualTo(0);
        assertThat(new LCSFinder("", "ABC").getLCSLength()).isEqualTo(0);
        assertThat(new LCSFinder("ABC", "").getLCSLength()).isEqualTo(0);
    }

    @Test
    public void sameStringTest() {
        LCSFinder lcsFinder = new LCSFinder("ABC", "ABC");

        assertThat(lcsFinder.getLCSLength()).isEqualTo(3);
    }

    @Test
    public void differentStringTest() {
        LCSFinder lcsFinder = new LCSFinder("ABC", "DEF");

        assertThat(lcsFinder.getLCSLength()).isEqualTo(0);
    }

    @Test(timeout = 1000)
    public void testCase1() {
        LCSFinder lcsFinder = new LCSFinder("ACAYKP", "CAPCAK");

        assertThat(lcsFinder.getLCSLength()).isEqualTo(4);
    }

    @Test(timeout = 1000)
    public void testCase2() {
        LCSFinder lcsFinder = new LCSFinder("ACAYKPACAIEPQIOEJFIQSFXACMBC", "ACAYKPMNVKJFRDVBFGFHGEIJDJ");

        assertThat(lcsFinder.getLCSLength()).isEqualTo(9);
    }

    @Test(timeout = 1000)
    public void testWorstCase() {
        // given
        String str1 = Stream.generate(() -> "A").limit(1000).collect(Collectors.joining());
        String str2 = Stream.generate(() -> "B").limit(1000).collect(Collectors.joining());
        LCSFinder lcsFinder = new LCSFinder(str1, str2);

        // when
        int length = lcsFinder.getLCSLength();

        // then
        assertThat(length).isEqualTo(0);
    }
}
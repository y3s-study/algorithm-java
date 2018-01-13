package baekjoon.yj.deque.p_5430;


import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ACTest {

    @Test
    public void testCase1() {
        String result = AC.of("RDD", "[1,2,3,4]").compute();
        assertThat(result).isEqualTo("[2,1]");
    }

    @Test
    public void testCase2() {
        String result = AC.of("DD", "[42]").compute();
        assertThat(result).isEqualTo("error");
    }

    @Test
    public void testCase3() {
        String result = AC.of("RRD", "[1,1,2,3,5,8]").compute();
        assertThat(result).isEqualTo("[1,2,3,5,8]");
    }

    @Test
    public void testCase4() {
        String result = AC.of("D", "[]").compute();
        assertThat(result).isEqualTo("error");
    }

    @Test
    public void testCase5() {
        String result = AC.of("DRD", "[10, 20]").compute();
        assertThat(result).isEqualTo("[]");
    }

    /**
     * 최악의 경우 1000ms 안에 계산이 완료 되어야 한다.
     */
    @Test(timeout = 1000)
    public void testWorstCase() {
        // given
        String functionStr = IntStream.rangeClosed(1, 100_000).mapToObj(i -> i <= 99_900 ? "R" : "D").collect(Collectors.joining());
        String elements = Stream.generate(() -> "1").limit(100).collect(Collectors.joining(",", "[", "]"));

        // when
        Stopwatch stopwatch = Stopwatch.createStarted();
        String result = AC.of(functionStr, elements).compute();
        stopwatch.stop();

        // then
        assertThat(result).isEqualTo("[]");

        System.out.println("worst case elapsed time : " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }
}

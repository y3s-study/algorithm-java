package baekjoon.yj.binarysearch.p_1654;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CableCutterTest {

    @Test
    public void test() {
        long result = new CableCutter().getMaxCuttingLength(Arrays.asList(802L, 743L, 457L, 539L), 457L, 11);
        assertThat(result).isEqualTo(200L);
    }

    @Test
    public void test2() {
        long result = new CableCutter().getMaxCuttingLength(Arrays.asList(100L, 150L, 200L, 250L), 100L, 14);
        assertThat(result).isEqualTo(50L);
    }
}
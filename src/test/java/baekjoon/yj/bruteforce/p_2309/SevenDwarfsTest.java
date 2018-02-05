package baekjoon.yj.bruteforce.p_2309;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SevenDwarfsTest {
    @Test
    public void test() {
        int[] sevenDwarfs = new SevenDwarfs().getSevenDwarfs(new int[]{20, 7, 23, 19, 10, 15, 25, 8, 13});
        assertThat(sevenDwarfs).containsExactly(7, 8, 10, 13, 19, 20, 23);
    }
}

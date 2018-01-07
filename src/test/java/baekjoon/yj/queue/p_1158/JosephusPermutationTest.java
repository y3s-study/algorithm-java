package baekjoon.yj.queue.p_1158;

import org.junit.Test;

import static baekjoon.yj.queue.p_1158.Main.josephusPermutation;
import static org.assertj.core.api.Assertions.assertThat;

public class JosephusPermutationTest {
    @Test
    public void testEachCase() {
        assertThat(josephusPermutation(1, 1)).isEqualTo("<1>");
        assertThat(josephusPermutation(7, 3)).isEqualTo("<3, 6, 2, 7, 5, 1, 4>");
        assertThat(josephusPermutation(5, 2)).isEqualTo("<2, 4, 1, 5, 3>");
        assertThat(josephusPermutation(10, 4)).isEqualTo("<4, 8, 2, 7, 3, 10, 9, 1, 6, 5>");
        assertThat(josephusPermutation(15, 9)).isEqualTo("<9, 3, 13, 8, 5, 2, 1, 4, 7, 12, 10, 11, 6, 14, 15>");
    }

    /**
     * 최악의 경우 2초를 넘지 않아야 한다.
     */
    @Test(timeout = 2000)
    public void performanceTest_shouldNotExceed2Seconds() {
        long startTime = System.currentTimeMillis();
        josephusPermutation(5000, 5000);
        System.out.println("task takes " + (System.currentTimeMillis() - startTime) + "ms");
    }

}
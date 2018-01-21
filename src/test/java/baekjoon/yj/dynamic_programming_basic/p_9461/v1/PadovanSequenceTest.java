package baekjoon.yj.dynamic_programming_basic.p_9461.v1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PadovanSequenceTest {
    @Parameter public int order;
    @Parameter(1) public long expected;
    private PadovanSequence padovanSequence;

    @Before
    public void setup() {
        padovanSequence = new PadovanSequence();
    }

    @Parameters(name = "Padovan sequence of {0} should be {1}")
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {1, 1L},
                        {2, 1L},
                        {3, 1L},
                        {4, 2L},
                        {5, 2L},
                        {6, 3L},
                        {7, 4L},
                        {8, 5L},
                        {9, 7L},
                        {10, 9L},
                        {25, 616L},
                        {50, 696081L},
                        {100, 888855064897L},
                }
        );
    }

    @Test(timeout = 1000)
    public void testPadovanSequence() {
        assertThat(padovanSequence.getValueOfOrder(order)).isEqualTo(expected);
    }
}

package baekjoon.yj.dynamic_programming.p_2342;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(Parameterized.class)
public class DDRTest {

    @Parameter
    public List<Integer> positions;
    @Parameter(1)
    public int expected;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {of(1, 2, 2, 4), 8},
                {of(1, 3, 2, 4), 10},
                {of(1, 3, 4, 1), 8},
                {of(1, 2, 3, 4, 1, 2, 3, 4), 18},
                {of(1, 2, 3, 4, 4, 4, 3, 2, 2, 2, 1, 1, 1), 23},
        };
    }

    @Test(timeout = 2000)
    public void test() {
        assertThat(new DDR(positions).getTotalPower()).isEqualTo(expected);
    }
}
package baekjoon.yj.binarytree.p_13325;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static baekjoon.yj.binarytree.p_13325.Main.getSum;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class P13325Test {

    @Parameter
    public int expected;
    @Parameter(1)
    public List<Integer> edges;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {15, asList(0, 2, 2, 2, 1, 1, 3)},
                {2000, asList(0, 1, 1000)},
                {27, asList(0, 1, 2, 1, 3, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1)},
                {5001, asList(0, 1, 1000, 1, 1, 1000, 1000)},
        };
    }

    @Test
    public void testEachCase() {
        assertThat(getSum(edges)).isEqualTo(expected);
    }
}

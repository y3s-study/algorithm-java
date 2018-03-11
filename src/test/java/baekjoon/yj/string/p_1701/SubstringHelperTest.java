package baekjoon.yj.string.p_1701;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class SubstringHelperTest {

    @Parameter public String s;
    @Parameter(1) public int expected;
    private SubstringHelper uut;

    @Parameters(name = "{0} should be {1}")
    public static Object[][] parameters() {
        return new Object[][]{
                {"abcdabcabb", 3},
                {"abcabcabc", 6},
                {"abcdefghikjlmn", 0},
                {"ddhddhddd", 5},
                {"oppxppo", 2},
                {"바나나토마토바나나", 3}
        };
    }

    @Before
    public void setUp() {
        uut = new SubstringHelper();
    }

    @Test
    public void test() {
        assertThat(uut.getLongestSubstringLength(s)).isEqualTo(expected);
    }
}
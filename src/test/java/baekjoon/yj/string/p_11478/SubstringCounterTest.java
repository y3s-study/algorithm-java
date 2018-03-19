package baekjoon.yj.string.p_11478;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class SubstringCounterTest {
    @Parameter public String s;
    @Parameter(1) public long expected;
    private SubstringCounter uut;

    @Before
    public void setUp() {
        uut = new SubstringCounter();
    }

    @Parameters
    public static Object[][] parameters() {
        return new Object[][]{
                {"ababc", 12},
                {"banana", 15}
        };
    }

    @Test
    public void test() {
        assertThat(uut.getSubstringCount(s)).isEqualTo(expected);
    }
}
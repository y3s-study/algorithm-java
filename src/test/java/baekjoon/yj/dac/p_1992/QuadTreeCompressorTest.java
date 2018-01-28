package baekjoon.yj.dac.p_1992;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuadTreeCompressorTest {
    private QuadTreeCompressor sut;

    @Before
    public void setUp() {
        sut = new QuadTreeCompressor();
    }

    @Test(timeout = 2000)
    public void testAllZero() {
        String[][] source = new String[][]
                {
                        {"0", "0"},
                        {"0", "0"}
                };

        assertThat(sut.compress(source)).isEqualTo("0");
    }

    @Test(timeout = 2000)
    public void testAllOne() {
        String[][] source = new String[][]
                {
                        {"1", "1"},
                        {"1", "1"}
                };

        assertThat(sut.compress(source)).isEqualTo("1");
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[][] source = new String[][]
                {
                        {"1", "0"},
                        {"0", "1"}
                };

        assertThat(sut.compress(source)).isEqualTo("(1001)");
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[][] source = new String[][]
                {
                        {"1", "0"},
                        {"0", "1"}
                };

        assertThat(sut.compress(source)).isEqualTo("(1001)");
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[][] source = new String[][]
                {
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                        {"0", "0", "0", "0"},
                        {"0", "0", "0", "0"},
                };

        assertThat(sut.compress(source)).isEqualTo("(1100)");
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[][] source = new String[][]
                {
                        {"1", "0", "1", "0"},
                        {"1", "1", "1", "1"},
                        {"0", "0", "1", "0"},
                        {"0", "0", "1", "0"},
                };

        assertThat(sut.compress(source)).isEqualTo("((1011)(1011)0(1010))");
    }

    @Test
    public void testCase5() {
        String[][] source = new String[][]
                {
                        {"1", "1", "1", "1", "0", "0", "0", "0"},
                        {"1", "1", "1", "1", "0", "0", "0", "0"},
                        {"0", "0", "0", "1", "1", "1", "0", "0"},
                        {"0", "0", "0", "1", "1", "1", "0", "0"},
                        {"1", "1", "1", "1", "0", "0", "0", "0"},
                        {"1", "1", "1", "1", "0", "0", "0", "0"},
                        {"1", "1", "1", "1", "0", "0", "1", "1"},
                        {"1", "1", "1", "1", "0", "0", "1", "1"}
                };

        assertThat(sut.compress(source)).isEqualTo("((110(0101))(0010)1(0001))");
    }
}

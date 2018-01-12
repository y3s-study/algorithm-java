package baekjoon.yj.deque.p_5430;


import org.junit.Test;

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
}

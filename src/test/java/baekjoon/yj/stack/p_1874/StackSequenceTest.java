package baekjoon.yj.stack.p_1874;

import org.junit.Test;

import static baekjoon.yj.stack.p_1874.Main.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StackSequenceTest {

    @Test
    public void test() {
        String result = getOperations(new int[]{3, 4, 6, 8, 7, 5, 2, 1});
        assertThat(result.replaceAll("\n", ""), is("+++-+-++-++-----"));
    }

    @Test
    public void test2() {
        String result = getOperations(new int[]{1, 2, 3, 4});
        assertThat(result.replaceAll("\n", ""), is("+-+-+-+-"));
    }

    @Test
    public void test3() {
        String result = getOperations(new int[]{1, 3, 2, 4});
        assertThat(result.replaceAll("\n", ""), is("+-++--+-"));
    }

    @Test
    public void test4() {
        String result = getOperations(new int[]{1, 4, 2, 3});
        assertThat(result.replaceAll("\n", ""), is("NO"));
    }

}

package baekjoon.yj.dac.p_2447;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StarTest {
    private Star star;

    @Before
    public void setUp() {
        star = new Star();
    }

    @Test
    public void testNumber1() {
        String result = star.print(1);
        String expected = "*\n";

        System.out.println("actual : \n" + result);
        System.out.println("expected : \n" + expected);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testNumber3() {
        String result = star.print(3);
        String expected =
                        "***\n" +
                        "* *\n" +
                        "***\n";

        System.out.println("actual : \n" + result);
        System.out.println("expected : \n" + expected);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testNumber9() {
        String result = star.print(9);
        String expected =
                        "*********\n" +
                        "* ** ** *\n" +
                        "*********\n" +
                        "***   ***\n" +
                        "* *   * *\n" +
                        "***   ***\n" +
                        "*********\n" +
                        "* ** ** *\n" +
                        "*********\n";

        System.out.println("actual : \n" + result);
        System.out.println("expected : \n" + expected);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testNumber27() {
        String result = star.print(27);
        String expected =
                        "***************************\n" +
                        "* ** ** ** ** ** ** ** ** *\n" +
                        "***************************\n" +
                        "***   ******   ******   ***\n" +
                        "* *   * ** *   * ** *   * *\n" +
                        "***   ******   ******   ***\n" +
                        "***************************\n" +
                        "* ** ** ** ** ** ** ** ** *\n" +
                        "***************************\n" +
                        "*********         *********\n" +
                        "* ** ** *         * ** ** *\n" +
                        "*********         *********\n" +
                        "***   ***         ***   ***\n" +
                        "* *   * *         * *   * *\n" +
                        "***   ***         ***   ***\n" +
                        "*********         *********\n" +
                        "* ** ** *         * ** ** *\n" +
                        "*********         *********\n" +
                        "***************************\n" +
                        "* ** ** ** ** ** ** ** ** *\n" +
                        "***************************\n" +
                        "***   ******   ******   ***\n" +
                        "* *   * ** *   * ** *   * *\n" +
                        "***   ******   ******   ***\n" +
                        "***************************\n" +
                        "* ** ** ** ** ** ** ** ** *\n" +
                        "***************************\n";

        System.out.println("actual : \n" + result);
        System.out.println("expected : \n" + expected);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void printNumber81() {
        System.out.println(star.print(81));
    }

    @Test
    public void printNumber243() {
        System.out.println(star.print(243));
    }
}

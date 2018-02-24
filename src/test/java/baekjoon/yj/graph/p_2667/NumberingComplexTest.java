package baekjoon.yj.graph.p_2667;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberingComplexTest {

    @Test
    public void testWhenNoComplex() {
        String map =    "00000\n" +
                        "00000\n" +
                        "00000\n" +
                        "00000\n" +
                        "00000";

        NumberingComplex numberingComplex = NumberingComplex.createFromMap(map);

        assertThat(numberingComplex.complexCount()).isEqualTo(0);
        assertThat(numberingComplex.houseCountList()).isEmpty();
    }

    @Test
    public void testWhenOneComplex() {
        String map =    "10000\n" +
                        "00000\n" +
                        "00000\n" +
                        "00000\n" +
                        "00000";

        NumberingComplex numberingComplex = NumberingComplex.createFromMap(map);

        assertThat(numberingComplex.complexCount()).isEqualTo(1);
        assertThat(numberingComplex.houseCountList()).containsExactly(1);
    }

    @Test
    public void testWhenAllOne() {
        String map =    "11111\n" +
                        "11111\n" +
                        "11111\n" +
                        "11111\n" +
                        "11111";

        NumberingComplex numberingComplex = NumberingComplex.createFromMap(map);

        assertThat(numberingComplex.complexCount()).isEqualTo(1);
        assertThat(numberingComplex.houseCountList()).containsExactly(25);
    }

    @Test(timeout = 1000)
    public void testWorstCaseAllOne() {
        String map =    "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111\n" +
                        "1111111111111111111111111";

        NumberingComplex numberingComplex = NumberingComplex.createFromMap(map);

        assertThat(numberingComplex.complexCount()).isEqualTo(1);
        assertThat(numberingComplex.houseCountList()).containsExactly(625);
    }

    @Test(timeout = 1000)
    public void testWorstCaseAllZero() {
        String map =    "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000\n" +
                        "0000000000000000000000000";

        NumberingComplex numberingComplex = NumberingComplex.createFromMap(map);

        assertThat(numberingComplex.complexCount()).isEqualTo(0);
        assertThat(numberingComplex.houseCountList()).isEmpty();
    }

    @Test
    public void testCase1() {
        String map =    "0110100\n" +
                        "0110101\n" +
                        "1110101\n" +
                        "0000111\n" +
                        "0100000\n" +
                        "0111110\n" +
                        "0111000";

        NumberingComplex numberingComplex = NumberingComplex.createFromMap(map);

        assertThat(numberingComplex.complexCount()).isEqualTo(3);
        assertThat(numberingComplex.houseCountList()).containsExactly(7, 8, 9);
    }

    @Test
    public void testCase2() {
        String map =    "1111111111\n" +
                        "0000000011\n" +
                        "1111111111\n" +
                        "1100000000\n" +
                        "1100111111\n" +
                        "1100110011\n" +
                        "1100111111\n" +
                        "1111000000\n" +
                        "0000001111\n" +
                        "1000001111";

        NumberingComplex numberingComplex = NumberingComplex.createFromMap(map);

        assertThat(numberingComplex.complexCount()).isEqualTo(4);
        assertThat(numberingComplex.houseCountList()).containsExactly(1, 8, 16, 34);
    }
}
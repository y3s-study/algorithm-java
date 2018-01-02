package baekjoon.yj.p_2504;

import org.junit.Test;

import static baekjoon.yj.p_2504.Main.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ValueOfStackTest {

    @Test
    public void testNormalCase() {
        assertThat(valueOfParentheses("()"), is(2));
        assertThat(valueOfParentheses("[]"), is(3));
        assertThat(valueOfParentheses("(())"), is(4));
        assertThat(valueOfParentheses("[[]]"), is(9));
        assertThat(valueOfParentheses("[[][]]"), is(18));
        assertThat(valueOfParentheses("((()[]))"), is(20));
        assertThat(valueOfParentheses("(()[[]])([])"), is(28));
        assertThat(valueOfParentheses("((()[[]])([])[](()))"), is(70));
        assertThat(valueOfParentheses("((()[[]])([])[](()))[][][][][]"), is(85));
    }

    @Test
    public void testAbnormalCase() {
        assertThat(valueOfParentheses(""), is(0));
        assertThat(valueOfParentheses(")"), is(0));
        assertThat(valueOfParentheses("]"), is(0));
        assertThat(valueOfParentheses("("), is(0));
        assertThat(valueOfParentheses("["), is(0));
        assertThat(valueOfParentheses("())"), is(0));
        assertThat(valueOfParentheses("[]]"), is(0));
        assertThat(valueOfParentheses("()["), is(0));
        assertThat(valueOfParentheses("[]("), is(0));
        assertThat(valueOfParentheses("[)"), is(0));
        assertThat(valueOfParentheses("(]"), is(0));
        assertThat(valueOfParentheses(")("), is(0));
        assertThat(valueOfParentheses("]["), is(0));
        assertThat(valueOfParentheses("]("), is(0));
        assertThat(valueOfParentheses(")["), is(0));
        assertThat(valueOfParentheses("(])"), is(0));
        assertThat(valueOfParentheses("[(]"), is(0));
    }
}
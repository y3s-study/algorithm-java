package baekjoon.yj.deque.p_10866;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MyDequeTest {

    private MyDeque<Integer> myDeque;

    @Before
    public void setUp() {
        myDeque = MyDeque.newInstance();
    }

    @Test
    public void pushFrontTest() {
        myDeque.pushFront(1);
        myDeque.pushFront(2);

        assertThat(myDeque.size()).isEqualTo(2);
        assertThat(myDeque.front()).isEqualTo(2);
        assertThat(myDeque.back()).isEqualTo(1);
    }

    @Test
    public void pushBackTest() {
        myDeque.pushBack(1);
        myDeque.pushBack(2);

        assertThat(myDeque.size()).isEqualTo(2);
        assertThat(myDeque.front()).isEqualTo(1);
        assertThat(myDeque.back()).isEqualTo(2);
    }

    @Test
    public void emptyTest() {
        assertThat(myDeque.empty()).isTrue();

        myDeque.pushBack(1);

        assertThat(myDeque.empty()).isFalse();
    }

    @Test(expected = EmptyMyDequeException.class)
    public void frontExceptionTest() {
        myDeque.front();
    }

    @Test(expected = EmptyMyDequeException.class)
    public void backExceptionTest() {
        myDeque.back();
    }

    @Test(expected = EmptyMyDequeException.class)
    public void popFrontExceptionTest() {
        myDeque.popFront();
    }

    @Test
    public void popFrontTest() {
        myDeque.pushFront(1);
        myDeque.pushFront(2);

        Integer e = myDeque.popFront();

        assertThat(e).isEqualTo(2);
        assertThat(myDeque.size()).isEqualTo(1);
    }

    @Test(expected = EmptyMyDequeException.class)
    public void popBackExceptionTest() {
        myDeque.popBack();
    }

    @Test
    public void popBackTest() {
        myDeque.pushBack(1);
        myDeque.pushBack(2);
        myDeque.pushFront(3);

        Integer e = myDeque.popBack();

        assertThat(e).isEqualTo(2);
        assertThat(myDeque.size()).isEqualTo(2);
    }

    @Test
    public void sizeTest() {
        assertThat(myDeque.size()).isEqualTo(0);

        myDeque.pushFront(1);
        assertThat(myDeque.size()).isEqualTo(1);

        myDeque.pushBack(2);
        assertThat(myDeque.size()).isEqualTo(2);

        myDeque.popFront();
        myDeque.popBack();
        assertThat(myDeque.size()).isEqualTo(0);
    }
}

package baekjoon.yj.binarytree.p_2957;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class BinarySearchTreeTest {

    private BinarySearchTree tree;

    @Before
    public void setUp() {
        tree = new BinarySearchTree();
    }

    @Test
    public void testInsertWithOneValue() {
        tree.insert(3);

        assertThat(tree.count()).isEqualTo(0);
    }

    @Test
    public void testInsertWithTwoValue() {
        tree.insert(3);
        tree.insert(5);

        assertThat(tree.count()).isEqualTo(1);
    }

    @Test
    public void testInsertWithThreeValue() {
        tree.insert(3);
        tree.insert(5);
        tree.insert(1);

        assertThat(tree.count()).isEqualTo(2);
    }

    @Test
    public void testInsertCase1() {
        tree.insert(3);
        assertThat(tree.count()).isEqualTo(0);

        tree.insert(5);
        assertThat(tree.count()).isEqualTo(1);

        tree.insert(1);
        assertThat(tree.count()).isEqualTo(2);

        tree.insert(6);
        assertThat(tree.count()).isEqualTo(4);

        tree.insert(8);
        assertThat(tree.count()).isEqualTo(7);

        tree.insert(7);
        assertThat(tree.count()).isEqualTo(11);

        tree.insert(2);
        assertThat(tree.count()).isEqualTo(13);

        tree.insert(4);
        assertThat(tree.count()).isEqualTo(15);
    }

    @Test
    public void testInsertCase2() {
        tree.insert(1);
        assertThat(tree.count()).isEqualTo(0);

        tree.insert(2);
        assertThat(tree.count()).isEqualTo(1);

        tree.insert(3);
        assertThat(tree.count()).isEqualTo(3);

        tree.insert(4);
        assertThat(tree.count()).isEqualTo(6);

        tree.insert(5);
        assertThat(tree.count()).isEqualTo(10);

        tree.insert(6);
        assertThat(tree.count()).isEqualTo(15);

        tree.insert(7);
        assertThat(tree.count()).isEqualTo(21);
    }

    @Test(timeout = 1000)
    public void testWorstCase() {
        IntStream.rangeClosed(1, 300_000).forEach(tree::insert);
        assertThat(tree.count()).isEqualTo(44999850000L);
    }

}
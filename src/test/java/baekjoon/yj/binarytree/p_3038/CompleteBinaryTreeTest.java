package baekjoon.yj.binarytree.p_3038;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CompleteBinaryTreeTest {

    @Test
    public void testLevel1() {
        CompleteBinaryTree sut = new CompleteBinaryTree(1);
        assertThat(sut.preOrder()).isEqualTo("1 ");
    }

    @Test
    public void testLevel2() {
        CompleteBinaryTree sut = new CompleteBinaryTree(2);
        assertThat(sut.preOrder()).isEqualTo("3 1 2 ");
    }

    @Test
    public void testLevel3() {
        CompleteBinaryTree sut = new CompleteBinaryTree(3);
        assertThat(sut.preOrder()).isEqualTo("7 6 1 3 5 2 4 ");
    }

    @Test
    public void testLevel4() {
        CompleteBinaryTree sut = new CompleteBinaryTree(4);
        assertThat(sut.preOrder()).isEqualTo("15 14 12 1 5 10 3 7 13 11 2 6 9 4 8 ");
    }
}
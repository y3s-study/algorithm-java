package baekjoon.yj.tree.p_1991;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeTest {

    @Test
    public void testCase1() {
        Tree tree = Tree.createWithRootNode(Node.of('A'));

        tree.addNode('A', 'B', 'C');
        tree.addNode('B', 'D', '.');
        tree.addNode('C', 'E', 'F');
        tree.addNode('E', '.', '.');
        tree.addNode('F', '.', 'G');
        tree.addNode('D', '.', '.');

        assertThat(tree.preOrder()).isEqualTo("ABDCEFG");
        assertThat(tree.inOrder()).isEqualTo("DBAECFG");
        assertThat(tree.postOrder()).isEqualTo("DBEGFCA");
    }

    @Test
    public void testCase2() {
        Tree tree = Tree.createWithRootNode(Node.of('A'));

        tree.addNode('A', '.', '.');

        assertThat(tree.preOrder()).isEqualTo("A");
        assertThat(tree.inOrder()).isEqualTo("A");
        assertThat(tree.postOrder()).isEqualTo("A");
    }

    @Test
    public void testCase3() {
        Tree tree = Tree.createWithRootNode(Node.of('A'));

        tree.addNode('A', 'B', 'C');
        tree.addNode('B', 'D', 'E');
        tree.addNode('C', 'F', 'G');
        tree.addNode('D', 'H', 'I');
        tree.addNode('E', 'J', 'K');
        tree.addNode('F', 'L', 'M');
        tree.addNode('G', 'N', 'O');
        tree.addNode('H', 'P', 'Q');
        tree.addNode('I', 'R', 'S');
        tree.addNode('J', 'T', 'U');
        tree.addNode('K', 'V', 'W');
        tree.addNode('L', 'X', 'Y');
        tree.addNode('M', 'Z', '.');

        assertThat(tree.preOrder()).isEqualTo("ABDHPQIRSEJTUKVWCFLXYMZGNO");
        assertThat(tree.inOrder()).isEqualTo("PHQDRISBTJUEVKWAXLYFZMCNGO");
        assertThat(tree.postOrder()).isEqualTo("PQHRSIDTUJVWKEBXYLZMFNOGCA");
    }
}
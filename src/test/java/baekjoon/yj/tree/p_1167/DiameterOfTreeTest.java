package baekjoon.yj.tree.p_1167;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DiameterOfTreeTest {

    @Test
    public void testCase1() {
        List<List<Node>> tree = ImmutableList.of(
                ImmutableList.of(),
                ImmutableList.of(Node.of(2, 100), Node.of(3, 100)),
                ImmutableList.of(Node.of(1, 100)),
                ImmutableList.of(Node.of(1, 100))
        );

        int diameter = new DiameterOfTree(tree).getDiameter();

        assertThat(diameter).isEqualTo(200);
    }

    @Test
    public void testCase2() {
        List<List<Node>> tree = ImmutableList.of(
                ImmutableList.of(),
                ImmutableList.of(Node.of(3, 2)),
                ImmutableList.of(Node.of(4, 4)),
                ImmutableList.of(Node.of(1, 2), Node.of(4, 3)),
                ImmutableList.of(Node.of(2, 4), Node.of(3, 3), Node.of(5, 6)),
                ImmutableList.of(Node.of(4, 6))
        );

        int diameter = new DiameterOfTree(tree).getDiameter();

        assertThat(diameter).isEqualTo(11);
    }

    @Test
    public void testCase3() {
        List<List<Node>> tree = ImmutableList.of(
                ImmutableList.of(),
                ImmutableList.of(Node.of(2, 5), Node.of(3, 6)),
                ImmutableList.of(Node.of(1, 5)),
                ImmutableList.of(Node.of(1, 6), Node.of(4, 9), Node.of(5, 7), Node.of(6, 13)),
                ImmutableList.of(Node.of(3, 9)),
                ImmutableList.of(Node.of(3, 7)),
                ImmutableList.of(Node.of(3, 13))
        );

        int diameter = new DiameterOfTree(tree).getDiameter();

        assertThat(diameter).isEqualTo(24);
    }
}

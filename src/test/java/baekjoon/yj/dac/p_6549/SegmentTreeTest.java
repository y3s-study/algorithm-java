package baekjoon.yj.dac.p_6549;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SegmentTreeTest {

    @Test
    public void canCreate() {
        SegmentTree sut = new SegmentTree(new int[]{2, 1, 4, 5, 1, 3, 3});

        assertThat(sut.minimumIndexInRange(0, 6)).isEqualTo(1);
        assertThat(sut.minimumIndexInRange(0, 0)).isEqualTo(0);
        assertThat(sut.minimumIndexInRange(2, 6)).isEqualTo(4);
        assertThat(sut.minimumIndexInRange(2, 3)).isEqualTo(2);
        assertThat(sut.minimumIndexInRange(5, 6)).isEqualTo(5);
        assertThat(sut.minimumIndexInRange(6, 6)).isEqualTo(6);
    }
}
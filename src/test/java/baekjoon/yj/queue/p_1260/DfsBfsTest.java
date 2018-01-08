package baekjoon.yj.queue.p_1260;

import org.junit.Test;

import static baekjoon.yj.queue.p_1260.Main.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DfsBfsTest {

    @Test
    public void DFS_Test() {
        // given
        boolean[][] graph = new boolean[5][5];
        graph[1][2] = true;
        graph[1][3] = true;
        graph[1][4] = true;
        graph[2][4] = true;
        graph[3][4] = true;

        // when
        String dfsResult = getDFSResult(graph, 1);

        // then
        assertThat(dfsResult).isEqualTo("1 2 4 3");
    }

    @Test
    public void BFS_Test() {
        // given
        boolean[][] graph = new boolean[5][5];
        graph[1][2] = true;
        graph[1][3] = true;
        graph[1][4] = true;
        graph[2][4] = true;
        graph[3][4] = true;

        // when
        String bfsResult = getBFSResult(graph, 1);

        // then
        assertThat(bfsResult).isEqualTo("1 2 3 4");
    }
}

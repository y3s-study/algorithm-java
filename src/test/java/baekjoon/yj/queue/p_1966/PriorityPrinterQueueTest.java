package baekjoon.yj.queue.p_1966;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static baekjoon.yj.queue.p_1966.Main.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PriorityPrinterQueueTest {

    @Test
    public void testPrintOrder1() {
        Queue<Document> queue = new LinkedList<>();
        queue.offer(new Document(0, 1));
        queue.offer(new Document(1, 2));
        queue.offer(new Document(2, 3));
        queue.offer(new Document(3, 4));

        assertThat(getPrintOrderOfDocument(queue, 2)).isEqualTo(2);
    }

    @Test
    public void testPrintOrder2() {
        Queue<Document> queue = new LinkedList<>();
        queue.offer(new Document(0, 1));
        queue.offer(new Document(1, 1));
        queue.offer(new Document(2, 9));
        queue.offer(new Document(3, 1));
        queue.offer(new Document(4, 1));
        queue.offer(new Document(5, 1));

        assertThat(getPrintOrderOfDocument(queue, 0)).isEqualTo(5);
    }

    @Test
    public void testPrintOrder3() {
        Queue<Document> queue = new LinkedList<>();
        queue.offer(new Document(0, 5));

        assertThat(getPrintOrderOfDocument(queue, 0)).isEqualTo(1);
    }
}
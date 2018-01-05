package baekjoon.yj.queue.p_1966;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1966
 * 프린터 큐
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();

        while (testCount-- > 0) {
            int documentCount = scanner.nextInt();
            int targetDocumentIndex = scanner.nextInt();

            Queue<Document> queue = new LinkedList<>();
            for (int i = 0; i < documentCount; i++) {
                int priority = scanner.nextInt();
                queue.add(new Document(i, priority));
            }

            System.out.println(getPrintOrderOfDocument(queue, targetDocumentIndex));
        }
    }

    static int getPrintOrderOfDocument(Queue<Document> queue, int targetDocumentIndex) {
        int printOrder = 0;

        while (!queue.isEmpty()) {
            Document polledDocument = queue.poll();

            if (hasHigherPriorityDocument(queue, polledDocument)) {
                queue.offer(polledDocument);
            } else if (polledDocument.getIndex() == targetDocumentIndex) {
                printOrder++;
                break;
            } else {
                printOrder++;
            }
        }

        return printOrder;
    }

    private static boolean hasHigherPriorityDocument(Queue<Document> queue, Document targetDocument) {
        return queue.stream().anyMatch(document -> document.getPriority() > targetDocument.getPriority());
        //		for (Document document : queue) {
        //			if (targetDocument.getPriority() < document.getPriority()) {
        //				return true;
        //			}
        //		}
        //		return false;
    }
}

class Document {
    private int index;
    private int priority;

    Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    int getIndex() {
        return index;
    }

    int getPriority() {
        return priority;
    }
}
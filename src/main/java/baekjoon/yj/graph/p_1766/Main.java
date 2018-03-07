package baekjoon.yj.graph.p_1766;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/1766
 * 문제집 (그래프 위상 정렬)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int problemCount = scanner.nextInt();
        int degreeCount = scanner.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegreeCount = new int[problemCount + 1];

        while (degreeCount-- > 0) {
            int previousProblem = scanner.nextInt();
            int nextProblem = scanner.nextInt();

            graph.computeIfAbsent(previousProblem, key -> new ArrayList<>()).add(nextProblem);
            inDegreeCount[nextProblem]++;
        }

        List<Integer> problemSolvingOrder = new WorkBook(graph, inDegreeCount).getProblemSolvingOrder();

        for (Integer problemNumber : problemSolvingOrder) {
            System.out.printf("%d ", problemNumber);
        }
    }
}

class WorkBook {
    private Map<Integer, List<Integer>> graph;
    private int[] inDegreeCount;

    WorkBook(Map<Integer, List<Integer>> graph, int[] inDegreeCount) {
        this.graph = graph;
        this.inDegreeCount = inDegreeCount;
    }

    public List<Integer> getProblemSolvingOrder() {
        Queue<Integer> queue = createQueueWithZeroInDegreeProblems();

        List<Integer> problemSolvingOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            Integer problemNumber = queue.poll();
            problemSolvingOrder.add(problemNumber);

            List<Integer> nextProblems = this.graph.getOrDefault(problemNumber, new ArrayList<>());

            for (Integer nextProblem : nextProblems) {
                this.inDegreeCount[nextProblem]--;

                if (this.inDegreeCount[nextProblem] == 0) {
                    queue.offer(nextProblem);
                }
            }
        }

        return problemSolvingOrder;
    }

    private Queue<Integer> createQueueWithZeroInDegreeProblems() {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i < this.inDegreeCount.length; i++) {
            if (this.inDegreeCount[i] == 0) {
                queue.offer(i);
            }
        }

        return queue;
    }
}

package baekjoon.yj.graph.p_1753;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/1753
 * 최단경로 (방향 그래프에서 최단 경로 구하기)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertexCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();
        int startVertex = scanner.nextInt();

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < vertexCount + 1; i++) {
            graph.add(new ArrayList<>());
        }

        while (edgeCount-- > 0) {
            int fromVertex = scanner.nextInt();
            int toVertex = scanner.nextInt();
            int weight = scanner.nextInt();

            graph.get(fromVertex).add(new Pair(toVertex, weight));
        }

        ShortestPath shortestPath = new ShortestPath(graph);
        int[] distances = shortestPath.getShortestPathsFrom(startVertex);

        for (int i = 1; i <= vertexCount; i++) {
            int distance = distances[i];
            System.out.println(distance == Integer.MAX_VALUE ? "INF" : distance);
        }
    }
}

class ShortestPath {
    private List<List<Pair>> graph;
    private int[] distances;

    ShortestPath(List<List<Pair>> graph) {
        this.graph = graph;
        this.distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
    }

    public int[] getShortestPathsFrom(int start) {
        findShortestPath(start);
        return distances;
    }

    private void findShortestPath(int start) {
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        queue.offer(new Pair(start, 0));

        distances[start] = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (Pair nextPair : graph.get(pair.vertex)) {
                if (distances[nextPair.vertex] > distances[pair.vertex] + nextPair.distance) {
                    distances[nextPair.vertex] = distances[pair.vertex] + nextPair.distance;

                    queue.offer(new Pair(nextPair.vertex, distances[nextPair.vertex]));
                }
            }
        }
    }
}

class Pair {
    int vertex;
    int distance;

    Pair(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}

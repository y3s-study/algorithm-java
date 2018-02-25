package baekjoon.yj.tree.p_1167;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/1167
 * 트리의 지름
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodeCount = scanner.nextInt();

        List<List<Node>> tree = new ArrayList<>();

        for (int i = 0; i < nodeCount + 1; i++) {
            tree.add(new ArrayList<>());
        }

        while (nodeCount-- > 0) {
            int startNode = scanner.nextInt();
            int endNode = scanner.nextInt();
            while (endNode != -1) {
                int distance = scanner.nextInt();
                tree.get(startNode).add(Node.of(endNode, distance));

                endNode = scanner.nextInt();
            }
        }

        int diameter = new DiameterOfTree(tree).getDiameter();
        System.out.println(diameter);
    }
}

class DiameterOfTree {
    private List<List<Node>> tree;
    private Set<Integer> visitHistory;

    DiameterOfTree(List<List<Node>> tree) {
        this.tree = tree;
        this.visitHistory = new HashSet<>();
    }

    public int getDiameter() {
        Node firstFarthestNode = getFarthestNode(1);

        clearVisitHistory();

        Node secondFarthestNode = getFarthestNode(firstFarthestNode.number);

        return secondFarthestNode.distance;
    }

    private Node getFarthestNode(int startNode) {
        return getFarthestNode(startNode, 0);
    }

    private Node getFarthestNode(int startNode, int distance) {
        visit(startNode);

        List<Node> connectedNodeList = tree.get(startNode);

        Node farthestNode = Node.of(startNode, distance);

        for (Node connectedNode : connectedNodeList) {
            if (isNotVisited(connectedNode)) {
                Node node = getFarthestNode(connectedNode.number, distance + connectedNode.distance);

                if (node.distance > farthestNode.distance) {
                    farthestNode = Node.of(node.number, node.distance);
                }
            }
        }

        return farthestNode;
    }

    private void clearVisitHistory() {
        visitHistory.clear();
    }

    private void visit(int startNode) {
        visitHistory.add(startNode);
    }

    private boolean isNotVisited(Node node) {
        return !visitHistory.contains(node.number);
    }
}


class Node {
    int number;
    int distance;

    private Node(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }

    public static Node of(int number, int distance) {
        return new Node(number, distance);
    }
}

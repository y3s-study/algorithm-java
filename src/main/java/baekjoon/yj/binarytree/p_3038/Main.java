package baekjoon.yj.binarytree.p_3038;

import java.util.Scanner;

public class Main {

    private static Node root = new Node(1);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLevel = scanner.nextInt();

        buildTree(root, 0, maxLevel, (1 << maxLevel) - 1);
        preOrder(root);
    }

    private static void buildTree(Node node, int currentLevel, int maxLevel, int rootValue) {
        node.left = new Node(node.value);
        node.right = new Node(node.value + (1 << currentLevel));

        if (currentLevel < maxLevel - 2) {
            buildTree(node.left, currentLevel + 1, maxLevel, rootValue - (1 << currentLevel));
            buildTree(node.right, currentLevel + 1, maxLevel, rootValue - (1 << (currentLevel + 1)));
        }

        node.value = rootValue;
    }

    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}

class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
    }
}

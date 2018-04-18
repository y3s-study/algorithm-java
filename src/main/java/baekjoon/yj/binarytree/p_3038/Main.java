package baekjoon.yj.binarytree.p_3038;

import java.util.Scanner;

import static java.util.Optional.ofNullable;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int maxLevel = scanner.nextInt();
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree(maxLevel);
        System.out.println(completeBinaryTree.preOrder());
    }
}

class CompleteBinaryTree {
    private final int maxLevel;
    private final Node root;

    CompleteBinaryTree(int maxLevel) {
        this.maxLevel = maxLevel;
        this.root = buildTree(0,(1 << maxLevel) - 1, 1);
    }

    private Node buildTree(int currentLevel, int rootValue, int leafValue) {
        Node node = new Node(leafValue);

        if (currentLevel < maxLevel - 1) {
            node.left = buildTree(currentLevel + 1, rootValue - (1 << currentLevel), leafValue);
            node.right = buildTree(currentLevel + 1, rootValue - (1 << (currentLevel + 1)), leafValue + (1 << currentLevel));
            node.value = rootValue;
        }

        return node;
    }

    String preOrder() {
        return root.preOrder();
    }
}

class Node {
    Node left;
    Node right;
    int value;

    Node(int value) {
        this.value = value;
    }

    String preOrder() {
        return String.valueOf(value + " ")
                + ofNullable(left).map(Node::preOrder).orElse("")
                + ofNullable(right).map(Node::preOrder).orElse("");
    }
}

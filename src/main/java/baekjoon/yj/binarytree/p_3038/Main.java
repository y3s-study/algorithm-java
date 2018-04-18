package baekjoon.yj.binarytree.p_3038;

import java.util.Scanner;

import static java.util.Optional.ofNullable;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLevel = scanner.nextInt();

        Node root = buildTree(0, maxLevel, (1 << maxLevel) - 1, 1);
        System.out.println(root.preOrder());
    }

    private static Node buildTree(int currentLevel, int maxLevel, int rootValue, int leafValue) {
        Node node = new Node(leafValue);

        if (currentLevel < maxLevel - 1) {
            node.left = buildTree(currentLevel + 1, maxLevel, rootValue - (1 << currentLevel), leafValue);
            node.right = buildTree(currentLevel + 1, maxLevel, rootValue - (1 << (currentLevel + 1)), leafValue + (1 << currentLevel));
            node.value = rootValue;
        }

        return node;
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

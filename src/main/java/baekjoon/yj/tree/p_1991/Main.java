package baekjoon.yj.tree.p_1991;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1991
 * 트리 순회
 */
public class Main {
    public static void main(String[] args) {
        Tree tree = Tree.createWithRootNode(Node.of('A'));

        Scanner scanner = new Scanner(System.in);
        int nodeCount = Integer.parseInt(scanner.nextLine());

        while (nodeCount-- > 0) {
            char[] chars = scanner.nextLine().replaceAll(" ", "").toCharArray();
            tree.addNode(chars[0], chars[1], chars[2]);
        }

        System.out.printf("%s\n%s\n%s\n", tree.preOrder(), tree.inOrder(), tree.postOrder());
    }
}

class Tree {
    private Node root;
    private Map<Character, Node> index = new HashMap<>();

    private Tree(Node root) {
        this.root = root;
        index.put(root.data, root);
    }

    public static Tree createWithRootNode(Node root) {
        return new Tree(root);
    }

    public void addNode(char parent, char left, char right) {
        Node leftNode = left == '.' ? null : Node.of(left);
        Node rightNode = right == '.' ? null : Node.of(right);

        Node parentNode = index.get(parent);

        parentNode.setLeft(leftNode);
        parentNode.setRight(rightNode);

        index.put(left, leftNode);
        index.put(right, rightNode);
    }

    public String preOrder() {
        return preOrder(root);
    }

    public String inOrder() {
        return inOrder(root);
    }

    public String postOrder() {
        return postOrder(root);
    }

    private String preOrder(Node node) {
        return node == null ? "" : node.data + preOrder(node.left) + preOrder(node.right);
    }

    private String inOrder(Node node) {
        return node == null ? "" : inOrder(node.left) + node.data + inOrder(node.right);
    }

    private String postOrder(Node node) {
        return node == null ? "" : postOrder(node.left) + postOrder(node.right) + node.data;
    }
}

class Node {
    public Character data;
    public Node left;
    public Node right;

    public static Node of(Character data) {
        return new Node(data);
    }

    private Node(Character data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

package baekjoon.sj.tree.p_1991;

import java.util.Scanner;

//1991
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Node root = new Node();
		root.setRoot(root);
		while (n-- > 0) {
			char[] input = sc.nextLine().toCharArray();

			Node parent = new Node(input[0]);
			Node left = new Node(input[2]);
			Node right = new Node(input[4]);
			root.add(root, parent, left, right);
		}
		root.preorderTrave(root);
		System.out.println();
		root.inOrderTrave(root);
		System.out.println();
		root.postOrderTrave(root);
	}
}

class Node {
	private char value;
	private Node left;
	private Node right;

	Node() {

	}

	Node(char value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	void setRoot(Node root) {
		this.value = 'A';
		this.left = null;
		this.right = null;
	}

	void add(Node root, Node parent, Node left, Node right) {
		if (root.value == parent.value) {
			if (left.value != '.') {
				root.left = left;
			}

			if (right.value != '.') {
				root.right = right;
			}
			return;
		}

		if (root.left != null) {
			add(root.left, parent, left, right);
		}

		if (root.right != null) {
			add(root.right, parent, left, right);
		}
	}

	void preorderTrave(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.value);
		preorderTrave(node.left);
		preorderTrave(node.right);
	}

	void inOrderTrave(Node node) {
		if (node == null) {
			return;
		}
		inOrderTrave(node.left);
		System.out.print(node.value);
		inOrderTrave(node.right);
	}

	void postOrderTrave(Node node) {
		if (node == null) {
			return;
		}
		postOrderTrave(node.left);
		postOrderTrave(node.right);
		System.out.print(node.value);
	}
}

package baekjoon.sk.tree.p_1991;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();

		Tree t = new Tree();
		char data[];
		for (int i = 0; i < n; i++) {
			data = scanner.nextLine().replaceAll(" ", "").toCharArray();
			t.add(data[0], data[1], data[2]);
		}

		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);

	}

	static class Node {
		char data;
		Node left, right;

		public Node(char data) {
			this.data = data;
		}
	}

	static class Tree {
		Node root;

		public void add(char data, char leftData, char rightData) {
			if (root == null) {
				if (data != '.')
					root = new Node(data);
				if (leftData != '.')
					root.left = new Node(leftData);
				if (rightData != '.')
					root.right = new Node(rightData);
			}

			else
				search(root, data, leftData, rightData);
		}

		public void search(Node root, char data, char leftData, char rightData) {
			if (root == null)
				return;
			else if (root.data == data) {
				if (leftData != '.')
					root.left = new Node(leftData);
				if (rightData != '.')
					root.right = new Node(rightData);
			} else {
				search(root.left, data, leftData, rightData);
				search(root.right, data, leftData, rightData);
			}
		}

		public void preorder(Node root) {
			System.out.print(root.data);
			if (root.left != null)
				preorder(root.left);
			if (root.right != null)
				preorder(root.right);
		}

		public void inorder(Node root) {
			if (root.left != null)
				inorder(root.left);
			System.out.print(root.data);
			if (root.right != null)
				inorder(root.right);
		}

		public void postorder(Node root) {
			if (root.left != null)
				postorder(root.left);
			if (root.right != null)
				postorder(root.right);
			System.out.print(root.data);
		}
	}

}

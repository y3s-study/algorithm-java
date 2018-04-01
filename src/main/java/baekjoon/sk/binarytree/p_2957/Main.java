package baekjoon.sk.binarytree.p_2957;

import java.util.*;

public class Main {

	static int cnt = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Node root = new Node(0);

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			insert(sc.nextInt(), root);
			System.out.println(cnt);
		}

	}

	private static void insert(int x, Node n) {

		if (n.value == 0) {
			n.value = x;
		} else {
			cnt++;
			if (x < n.value) {

				if (n.left == null) {
					n.left = new Node(x);
				} else {
					insert(x, n.left);
				}

			} else if (x > n.value) {

				if (n.right == null) {
					n.right = new Node(x);
				} else {
					insert(x, n.right);
				}

			}

		}

	}

	static class Node {

		int value;

		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}

	}

}

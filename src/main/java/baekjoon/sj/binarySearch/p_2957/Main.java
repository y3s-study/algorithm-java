package baekjoon.sj.binarySearch.p_2957;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2957
 */
public class Main {
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Node root = null;
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			int input = sc.nextInt();
			root = insert(input, root);
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}

	private static Node insert(int number, Node node) {
		if (node == null) {
			return new Node(number);
		} else {
			cnt++;
			Node cur;
			if (number < node.data) {
				cur = insert(number, node.left);
				node.left = cur;
			} else {
				cur = insert(number, node.right);
				node.right = cur;
			}
			return node;
		}
	}
}

class Node {
	public int data;
	public Node left;
	public Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

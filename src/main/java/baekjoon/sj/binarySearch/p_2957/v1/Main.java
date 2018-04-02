package baekjoon.sj.binarySearch.p_2957.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2957
 */
public class Main {
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		Node root = null;
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
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

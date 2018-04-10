package baekjoon.sj.binarytree.p_3038;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/3038
 * 완전 이진 트리
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] tree = new int[(int) (Math.pow(2, n) + 1)];
		for (int i = 0; i < n; i++) {
			creatTree(tree, i);
			int k = 1;
			while (tree[k] != 0) {
				System.out.print(tree[k] + " ");
				k++;
			}
			System.out.println();
		}
	}

	private static void creatTree(int[] tree, int n) {
		if (n == 0) {
			tree[1] = 1;
			return;
		}
		int[] copyTree = new int[(int) Math.pow(2, n) + 1];
		System.arraycopy(tree, 0, copyTree, 0, copyTree.length);

		int k = 1;
		for (int i = 2; i < (int) Math.pow(2, n + 1); i++) {
			if ((int) Math.pow(2, k) == i) {
				k++;
			}
			System.out.println("n: " + n + " k: " + k);
			if ((int) Math.pow(2, k - 1) < i && i < (int) Math.pow(2, k)) {
				System.out.print("right ");
				tree[i] = copyTree[i / 2] * 2;
				if (n != k - 1) {
					System.out.print("enter ");
					tree[i]++;
				}
			} else {
				System.out.print("left ");
				tree[i] = copyTree[i / 2] * 2;
				if (n == k - 1) {
					System.out.print("enter ");
					tree[i]++;
				}
			}
			System.out.println("tree[" + i + "]: " + tree[i]);

		}

	}
}

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
		int[] tree = new int[(int) (Math.pow(2, n + 1) + 1)];
		for (int i = 0; i < n; i++) {
			creatTree(tree, i);
		}
		preOrder(tree, 1);
	}

	private static void preOrder(int[] tree, int index) {
		if (tree[index] == 0) {
			return;
		}
		System.out.print(tree[index] + " ");
		preOrder(tree, index * 2);
		preOrder(tree, index * 2 + 1);
	}

	private static void creatTree(int[] tree, int depth) {
		if (depth == 0) {
			tree[1] = 1;
			return;
		}
		int[] copyTree = new int[tree.length];
		System.arraycopy(tree, 0, copyTree, 0, copyTree.length);

		int tempDepth = 1;
		int copyIndex = 0;
		int startCopyIndex = (int) Math.pow(2, tempDepth - 1);
		int resetCopyIndex = (int) Math.pow(2, tempDepth) / 2;
		for (int i = 2; i < (int) Math.pow(2, depth + 1); i++) {
			if ((int) Math.pow(2, tempDepth) == i) {
				startCopyIndex = (int) Math.pow(2, tempDepth - 1);
				resetCopyIndex = (int) Math.pow(2, tempDepth) / 2;
				copyIndex = 0;
				tempDepth++;
			}
			if (copyIndex >= resetCopyIndex) {
				copyIndex = 0;
			}
			tree[i] = copyTree[startCopyIndex + copyIndex] * 2;
			copyIndex++;
		}

		tempDepth = 1;
		for (int i = 2; i < (int) Math.pow(2, depth + 1); i++) {
			if ((int) Math.pow(2, tempDepth) == i) {
				tempDepth++;
			}
			int startIndex = (int) Math.pow(2, tempDepth - 1) + ((int) Math.pow(2, tempDepth) - (int) Math.pow(2, tempDepth - 1)) / 2;
			int endIndex = (int) Math.pow(2, tempDepth);

			if (startIndex <= i && i < endIndex) {
				if (depth != tempDepth - 1) {
					tree[i]++;
				}
			} else {
				if (depth == tempDepth - 1) {
					tree[i]++;
				}
			}
		}
	}
}

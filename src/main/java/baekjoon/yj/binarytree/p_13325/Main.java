package baekjoon.yj.binarytree.p_13325;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13325
 * 이진 트리
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        List<Integer> edges = new ArrayList<>();
        edges.add(0);

        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
        while (tokenizer.hasMoreTokens()) {
            edges.add(Integer.parseInt(tokenizer.nextToken()));
        }

        System.out.println(getSum(edges));
    }

    static int getSum(List<Integer> edges) {
        updateEdge(edges, 0);

        int sum = 0;
        for (Integer edge : edges) {
            sum += edge;
        }
        return sum;
    }

    private static int updateEdge(List<Integer> edges, int index) {
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        if (leftChildIndex >= edges.size()) {
            return edges.get(index);
        }

        int leftMax = updateEdge(edges, leftChildIndex);
        int rightMax = updateEdge(edges, rightChildIndex);
        int max = Integer.max(leftMax, rightMax);

        edges.set(leftChildIndex, edges.get(leftChildIndex) + (max - leftMax));
        edges.set(rightChildIndex, edges.get(rightChildIndex) + (max - rightMax));

        return edges.get(index) + max;
    }
}

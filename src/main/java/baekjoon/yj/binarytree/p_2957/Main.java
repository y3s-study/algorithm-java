package baekjoon.yj.binarytree.p_2957;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * https://www.acmicpc.net/problem/2957
 * 이진 탐색 트리
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dataCount = scanner.nextInt();

        BinarySearchTree tree = new BinarySearchTree();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < dataCount; i++) {
            tree.insert(scanner.nextInt());
            result.append(tree.count()).append('\n');
        }

        System.out.println(result);
    }
}

class BinarySearchTree {
    private long count = 0;
    private TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    void insert(int data) {
        Integer higherDataHeight = Optional.ofNullable(treeMap.higherEntry(data)).map(Map.Entry::getValue).orElse(-1);
        Integer lowerDataHeight = Optional.ofNullable(treeMap.lowerEntry(data)).map(Map.Entry::getValue).orElse(-1);

        int height = Integer.max(higherDataHeight, lowerDataHeight) + 1;

        count += height;
        treeMap.put(data, height);
    }

    long count() {
        return this.count;
    }
}

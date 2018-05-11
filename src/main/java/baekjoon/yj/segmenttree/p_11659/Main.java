package baekjoon.yj.segmenttree.p_11659;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * https://www.acmicpc.net/problem/11659
 * 구간 합 구하기 4
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfData = scanner.nextInt();
        int testCase = scanner.nextInt();

        List<Integer> data = IntStream.generate(scanner::nextInt).limit(numberOfData).boxed().collect(toList());
        RangeSumCalculator rangeSumCalculator = new RangeSumCalculator(data);

        for (int i = 0; i < testCase; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            System.out.println(rangeSumCalculator.getSumOfRange(from, to));
        }
    }
}

class RangeSumCalculator {
    private List<Integer> data;
    private Node segmentTree;

    RangeSumCalculator(List<Integer> data) {
        this.data = data;
        this.segmentTree = buildSegmentTree(Range.of(0, data.size() - 1));
    }

    int getSumOfRange(int from, int to) {
        Range range = Range.of(from - 1, to - 1);
        return getSumOfRange(segmentTree, range);
    }

    private int getSumOfRange(Node node, Range range) {
        if (range.totallyOverlap(node.range)) {
            return node.data;
        }

        if (range.notOverlap(node.range)) {
            return 0;
        }

        return getSumOfRange(node.left, range) + getSumOfRange(node.right, range);
    }

    private Node buildSegmentTree(Range range) {
        if (range.isPoint()) {
            return Node.create()
                    .setData(data.get(range.from))
                    .setRange(range);
        }

        Node leftNode = buildSegmentTree(range.getLeftRange());
        Node rightNode = buildSegmentTree(range.getRightRange());

        return Node.create()
                .setData(leftNode.data + rightNode.data)
                .setRange(range)
                .setLeft(leftNode)
                .setRight(rightNode);
    }
}

class Node {
    int data;
    Range range;
    Node left;
    Node right;

    static Node create() {
        return new Node();
    }

    Node setData(int data) {
        this.data = data;
        return this;
    }

    Node setRange(Range range) {
        this.range = range;
        return this;
    }

    Node setLeft(Node node) {
        this.left = node;
        return this;
    }

    Node setRight(Node node) {
        this.right = node;
        return this;
    }
}

class Range {
    int from;
    int to;

    static Range of(int from, int to) {
        return new Range(from, to);
    }

    private Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    boolean totallyOverlap(Range range) {
        return (this.from <= range.from) && (this.to >= range.to);
    }

    boolean notOverlap(Range range) {
        return (this.from > range.to) || (this.to < range.from);
    }

    boolean isPoint() {
        return this.from == this.to;
    }

    Range getLeftRange() {
        return Range.of(this.from, getMiddle());
    }

    Range getRightRange() {
        return Range.of(getMiddle() + 1, this.to);
    }

    private int getMiddle() {
        return (this.from + this.to) / 2;
    }

}
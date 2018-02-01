package baekjoon.yj.dac.p_6549;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/6549
 * 히스토그램에서 가장 큰 직사각형
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int histogramCount = scanner.nextInt();

        while (histogramCount != 0) {
            int[] histograms = new int[histogramCount];

            for (int i = 0; i < histogramCount; i++) {
                histograms[i] = scanner.nextInt();
            }

            Histogram histogram = new Histogram(histograms);
            System.out.println(histogram.getLargestArea());

            histogramCount = scanner.nextInt();
        }
    }
}

class Histogram {
    private int[] histograms;
    private SegmentTree segmentTree;

    Histogram(int[] histograms) {
        this.histograms = histograms;
        this.segmentTree = new SegmentTree(histograms);
    }

    public long getLargestArea() {
        return getLargestArea(0, histograms.length - 1);
    }

    private long getLargestArea(int left, int right) {
        if (left == right) {
            return histograms[left];
        }

        int indexOfMin = segmentTree.minimumIndexInRange(left, right);

        long maxArea = (long) histograms[indexOfMin] * (right - left + 1);

        if (indexOfMin - 1 >= left) {
            long leftArea =  getLargestArea(left, indexOfMin - 1);
            maxArea = Math.max(maxArea, leftArea);
        }

        if (indexOfMin + 1 <= right) {
            long rightArea = getLargestArea(indexOfMin + 1, right);
            maxArea = Math.max(maxArea, rightArea);
        }

        return maxArea;
    }
}

class SegmentTree {
    private int[] histograms;
    private int[] tree;

    SegmentTree(int[] histograms) {
        this.histograms = histograms;
        int x = (int) Math.ceil(Math.log(100000) / Math.log(2));
        int treeSize = (int) Math.pow(2, x) * 2;
        this.tree = new int[treeSize];
        initialize(1, 0, histograms.length - 1);
    }

    private int initialize(int node, int left, int right) {
        if (left == right) {
            return tree[node] = left;
        }

        int middle = (left + right) / 2;

        int leftValue = initialize(node * 2, left, middle);
        int rightValue = initialize(node * 2 + 1, middle + 1, right);

        return tree[node] = histograms[leftValue] <= histograms[rightValue] ? leftValue : rightValue;
    }

    public int minimumIndexInRange(int leftIndex, int rightIndex) {
        return minimumIndexInRange(1, 0, histograms.length - 1, leftIndex, rightIndex);
    }

    private int minimumIndexInRange(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return -1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int middle = (start + end) / 2;

        int leftIndexOfMin = minimumIndexInRange(node * 2, start, middle, left, right);
        int rightIndexOfMin = minimumIndexInRange(node * 2 + 1, middle + 1, end, left, right);

        if (leftIndexOfMin == -1) {
            return rightIndexOfMin;
        }

        if (rightIndexOfMin == -1) {
            return leftIndexOfMin;
        }

        return histograms[leftIndexOfMin] <= histograms[rightIndexOfMin] ? leftIndexOfMin : rightIndexOfMin;
    }
}
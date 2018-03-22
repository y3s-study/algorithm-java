package baekjoon.yj.binarysearch;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/1920
 * 수 찾기
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int N = Integer.parseInt(scanner.nextLine());
        final StringTokenizer sourceTokens = new StringTokenizer(scanner.nextLine());
        int[] sources = IntStream.generate(() -> Integer.parseInt(sourceTokens.nextToken())).limit(N).sorted().toArray();

        final int M = Integer.parseInt(scanner.nextLine());
        final StringTokenizer targetTokens = new StringTokenizer(scanner.nextLine());
        int[] targets = IntStream.generate(() -> Integer.parseInt(targetTokens.nextToken())).limit(M).toArray();

        BinarySearch binarySearch = new BinarySearch();

        for (int target : targets) {
            System.out.println(binarySearch.contains(sources, target) ? 1 : 0);
        }
    }
}

class BinarySearch {
    public boolean contains(int[] source, int target) {
        return contains(source, target, 0, source.length - 1);
    }

    private boolean contains(int[] source, int target, int first, int end) {
        if (first > end) {
            return false;
        }

        int mid = (first + end) / 2;

        if (source[mid] == target) {
            return true;
        }

        if (source[mid] < target) {
            return contains(source, target, mid + 1, end);
        } else {
            return contains(source, target, first, mid - 1);
        }
    }
}

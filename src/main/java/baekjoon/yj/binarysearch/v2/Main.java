package baekjoon.yj.binarysearch.v2;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

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
        int first = 0;
        int end = source.length - 1;

        while (first <= end) {
            int mid = (first + end) / 2;

            if (source[mid] == target) {
                return true;
            }

            if (source[mid] < target) {
                first = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}

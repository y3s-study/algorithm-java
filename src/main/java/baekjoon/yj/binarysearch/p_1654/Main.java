package baekjoon.yj.binarysearch.p_1654;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1654
 * 랜선 자르기
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cableCount = scanner.nextInt();
        int requiredCableCount = scanner.nextInt();

        List<Long> cables = new ArrayList<>();
        long longestCable = 0L;

        for (int i = 0; i < cableCount; i++) {
            long currentCable = scanner.nextLong();
            cables.add(currentCable);
            longestCable = Long.max(longestCable, currentCable);
        }

        long result = new CableCutter().getMaxCuttingLength(cables, longestCable, requiredCableCount);
        System.out.println(result);
    }
}

class CableCutter {
    public long getMaxCuttingLength(List<Long> cables, long longestCable, long requiredCableCount) {
        long start = 0;
        long end = longestCable * 2;

        while (start < end) {
            long cuttingLength = (start + end) / 2;

            Long cableCount = cables.stream().map(cable -> cable / cuttingLength).reduce(0L, (c1, c2) -> c1 + c2);

            if (cableCount < requiredCableCount) {
                end = cuttingLength;
            } else {
                start = cuttingLength + 1;
            }
        }

        return start - 1;
    }
}

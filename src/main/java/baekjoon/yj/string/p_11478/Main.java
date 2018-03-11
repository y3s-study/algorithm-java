package baekjoon.yj.string.p_11478;

import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;

/**
 * https://www.acmicpc.net/problem/11478
 * 서로 다른 부분 문자열의 개수
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new SubstringCounter().getSubstringCount(s));
    }
}

class SubstringCounter {
    public long getSubstringCount(String s) {
        return IntStream.range(0, s.length())
                .mapToObj(i -> IntStream.rangeClosed(i + 1, s.length()).mapToObj(j -> s.substring(i, j)))
                .flatMap(identity())
                .distinct()
                .count();
    }
}
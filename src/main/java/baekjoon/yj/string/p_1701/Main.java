package baekjoon.yj.string.p_1701;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new SubstringHelper().getLongestSubstringLength(s));
    }
}

class SubstringHelper {
    public int getLongestSubstringLength(String s) {
        int i = 0;
        int maxLength = 0;

        while (i < s.length()) {
            maxLength = Integer.max(maxLength, getLongestLengthOfWhichSuffixAndPrefixAreEqual(s.substring(i++)));
        }

        return maxLength;
    }

    private int getLongestLengthOfWhichSuffixAndPrefixAreEqual(String s) {
        int[] pi = new int[s.length()];

        int i = 1;
        int j = 0;

        while (i < s.length()) {
            if (s.charAt(j) == s.charAt(i)) {
                pi[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = pi[j - 1];
                }
            }
        }

        return Arrays.stream(pi).max().orElse(0);
    }
}
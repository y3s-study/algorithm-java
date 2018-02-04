package baekjoon.yj.bruteforce.p_1038;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1038
 * 감소하는 수
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new DecreasingNumber().getNumber(new Scanner(System.in).nextInt()));
    }
}

class DecreasingNumber {
    public long getNumber(int n) {
        int count = -1;
        long number = 0;

        while (true) {
            if (isDecreasingNumber(number)) {
                count++;
            }

            if (count == n) {
                return number;
            }

            number = getNextNumber(number);

            if (number == -1) {
                return number;
            }
        }
    }

    private boolean isDecreasingNumber(long number) {
        String[] numbers = toStringArray(number);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (isNotDecreasing(numbers[i], numbers[i + 1])) {
                return false;
            }
        }

        return true;
    }

    private long getNextNumber(long number) {
        String[] numbers = toStringArray(number);
        boolean isDecreasingNumber = true;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (isNotDecreasing(numbers[i], numbers[i + 1])) {
                numbers[i] = String.valueOf(toInt(numbers[i]) + 1);
                numbers[i + 1] = "0";
                isDecreasingNumber = false;
            }
        }

        return isDecreasingNumber ? number + 1 : toLong(numbers);
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }

    private long toLong(String[] numbers) {
        try {
            return Long.parseLong(String.join("", numbers));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private String[] toStringArray(long number) {
        return String.valueOf(number).split("");
    }

    private boolean isNotDecreasing(String n1, String n2) {
        return toInt(n1) <= toInt(n2);
    }
}

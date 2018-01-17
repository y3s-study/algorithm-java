package baekjoon.yj.dynamic_programming_basic.p_1932;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1932
 * 숫자삼각형
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfTriangle = Integer.parseInt(scanner.nextLine());
        int[][] triangleArray = new int[sizeOfTriangle][sizeOfTriangle];

        // initialize triangle array
        for (int i = 0; i < sizeOfTriangle; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int j = 0; j < numbers.length; j++) {
                triangleArray[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        int maxValue = new TriangleOfNumber(triangleArray).maxValue();
        System.out.println(maxValue);
    }
}

class TriangleOfNumber {
    private int[][] triangleArray;
    private int[][] cache;

    public TriangleOfNumber(int[][] triangleArray) {
        this.triangleArray = triangleArray;
        this.cache = new int[triangleArray.length][triangleArray.length];
    }

    public int maxValue() {
        return maxValue(0, 0);
    }

    private int maxValue(int i, int j) {
        if (cache[i][j] > 0) {
            return cache[i][j];
        }

        if (i == triangleArray.length - 1) {
            return cache[i][j] = triangleArray[i][j];
        }

        int leftMaxValue = maxValue(i + 1, j);
        int rightMaxValue = maxValue(i + 1, j + 1);
        return cache[i][j] = triangleArray[i][j] + Integer.max(leftMaxValue, rightMaxValue);
    }
}
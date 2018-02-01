package baekjoon.sb.divideAndConquer.p_2447;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] arr = new char[N][N];

        for(int i = 0 ; i < N; i++) {
            arr[i] = new char[N];
            Arrays.fill(arr[i], ' ');
        }

        makeStar(arr, 0, 0, N);

        for(int i = 0; i < N; i++) {
            sb.append(arr[i]);
            if(i < N-1) {
                sb.append(System.getProperty("line.separator"));
            }
        }
        System.out.print(sb);
    }

    public static void makeStar(char[][] arr, int x, int y, int N) {

        if(N == 1) {
            arr[x][y] = '*';
        } else {
            N /= 3;
            for(int i = 0; i < 3; i++) {
                for( int j = 0; j < 3; j++) {
                    if(i == 1 && j == 1) {
                        continue;
                    } else {
                        makeStar(arr, x + (i * N), y + (j * N), N);
                    }
                }
            }
        }
    }
}

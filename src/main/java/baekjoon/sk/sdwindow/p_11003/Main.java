package baekjoon.sk.sdwindow.p_11003;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A[] = new int[5555555];
		int dq[] = new int[5555555];
		int front = 100;
		int rear = 100;

		StringBuilder sb = new StringBuilder("");
		
		int N, L;

		N = sc.nextInt();
		L = sc.nextInt();

		for (int i = 1; i <= N; ++i) {

			A[i] = sc.nextInt();

			if (front == rear)
				dq[--front] = A[i];
			else {
				while (front != rear && dq[rear - 1] > A[i])
					dq[--rear] = 0;
				dq[rear++] = A[i];
			}

			if (i > L && dq[front] == A[i - L])
				dq[front++] = 0;

			sb.append(dq[front] + " ");
		}
		
		System.out.println(sb.toString());

	}

}

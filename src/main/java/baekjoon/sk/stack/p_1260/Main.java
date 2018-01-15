package baekjoon.sk.stack.p_1260;

import java.util.*;

public class Main {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		// 정점의 수 저장
		int vertexCnt = scanner.nextInt();

		// 간선의 수 저장
		int edgeCnt = scanner.nextInt();

		// 시작 정점 저장
		int startVertex = scanner.nextInt();

		// 간선 정보 저장을 위한 행렬
		int[][] G = new int[vertexCnt][vertexCnt];
		int[][] G2 = new int[vertexCnt][vertexCnt];

		// 입력받은 간선 정보를 통해 인접행렬 리스트 초기화
		while (edgeCnt-- > 0) {
			int edgeA = scanner.nextInt();
			int edgeB = scanner.nextInt();
			try {
				G[edgeA - 1][edgeB - 1] = 1;
				G[edgeB - 1][edgeA - 1] = 1;

				G2[edgeA - 1][edgeB - 1] = 1;
				G2[edgeB - 1][edgeA - 1] = 1;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("정점의 입력값 범위를 벋어 났습니다.");
			}
			scanner.nextLine();
		}

		// 깊이 우선 탐색 결과 출력
		DFS(startVertex, G);

		System.out.println();

		// 너비 우선 탐색 결과 출력
		BFS(startVertex, G2);

	}

	public static void DFS(int startVertex, int[][] G) {
		// 시작 정점
		System.out.print(startVertex + " ");

		for (int i = 0; i < G[0].length; i++) {
			G[i][startVertex - 1] = 0;
		}

		for (int i = 0; i < G[0].length; i++) {
			if (G[startVertex - 1][i] == 1) {
				G[startVertex - 1][i] = 0;

				DFS(i + 1, G);
			}
		}
		return;
	}

	public static void BFS(int startVertex, int[][] G) {

		Queue<Integer> q = new LinkedList<Integer>();

		System.out.print(startVertex + " ");

		for (int i = 0; i < G[0].length; i++) {
			if (G[startVertex - 1][i] == 1) {
				G[startVertex - 1][i] = 0;
				G[i][startVertex - 1] = 0;

				for (int j = 0; j < G[0].length; j++) {
					G[j][i] = 0;
				}

				q.offer(i + 1);
			}
		}

		while (!q.isEmpty()) {

			System.out.print(q.peek() + " ");

			for (int i = 0; i < G[0].length; i++) {
				if (G[q.peek() - 1][i] == 1) {
					G[q.peek() - 1][i] = 0;
					G[i][q.peek() - 1] = 0;

					for (int j = 0; j < G[0].length; j++) {
						G[j][i] = 0;
					}
					q.offer(i + 1);
				}
			}

			q.poll();

		}

		return;
	}

}

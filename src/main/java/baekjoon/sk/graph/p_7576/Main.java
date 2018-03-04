package baekjoon.sk.graph.p_7576;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] map = new int[N][M];
		List<int[]> startPositions = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					startPositions.add(new int[] { i, j });
			}
		}
		if (startPositions.size() == N * M)
			System.out.print(0);
		else if (startPositions.size() == 0)
			System.out.println(-1);
		else
			System.out.print(bfs(startPositions, map, M, N));
	}

	public static int bfs(List<int[]> startPositions, int[][] map, int M, int N) {
		int[][] dist = new int[N][M];
		int day = 0;
		List<Queue<int[]>> qList = new ArrayList<Queue<int[]>>();
		for (int i = 0; i < startPositions.size(); i++) {
			Queue<int[]> q = new LinkedList<>();
			q.offer(startPositions.get(i));
			qList.add(q);
		}
		int[][] dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		while (!qList.isEmpty()) {
			for (int i = 0; i < qList.size(); i++) {
				Queue<int[]> q = qList.get(i);
				if (q.isEmpty()) {
					qList.remove(i);
					i--;
				} else {
					int nowDist = dist[q.peek()[0]][q.peek()[1]];
					while (true) {
						if (q.peek() == null
								|| nowDist != dist[q.peek()[0]][q.peek()[1]])
							break;
						int[] nowPos = q.poll();
						for (int j = 0; j < dir.length; j++) {
							int[] nextPos = new int[] { nowPos[0] + dir[j][0],
									nowPos[1] + dir[j][1] };
							if (0 <= nextPos[0] && nextPos[0] <= N - 1
									&& 0 <= nextPos[1] && nextPos[1] <= M - 1
									&& map[nextPos[0]][nextPos[1]] == 0) {
								q.offer(nextPos);
								map[nextPos[0]][nextPos[1]] = 1;
								dist[nextPos[0]][nextPos[1]] = dist[nowPos[0]][nowPos[1]] + 1;
								if (day < dist[nextPos[0]][nextPos[1]])
									day = dist[nextPos[0]][nextPos[1]];
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					day = -1;
					break;
				}
			}
		}
		return day;
	}
}

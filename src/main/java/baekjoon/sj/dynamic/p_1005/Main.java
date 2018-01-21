package baekjoon.sj.dynamic.p_1005;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1005
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			int buildingCnt = sc.nextInt();
			int buildingRuleCnt = sc.nextInt();
			int[] buildTime = new int[buildingCnt + 1];
			int[][] connectedBuilding = new int[buildingCnt + 1][buildingCnt + 1];
			int[] indegree = new int[buildingCnt + 1];

			while (buildingCnt-- > 0) {
				buildTime[buildTime.length - buildingCnt - 1] = sc.nextInt();
			}

			while (buildingRuleCnt-- > 0) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				connectedBuilding[row][col] = 1;
				indegree[col]++;
			}
			int destination = sc.nextInt();
			// 0에서 부터 출발하기 위하여
			for (int i = 1; i < connectedBuilding[0].length; i++) {
				connectedBuilding[0][i] = 1;
				indegree[i]++;
			}

			System.out.println(findMiniumTime(0, 0, connectedBuilding, buildTime, destination, indegree));
		}
	}

	static int findMiniumTime(int startPosition, int startTime, int[][] connectedBuilding, int[] buildTime, int destination, int[] indegree) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(startPosition, startTime));
		int[] sum = new int[indegree.length];
		while (!queue.isEmpty()) {
			int position = queue.peek().getKey();
			int time = queue.poll().getValue();

			for (int j = 0; j < connectedBuilding[position].length; j++) {
				if (connectedBuilding[position][j] == 1) {
					if (sum[j] < time + buildTime[j]) {
						sum[j] = time + buildTime[j];
					}

					if (--indegree[j] == 0) {
						queue.add(new Pair(j, sum[j]));
						if (j == destination) {
							break;
						}
					}
				}
			}
		}
		return sum[destination];
	}
}

class Pair {
	private int key, value;

	Pair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return this.key;
	}

	public int getValue() {
		return this.value;
	}
}

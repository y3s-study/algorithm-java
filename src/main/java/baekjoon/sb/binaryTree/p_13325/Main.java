package baekjoon.sb.binaryTree.p_13325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int k = Integer.parseInt(in.readLine());
		int size = 1 << (k+1);
		
		int[] tree = new int[size]; // 간선의 가중치를 노드의 가중치로 변경한 트리
		
		String line[] = in.readLine().split(" ");
		for(int i = 2; i < size; i++) {
			tree[i] = Integer.parseInt(line[i-2]);
		}
		
		int[] path = new int[size]; // path[i] = i번째 노드부터 그 리프들까지 최장경로
		int[] sum = new int[size]; // sum[i] = i번째 노드부터 그 리프들까지 모든 경로를 최장경로로 바꿨을 때의 거리의 합
		for(int i = 1 << k; --i > 0;) {
			int left = i << 1;
			int right = left + 1;
			path[i] = Math.max(path[left] + tree[left], path[right] + tree[right]);
			sum[i] = sum[left] + sum[right] + (path[i] - path[left]) + (path[i] - path[right]);
		}
		
		out.write(sum[1]+"");
		out.close();
		in.close();
	}

}

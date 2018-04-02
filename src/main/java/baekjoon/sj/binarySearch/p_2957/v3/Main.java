package baekjoon.sj.binarySearch.p_2957.v3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm.put(0, -1);
		tm.put(300001, -1);
		int cnt = 0;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int lessKey = tm.lowerKey(input);
			int greaterKey = tm.higherKey(input);
			int value = Integer.max(tm.get(lessKey), tm.get(greaterKey)) + 1;
			tm.put(input, value);
			cnt += value;
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}
}

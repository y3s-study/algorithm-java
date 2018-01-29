package baekjoon.sk.dac.p_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] video;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		char[] low = null;
		video = new int[N][N];
		sb = new StringBuffer();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			low = st.nextToken().toCharArray();
			for (int j = 0; j < N; j++) {
				video[i][j] = Integer.parseInt(low[j] + "");
			}
		}
		compression(0, 0, video.length);

		System.out.println(sb.toString());

	}

	public static void compression(int X, int Y, int size) {
		int temp = video[X][Y];
		boolean isSame = true;

		for (int i = X; (i < X + size) && isSame; i++) {
			for (int j = Y; (j < Y + size) && isSame; j++) {
				if (temp != video[i][j])
					isSame = false;
			}
		}
		if (isSame)
			sb.append(temp);
		else {
			sb.append("(");
			compression(X, Y, size / 2);
			compression(X, Y + size / 2, size / 2);
			compression(X + size / 2, Y, size / 2);
			compression(X + size / 2, Y + size / 2, size / 2);
			sb.append(")");
		}

	}

}

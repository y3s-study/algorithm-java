package baekjoon.sk.dac.p_6549;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));

		String line[];
		int i, n, arr[];
		StringBuilder res = new StringBuilder();
		SegmentTree segmentTree;

		while ((line = in.readLine().split(" ")).length > 1) {
			arr = new int[n = Integer.parseInt(line[0])];
			for (i = 1; i <= n; i++)
				arr[i - 1] = Integer.parseInt(line[i]);

			segmentTree = new SegmentTree(arr);

			res.append(segmentTree.getMaxWidth(0, n - 1) + "\n");

		}

		out.write(res.toString());
		out.close();
		in.close();

	}
	
	public static class SegmentTree {

		private int n, arr[], rangeMinIndex[], INF = 0x7fffffff;

		public SegmentTree(int arr[]) {
			n = arr.length;
			this.arr = arr.clone();
			rangeMinIndex = new int[n << 2];

			init(0, n - 1, 1);
		}

		private int init(int left, int right, int node) {
			if (left == right)
				return rangeMinIndex[node] = left;

			int mid = (left + right) >>> 1;
			int leftMinIndex = init(left, mid, node << 1);
			int rightMinIndex = init(mid + 1, right, (node << 1) + 1);

			return rangeMinIndex[node] = arr[leftMinIndex] < arr[rightMinIndex] ? leftMinIndex
					: rightMinIndex;

		}

		private int query(int left, int right, int node, int nodeLeft,
				int nodeRight) {

			if (nodeRight < left || right < nodeLeft)
				return INF;

			if (left <= nodeLeft && nodeRight <= right)
				return rangeMinIndex[node];

			int mid = (nodeLeft + nodeRight) >>> 1;
			int leftMinIndex = query(left, right, node << 1, nodeLeft, mid);
			int rightMinIndex = query(left, right, (node << 1) + 1, mid + 1,
					nodeRight);

			if (leftMinIndex == INF)
				return rightMinIndex;
			else if (rightMinIndex == INF)
				return leftMinIndex;
			else
				return arr[leftMinIndex] < arr[rightMinIndex] ? leftMinIndex
						: rightMinIndex;

		}

		public long getMaxWidth(int left, int right) {

			long maxWidth, tmpWidth;
			int minIndex = query(left, right, 1, 0, n - 1);

			maxWidth = (long) (right - left + 1) * (long) arr[minIndex];

			if (left <= minIndex - 1) {
				tmpWidth = getMaxWidth(left, minIndex - 1);
				maxWidth = Math.max(maxWidth, tmpWidth);
			}

			if (minIndex + 1 <= right) {
				tmpWidth = getMaxWidth(minIndex + 1, right);
				maxWidth = Math.max(maxWidth, tmpWidth);
			}

			return maxWidth;

		}

	}

}

/*
 * import java.util.*;
 * 
 * public class Main {
 * 
 * public static void main(String[] args) {
 * 
 * Scanner scanner = new Scanner(System.in);
 * 
 * while (true) {
 * 
 * String[] line = scanner.nextLine().split(" ");
 * 
 * if (line[0].equals("0")) break;
 * 
 * long max = 0;
 * 
 * ArrayList<String> input = new ArrayList<String>();
 * 
 * for (String tmp : line) { input.add(tmp); }
 * 
 * ArrayList<String> dataset = new ArrayList<String>( new
 * HashSet<String>(input));
 * 
 * Collections.sort(dataset);
 * 
 * long tmp = 0;
 * 
 * for (int i = 0; i < dataset.size(); i++) {
 * 
 * tmp = countSeq(Long.parseLong(dataset.get(i)), line);
 * 
 * if (max < tmp) { max = tmp; } }
 * 
 * System.out.println(max);
 * 
 * }
 * 
 * }
 * 
 * public static long countSeq(long value, String[] line) {
 * 
 * long result = 0;
 * 
 * boolean seq = false; int seqCount = 1;
 * 
 * for (int i = 1; i < Long.parseLong(line[0]) + 1; i++) {
 * 
 * if (i == 1) { seq = false; } else if (Long.parseLong(line[i]) >= value &&
 * Long.parseLong(line[i - 1]) >= value) { seq = true; } else { seq = false; }
 * 
 * if (seq) { seqCount++; if (result < value * seqCount) result = value *
 * seqCount; } else { seqCount = 1; }
 * 
 * }
 * 
 * return result; }
 * 
 * }
 */
package baekjoon.sb.segmentTree.p_11659;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 수의 개수
		int M = sc.nextInt();	// 합을 구해야 하는 횟수
		int[] arr = IntStream.generate(sc::nextInt).limit(N).toArray();
		
		SegmentTree segmentTree = new SegmentTree(N, arr);
		
		for(int i = 0; i < M; i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			System.out.println(segmentTree.getSum(1, 0, N-1, left-1, right-1));
		}

	}

}

class SegmentTree{
	int N;
	private int[] arr;
	private int[] tree;
	
	public SegmentTree(int N, int[] arr) {
		this.N = N;
		this.arr = arr;
		this.tree = new int[1 << ((int)Math.ceil(Math.log(N)/Math.log(2)) + 1)];
		init(1, 0, N-1);
	}
	
	public int init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}
	
	public int getSum(int node, int start, int end, int left, int right) {
		if(left > end || right < start) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		return getSum(node*2, start, mid, left, right) + getSum(node*2+1, mid+1, end, left, right);
	}
}
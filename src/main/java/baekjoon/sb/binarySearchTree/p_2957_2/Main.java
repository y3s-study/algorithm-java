package baekjoon.sb.binarySearchTree.p_2957_2;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수열의 크기
		int[] arr = IntStream.generate(sc::nextInt).limit(N).toArray();
		
		TreeMap<Integer, Long> treeMap = new TreeMap<>();
		treeMap.put(0, (long) -1);
		treeMap.put(300001,  (long) -1);
		
		long cnt = 0;
		for(int i = 0; i < N; i++) {
			long h = 0;
			Entry<Integer, Long> lower = treeMap.lowerEntry(arr[i]);
			Entry<Integer, Long> higher = treeMap.higherEntry(arr[i]);
			h = Long.max(lower.getValue(), higher.getValue()) + 1;
			
			treeMap.put(arr[i], h);
			cnt += h;
			System.out.println(cnt);
		}
	}
}


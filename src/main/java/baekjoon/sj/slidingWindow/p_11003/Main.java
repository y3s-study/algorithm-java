package baekjoon.sj.slidingWindow.p_11003;

import java.util.PriorityQueue;
import java.util.Scanner;

//11003
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[] arr = new int[N];

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++){
			arr[i] = sc.nextInt();
			if(i >= L){
				pq.remove(arr[i-L]);
			}
			pq.add(arr[i]);
			sb.append(pq.peek()+"\n");
		}
		System.out.println(sb.toString());
	}
}

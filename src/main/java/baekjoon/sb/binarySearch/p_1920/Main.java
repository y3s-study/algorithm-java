package baekjoon.sb.binarySearch.p_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		
		Set<Integer> set = new HashSet<>();
		int N = Integer.parseInt(tokenizer.nextToken());
		tokenizer = new StringTokenizer(reader.readLine());
		
		for(int i = 0; i < N; i++) {
			set.add(Integer.valueOf(tokenizer.nextToken()));
		}
		
		tokenizer = new StringTokenizer(reader.readLine());
		int M = Integer.parseInt(tokenizer.nextToken());
		
		tokenizer = new StringTokenizer(reader.readLine());
		
		for(int i = 0; i < M; i++) {
			if(set.contains(Integer.valueOf(tokenizer.nextToken()))) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

}

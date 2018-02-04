package baekjoon.sb.brute_force.p_2309;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = IntStream.generate(sc::nextInt).limit(9).toArray();
		
		int[] result = find(arr);
		
		Arrays.sort(result);
		for (int i : result) {
			System.out.println(i);
		}
	
	}
	
	public static int[] find(int[] arr) {
		Random random = new Random();
		boolean find = false;
		int[] result = new int[7];
		
		HashSet<Integer> hashSet = new HashSet<>(); 
		while(!find) {
			int sum = 0;
			hashSet.clear();
			for(int n = 0; n < 7; n++) {
				int i = random.nextInt(9);
				while(hashSet.contains(i)) {
					i = random.nextInt(9);
				}
				hashSet.add(i);
				sum += arr[i];
				result[n] = arr[i];
				if(n == 6) {
					if(sum == 100) {
						find = true;
					}
				}
			}
		}
		
		return result;
	}

}

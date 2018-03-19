package baekjoon.sk.substring.p_1701;

/*****************************
 
 KPM 변형 문제
 
 접두사, 접미사를 이용한 방법
 
 비교 방식이 진짜 접두사의 경우 앞에서 접미사의 경우 뒤에서
 
 비교하는게 아니라, 문자열과 찾고자 하는 패턴이 있고
 
 이 패턴이 한칸씩 옆으로 디동하면서 탐색
 
 중간 점프 과정에 의해서 O(N+M)의 탐색 수행

아래 문제에서 찾고자 하는 패턴은 실제 검색한 패턴이 아니라

자기 자신이다.
 
******************************/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String p = sc.nextLine();

		int i, n = p.length(), max = 0;

		for (i = 0; i < n; i++)
			max = Math.max(max, getMax(p.substring(i, n)));

		System.out.println(max);

		sc.close();

	}

	private static int getMax(String p) {

		int i, j = 0, n = p.length(), max = 0;

		int fail[] = new int[n];

		for (i = 1; i < n; i++) {

			// 중간 점프를 위한 로직
			while (j > 0 && p.charAt(i) != p.charAt(j))
				j = fail[j - 1];
			
			// 일치할 경우, 일치 여부를 증가 시키고 더 큰걸 취합
			if (p.charAt(i) == p.charAt(j))
				max = Math.max(max, fail[i] = ++j);
			
		}

		return max;

	}

}

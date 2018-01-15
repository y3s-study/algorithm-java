package baekjoon.sb.deque.p_5430;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int t=0; t < T; t++) {
			String p = sc.nextLine();

			sc.nextLine();
			String input = sc.nextLine();
			String[] str = input.substring(1, input.length()-1).split(",");

			LinkedList<Integer> q = new LinkedList<>();

			for(String s : str) {
				if(s != null && !s.equals("")) {
					q.addLast(Integer.parseInt(s));
				}
			}

		
			boolean reverse = false;
			try {
				for(int i=0; i < p.length(); i++) {
					if(p.charAt(i) == 'R') {
						if(i + 1 < p.length() && p.charAt(i+1) == 'R' ) {
							i++;
							continue;
						}
						reverse = !reverse;

					} else if(p.charAt(i) == 'D') {
						if(reverse == false) {
							q.removeFirst();
						} else {
							q.removeLast();
						}
					}
				}
			} catch(NoSuchElementException e) {
				System.out.println("error");
				continue;
			}
			
			print(q, reverse);
		}
	}
	
	public static void print(LinkedList<Integer> q, boolean reverse) {
		Iterator<Integer> iterator;
		if(reverse == false) {
			iterator = q.iterator();
		} else {
			iterator = q.descendingIterator();
		}
		System.out.print("[");
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
			if(iterator.hasNext()) {
				System.out.print(",");
			}
		}
		
		System.out.print("]");
		System.out.println("");
	}

}

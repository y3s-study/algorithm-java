package baekjoon.sj.bruteForce.p_7568;

import java.util.ArrayList;
import java.util.Scanner;

//7568
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalPersone = sc.nextInt();
		ArrayList<Pair> list = new ArrayList<>();

		while (totalPersone-- > 0) {
			int weight = sc.nextInt();
			int height = sc.nextInt();
			list.add(new Pair(weight, height));
		}
		for (int i = 0; i < list.size(); i++) {
			int myNumber = findGrade(list, i);
			System.out.print(myNumber+" ");
		}
	}

	static int findGrade(ArrayList<Pair> list, int position) {
		int weight = list.get(position).getWeight();
		int height = list.get(position).getHeight();
		int myNumber = 1;

		for (int i = 0; i < list.size(); i++) {
			int currentWeight = list.get(i).getWeight();
			int currentHeight = list.get(i).getHeight();
			if (currentWeight == weight && currentHeight == height) {
				continue;
			}
			if(currentWeight > weight && currentHeight > height){
				myNumber++;
			}
		}

		return myNumber;
	}
}

class Pair {
	private int weight;
	private int height;

	Pair(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}

}

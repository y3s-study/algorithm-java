package baekjoon.sb.divideAndConquer.p_2261;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Point> points = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			points.add(new Point(sc.nextInt(), sc.nextInt()));
		}

		comparePointX(points);
		System.out.println(closestPair(points, N, 0));
	}

	public static long closestPair(List<Point> points, int n, int index) {
		if(n==2) {
			return dist(points.get(index), points.get(index+1));
		}

		if(n==3) {
			return Math.min(Math.min(dist(points.get(index), points.get(index+1)), dist(points.get(index+1), points.get(index+2))), dist(points.get(index), points.get(index+2)));
		}

		int line = ((int)(points.get(index+n/2-1).getX() + points.get(index+n/2).getX())) / 2;
		long d = Math.min(closestPair(points, n/2, index), closestPair(points, n-n/2, index + n/2));
		
		List<Point> mid = new ArrayList<>();
		
		for(int i = index; i < index+n; i++) {
			int t = line - (int) points.get(i).getX();
			if(t*t <= d) {
				mid.add(points.get(i));
			}
		}

		comparePointY(mid);

		for(int i = 0; i < mid.size(); i++) {
			for(int j = i+1; j < mid.size() && j <= i+6; j++) {
				d = Math.min(d, dist(mid.get(i), mid.get(j)));
			}
		}
		return d;
	}

	public static long dist(Point p1, Point p2) {
		return (long) (Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}

	public static void comparePointX(List<Point> points) {
		Collections.sort(points, new Comparator<Point>() {	
			public int compare(Point p1, Point p2) {
				if(p1.getX() > p2.getX()) {
					return 1;
				} else if (p1.getX() < p2.getX()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

	public static void comparePointY(List<Point> points) {
		Collections.sort(points, new Comparator<Point>() {	
			public int compare(Point p1, Point p2) {
				if(p1.getY() > p2.getY()) {
					return 1;
				} else if (p1.getY() < p2.getY()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}
}
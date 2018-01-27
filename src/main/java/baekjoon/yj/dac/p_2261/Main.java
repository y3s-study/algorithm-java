package baekjoon.yj.dac.p_2261;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2261
 * 가장 가까운 두 점
 */
public class Main {
    public static void main(String[] args) {
        ClosestTwoPoints closestTwoPoints = new ClosestTwoPoints();

        Scanner scanner = new Scanner(System.in);
        int pointCount = scanner.nextInt();

        while (pointCount-- > 0) {
            closestTwoPoints.addPoint(scanner.nextInt(), scanner.nextInt());
        }

        System.out.println(closestTwoPoints.closestDistance());
    }
}

class ClosestTwoPoints {
    private List<Point> points = new ArrayList<>();

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public long closestDistance() {
        points.sort(Comparator.comparingInt(Point::x));
        return closestDistance(this.points);
    }

    private long closestDistance(List<Point> subset) {
        // base
        if (subset.size() == 2) {
            return subset.get(0).distanceWith(subset.get(1));
        }

        if (subset.size() == 3) {
            long distance1 = subset.get(0).distanceWith(subset.get(1));
            long distance2 = subset.get(1).distanceWith(subset.get(2));
            long distance3 = subset.get(2).distanceWith(subset.get(0));
            return Math.min(distance1, Math.min(distance2, distance3));
        }

        // divide
        int middleIndex = subset.size() / 2;
        int middleXLine = (subset.get(middleIndex - 1).x() + subset.get(middleIndex).x()) / 2;
        long leftMinDistance = closestDistance(subset.subList(0, middleIndex));
        long rightMinDistance = closestDistance(subset.subList(middleIndex, subset.size()));

        // conquer
        long minDistance = Math.min(leftMinDistance, rightMinDistance);
        List<Point> middleSubset = getMiddleSubset(subset, middleXLine, minDistance);
        minDistance = Math.min(minDistance, getMinDistance(middleSubset));

        return minDistance;
    }

    private long getMinDistance(List<Point> middleSubset) {
        middleSubset.sort(Comparator.comparingInt(Point::y));

        long minDistance = Long.MAX_VALUE;

        for (int i = 0; i < middleSubset.size(); i++) {
            for (int j = i + 1; j < middleSubset.size(); j++) {
                Point currentPoint = middleSubset.get(i);
                Point comparedPoint = middleSubset.get(j);

                minDistance = Math.min(currentPoint.distanceWith(comparedPoint), minDistance);

                if (currentPoint.distanceY(comparedPoint) >= minDistance) {
                    break;
                }
            }
        }

        return minDistance;
    }

    private List<Point> getMiddleSubset(List<Point> subset, int middleLine, long minDistance) {
        List<Point> middleSubset = new ArrayList<>();

        for (Point point : subset) {
            int distance = middleLine - point.x();
            if (distance * distance <= minDistance) {
                middleSubset.add(point);
            }
        }

        return middleSubset;
    }
}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public long distanceWith(Point comparedPoint) {
        return distanceX(comparedPoint) + distanceY(comparedPoint);
    }

    public long distanceY(Point comparedPoint) {
        int distanceY = comparedPoint.y - this.y;
        return distanceY * distanceY;
    }

    private long distanceX(Point comparedPoint) {
        int distanceX = comparedPoint.x - this.x;
        return distanceX * distanceX;
    }
}


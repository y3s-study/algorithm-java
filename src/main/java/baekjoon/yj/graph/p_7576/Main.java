package baekjoon.yj.graph.p_7576;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/7576
 * 토마토
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int horizontalSize = scanner.nextInt();
        int verticalSize = scanner.nextInt();

        int data[][] = new int[verticalSize][horizontalSize];

        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                data[i][j] = scanner.nextInt();
            }
        }

        TomatoWarehouse tomatoWarehouse = TomatoWarehouse.of(horizontalSize, verticalSize, data);
        System.out.println(tomatoWarehouse.getMinimumRipeDate());
    }
}

class TomatoWarehouse {
    private int verticalSize;
    private int horizontalSize;
    private Tomato[][] tomatoMap;

    public static TomatoWarehouse of(int horizontalSize, int verticalSize, int[][] data) {
        Tomato[][] tomatoMap = new Tomato[verticalSize][horizontalSize];

        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                tomatoMap[i][j] = Tomato.of(i, j, data[i][j]);
            }
        }

        return new TomatoWarehouse(horizontalSize, verticalSize, tomatoMap);
    }

    private TomatoWarehouse(int horizontalSize, int verticalSize, Tomato[][] tomatoMap) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        this.tomatoMap = tomatoMap;
    }

    public int getMinimumRipeDate() {
        List<Tomato> ripeTomatoes = getRipeTomatoes();

        for (Tomato ripeTomato : ripeTomatoes) {
            ripenAllPossibleTomatoes(ripeTomato);
        }

        return findMaxRipeDate();
    }

    private int findMaxRipeDate() {
        int maximumDate = 0;

        for (Tomato[] row : tomatoMap) {
            for (Tomato tomato : row) {
                if (tomato != null && tomato.isRipe()) {
                    maximumDate = Math.max(maximumDate, tomato.getRipenedDate());
                } else if (tomato != null && tomato.isUnripe()) {
                    return -1;
                }
            }
        }

        return maximumDate;
    }

    private void ripenAllPossibleTomatoes(Tomato ripeTomato) {
        Queue<Tomato> queue = new LinkedList<>();
        queue.offer(ripeTomato);

        while (!queue.isEmpty()) {
            Tomato currentTomato = queue.poll();
            Point point = currentTomato.point();

            List<Point> aroundPoints = Arrays.asList(point.up(), point.down(), point.left(), point.right());

            for (Point p : aroundPoints) {
                if (!isValidPoint(p)) {
                    continue;
                }

                Tomato tomato = tomatoMap[p.i()][p.j()];

                if (tomato != null) {
                    if (tomato.isUnripe()) {
                        tomato.ripen();
                        tomato.setRipenedDate(currentTomato.getRipenedDate() + 1);
                        queue.offer(tomato);
                    } else if (tomato.isRipe() && tomato.getRipenedDate() > currentTomato.getRipenedDate() + 1) {
                        tomato.setRipenedDate(currentTomato.getRipenedDate() + 1);
                        queue.offer(tomato);
                    }
                }
            }
        }
    }

    private boolean isValidPoint(Point p) {
        return p.i() >= 0 && p.i() <= this.verticalSize - 1 && p.j() >= 0 && p.j() <= this.horizontalSize - 1;
    }

    private List<Tomato> getRipeTomatoes() {
        List<Tomato> ripeTomatoes = new ArrayList<>();

        for (Tomato[] row : tomatoMap) {
            for (Tomato tomato : row) {
                if (tomato != null && tomato.isRipe()) {
                    ripeTomatoes.add(tomato);
                }
            }
        }

        return ripeTomatoes;
    }
}

class Tomato {
    private Point point;
    private boolean ripe;
    private int ripenedDate;

    private Tomato(Point point, boolean ripe) {
        this.point = point;
        this.ripe = ripe;
        this.ripenedDate = 0;
    }

    public static Tomato of(int i, int j, int data) {
        if (data == -1) {
            return null;
        }

        return new Tomato(Point.of(i, j), data == 1);
    }

    public boolean isRipe() {
        return this.ripe;
    }

    public boolean isUnripe() {
        return !isRipe();
    }

    public void ripen() {
        this.ripe = true;
    }

    public Point point() {
        return this.point;
    }

    public void setRipenedDate(int date) {
        this.ripenedDate = date;
    }

    public int getRipenedDate() {
        return this.ripenedDate;
    }
}

class Point {
    private int i;
    private int j;

    private Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static Point of(int i, int j) {
        return new Point(i, j);
    }

    public int i() {
        return i;
    }

    public int j() {
        return j;
    }

    public Point up() {
        return Point.of(i - 1, j);
    }

    public Point down() {
        return Point.of(i + 1, j);
    }

    public Point left() {
        return Point.of(i, j - 1);
    }

    public Point right() {
        return Point.of(i, j + 1);
    }
}


package baekjoon.yj.graph.p_2667;

import java.util.*;
import java.util.stream.Stream;

/**
 * https://www.acmicpc.net/problem/2667
 * 단지 번호 붙히기
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder map = new StringBuilder();

        while (n-- > 0) {
            map.append(scanner.nextLine()).append("\n");
        }

        NumberingComplex numberingComplex = NumberingComplex.createFromMap(map.toString());

        printResult(numberingComplex);
    }

    private static void printResult(NumberingComplex numberingComplex) {
        System.out.println(numberingComplex.complexCount());
        numberingComplex.houseCountList().forEach(System.out::println);
    }

}

class NumberingComplex {
    private int complexCount;
    private List<Integer> houseCountList;

    public static NumberingComplex createFromMap(String map) {
        ComplexMap complexMap = ComplexMap.from(map);
        List<Integer> houseCountList = getHouseCountList(complexMap);

        return new NumberingComplex(houseCountList.size(), houseCountList);
    }

    private static List<Integer> getHouseCountList(ComplexMap complexMap) {
        List<Integer> houseCountList = new ArrayList<>();

        for (int i = 0; i < complexMap.length(); i++) {
            for (int j = 0; j < complexMap.length(); j++) {
                Point point = Point.of(i, j);

                if (complexMap.getHouse(point).isPresentAndNotVisited()) {
                    int houseCount = getHouseCount(complexMap, point);
                    houseCountList.add(houseCount);
                }
            }
        }

        Collections.sort(houseCountList);
        return houseCountList;
    }

    private static int getHouseCount(ComplexMap complexMap, Point startPoint) {
        int maxIndex = complexMap.length() - 1;
        complexMap.getHouse(startPoint).visit();

        Stack<Point> stack = new Stack<>();
        stack.push(startPoint);

        int count = 0;

        while (!stack.isEmpty()) {
            Point point = stack.pop();

            Stream.of(point.up(), point.down(), point.left(), point.right())
                    .forEach(p -> {
                        if (isValidIndex(p, maxIndex)) {
                            House house = complexMap.getHouse(p);

                            if (house.isPresentAndNotVisited()) {
                                stack.push(p);
                                house.visit();
                            }
                        }
                    });

            count++;
        }

        return count;
    }

    private static boolean isValidIndex(Point point, int maxIndex) {
        return point.i() >= 0 && point.j() >= 0 && point.i() <= maxIndex && point.j() <= maxIndex;
    }

    private NumberingComplex(int complexCount, List<Integer> houseCountList) {
        this.complexCount = complexCount;
        this.houseCountList = houseCountList;
    }

    public int complexCount() {
        return complexCount;
    }

    public List<Integer> houseCountList() {
        return houseCountList;
    }
}

/**
 * House의 2차원 배열인 House[][] 클래스의 객체를 감싼(wrapping) ComplexMap 클래스
 * Point 객체를 통해 해당하는 위치의 집(House 객체)을 조회할 수 있다.
 */
class ComplexMap {
    private House[][] complexMapArray;

    private ComplexMap(House[][] complexMapArray) {
        this.complexMapArray = complexMapArray;
    }

    public static ComplexMap from(String map) {
        return new ComplexMap(createComplexMapArray(map));
    }

    private static House[][] createComplexMapArray(String map) {
        String[] lines = map.split("\n");

        House[][] complexMap = new House[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split("");
            House[] houseLine = new House[lines.length];

            for (int j = 0; j < lines.length; j++) {
                houseLine[j] = House.of(line[j]);
            }

            complexMap[i] = houseLine;
        }

        return complexMap;
    }

    public int length() {
        return this.complexMapArray.length;
    }

    public House getHouse(Point point) {
        return this.complexMapArray[point.i()][point.j()];
    }
}

/**
 * 집을 나타내는 House 클래스.
 * 집의 존재 여부와 방문 여부를 확인할 수 있다.
 */
class House {
    private final boolean present;
    private boolean visited;

    public static House of(String data) {
        return new House(data.equals("1"), false);
    }

    private House(boolean present, boolean visited) {
        this.present = present;
        this.visited = visited;
    }

    public void visit() {
        this.visited = true;
    }

    public boolean isPresentAndNotVisited() {
        return this.present && !this.visited;
    }
}

/**
 * 2차원 배열의 좌표를 나타내는 Point 클래스.
 * 위, 아래, 왼쪽, 오른쪽 Point를 구할 수 있다.
 */
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

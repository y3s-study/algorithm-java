package baekjoon.yj.dynamic_programming.p_2342;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * https://www.acmicpc.net/problem/2342
 * Dance Dance Revolution
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(input, " ");

        List<Integer> positions = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int point = Integer.parseInt(st.nextToken());
            if (point == 0) break;
            positions.add(point);
        }

        DDR ddr = new DDR(positions);
        System.out.println(ddr.getTotalPower());
    }
}

class DDR {
    private int[][] cache;
    private List<Position> positions;

    DDR(List<Integer> positions) {
        this.positions = positions.stream().map(Position::of).collect(toList());
        this.cache = new int[13][100_000];
    }

    int getTotalPower() {
        return getMinimumPower(Position.CENTER, Position.CENTER, 0);
    }

    private int getMinimumPower(Position leftFoot, Position rightFoot, int index) {
        if (index == positions.size()) {
            return 0;
        }

        if (cache[leftFoot.point * rightFoot.point][index] != 0) {
            return cache[leftFoot.point * rightFoot.point][index];
        }

        final Position position = positions.get(index);
        final int nextIndex = index + 1;
        final int min;

        if (position.equals(leftFoot)) {
            min = leftFoot.powerToMove(position) + getMinimumPower(position, rightFoot, nextIndex);
        } else if (position.equals(rightFoot)) {
            min = rightFoot.powerToMove(position) + getMinimumPower(leftFoot, position, nextIndex);
        } else {
            final int leftEnergy = leftFoot.powerToMove(position) + getMinimumPower(position, rightFoot, nextIndex);
            final int rightEnergy = rightFoot.powerToMove(position) + getMinimumPower(leftFoot, position, nextIndex);
            min = Integer.min(leftEnergy, rightEnergy);
        }

        return cache[leftFoot.point * rightFoot.point][index] = min;
    }
}

enum Position {
    CENTER(0) {
        @Override
        public int powerToMove(Position position) {
            return 2;
        }
    },
    TOP(1) {
        @Override
        public int powerToMove(Position position) {
            switch (position) {
                case TOP:
                    return 1;
                case LEFT:
                case RIGHT:
                    return 3;
                case BOTTOM:
                    return 4;
                default:
                    return 0;
            }
        }
    },
    LEFT(2) {
        @Override
        public int powerToMove(Position position) {
            switch (position) {
                case LEFT:
                    return 1;
                case TOP:
                case BOTTOM:
                    return 3;
                case RIGHT:
                    return 4;
                default:
                    return 0;
            }
        }
    },
    BOTTOM(3) {
        @Override
        public int powerToMove(Position position) {
            switch (position) {
                case BOTTOM:
                    return 1;
                case LEFT:
                case RIGHT:
                    return 3;
                case TOP:
                    return 4;
                default:
                    return 0;
            }
        }
    },
    RIGHT(4) {
        @Override
        public int powerToMove(Position position) {
            switch (position) {
                case RIGHT:
                    return 1;
                case TOP:
                case BOTTOM:
                    return 3;
                case LEFT:
                    return 4;
                default:
                    return 0;
            }
        }
    };

    private static final Map<Integer, Position> INDEX = Arrays.stream(values())
            .collect(toMap(position -> position.point, position -> position));

    public static Position of(int point) {
        return INDEX.get(point);
    }

    public final int point;

    Position(int point) {
        this.point = point;
    }

    public abstract int powerToMove(Position position);
}

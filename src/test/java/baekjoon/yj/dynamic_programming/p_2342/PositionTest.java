package baekjoon.yj.dynamic_programming.p_2342;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {
    @Test
    public void createCenter() {
        assertThat(Position.of(0)).isEqualTo(Position.CENTER);
    }

    @Test
    public void createTop() {
        assertThat(Position.of(1)).isEqualTo(Position.TOP);
    }

    @Test
    public void createLeft() {
        assertThat(Position.of(2)).isEqualTo(Position.LEFT);
    }

    @Test
    public void createBottom() {
        assertThat(Position.of(3)).isEqualTo(Position.BOTTOM);
    }

    @Test
    public void createRight() {
        assertThat(Position.of(4)).isEqualTo(Position.RIGHT);
    }

    @Test
    public void centerEnergyTest() {
        assertThat(Position.CENTER.powerToMove(Position.TOP)).isEqualTo(2);
        assertThat(Position.CENTER.powerToMove(Position.LEFT)).isEqualTo(2);
        assertThat(Position.CENTER.powerToMove(Position.BOTTOM)).isEqualTo(2);
        assertThat(Position.CENTER.powerToMove(Position.RIGHT)).isEqualTo(2);
    }

    @Test
    public void topEnergyTest() {
        assertThat(Position.TOP.powerToMove(Position.TOP)).isEqualTo(1);
        assertThat(Position.TOP.powerToMove(Position.LEFT)).isEqualTo(3);
        assertThat(Position.TOP.powerToMove(Position.BOTTOM)).isEqualTo(4);
        assertThat(Position.TOP.powerToMove(Position.RIGHT)).isEqualTo(3);
    }

    @Test
    public void leftEnergyTest() {
        assertThat(Position.LEFT.powerToMove(Position.TOP)).isEqualTo(3);
        assertThat(Position.LEFT.powerToMove(Position.LEFT)).isEqualTo(1);
        assertThat(Position.LEFT.powerToMove(Position.BOTTOM)).isEqualTo(3);
        assertThat(Position.LEFT.powerToMove(Position.RIGHT)).isEqualTo(4);
    }

    @Test
    public void bottomEnergyTest() {
        assertThat(Position.BOTTOM.powerToMove(Position.TOP)).isEqualTo(4);
        assertThat(Position.BOTTOM.powerToMove(Position.LEFT)).isEqualTo(3);
        assertThat(Position.BOTTOM.powerToMove(Position.BOTTOM)).isEqualTo(1);
        assertThat(Position.BOTTOM.powerToMove(Position.RIGHT)).isEqualTo(3);
    }

    @Test
    public void rightEnergyTest() {
        assertThat(Position.RIGHT.powerToMove(Position.TOP)).isEqualTo(3);
        assertThat(Position.RIGHT.powerToMove(Position.LEFT)).isEqualTo(4);
        assertThat(Position.RIGHT.powerToMove(Position.BOTTOM)).isEqualTo(3);
        assertThat(Position.RIGHT.powerToMove(Position.RIGHT)).isEqualTo(1);
    }
}
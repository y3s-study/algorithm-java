package baekjoon.yj.binarysearch;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    private BinarySearch binarySearch;

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testWhenContains() {
        boolean result = binarySearch.contains(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 8);
        assertThat(result).isTrue();
    }

    @Test
    public void testWhenNotContains() {
        boolean result = binarySearch.contains(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10);
        assertThat(result).isFalse();
    }
}

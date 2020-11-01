import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void connectedWithAllNotConnectedTest() {
        int[] integers = new int[] {0, 1, 2, 3, 4, 5};
        Main main = new Main(integers);

        assertFalse(main.connected(0, 1));
        assertFalse(main.connected(1, 2));
        assertFalse(main.connected(2, 3));
        assertFalse(main.connected(4, 5));
    }

    @Test
    public void connectedWithConnectedTest() {
        int[] integers = new int[] {0, 0, 3, 3, 3, 5};
        Main main = new Main(integers);

        assertTrue(main.connected(0, 1));
        assertFalse(main.connected(0, 2));
        assertFalse(main.connected(0, 3));
        assertFalse(main.connected(0, 4));
        assertFalse(main.connected(0, 5));

        assertTrue(main.connected(1, 0));
        assertFalse(main.connected(1, 2));
        assertFalse(main.connected(1, 3));
        assertFalse(main.connected(1, 4));
        assertFalse(main.connected(1, 5));

        assertFalse(main.connected(2, 0));
        assertFalse(main.connected(2, 1));
        assertTrue(main.connected(2, 3));
        assertTrue(main.connected(2, 4));
        assertFalse(main.connected(2, 5));

        assertFalse(main.connected(3, 0));
        assertFalse(main.connected(3, 1));
        assertTrue(main.connected(3, 2));
        assertTrue(main.connected(3, 4));
        assertFalse(main.connected(3, 5));

        assertFalse(main.connected(4, 0));
        assertFalse(main.connected(4, 1));
        assertTrue(main.connected(4, 2));
        assertTrue(main.connected(4, 3));
        assertFalse(main.connected(4, 5));

        assertFalse(main.connected(5, 0));
        assertFalse(main.connected(5, 1));
        assertFalse(main.connected(5, 2));
        assertFalse(main.connected(5, 3));
        assertFalse(main.connected(5, 4));
    }

    @Test
    public void unionTest() {
        int[] integers = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Main main = new Main(integers);
        assertArrayEquals(new int[] {0, 0, 2, 3, 4, 5, 6, 7, 8, 9}, main.union(0, 1));
        assertArrayEquals(new int[] {0, 0, 0, 3, 4, 5, 6, 7, 8, 9}, main.union(1, 2));
        assertArrayEquals(new int[] {0, 0, 0, 3, 4, 4, 6, 7, 8, 9}, main.union(4, 5));
        assertArrayEquals(new int[] {0, 0, 0, 3, 0, 4, 6, 7, 8, 9}, main.union(4, 2));
        assertArrayEquals(new int[] {0, 0, 0, 3, 0, 4, 6, 6, 8, 9}, main.union(6, 7));
        assertArrayEquals(new int[] {0, 0, 0, 3, 0, 4, 6, 6, 8, 8}, main.union(8, 9));
        assertArrayEquals(new int[] {0, 0, 0, 3, 0, 4, 8, 6, 8, 8}, main.union(8, 6));
        assertArrayEquals(new int[] {0, 0, 0, 3, 0, 4, 8, 6, 0, 8}, main.union(0, 9));
    }

    public void assertExpression(Main main, int[] integers, boolean expected) {
        int previousItem = -1;
        for (int integerValue : integers) {
            if (previousItem == -1) {
                previousItem = integerValue;
                continue;
            }
            assertEquals(expected, main.connected(integerValue, previousItem));
        }
    }
}

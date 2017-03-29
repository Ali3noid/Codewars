package kata;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tribonacci Sequence - /kata/556deca17c58da83c00002db
 */
public class TribonacciSequenceTest {

    @Test
    public void basicTests() {
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, TribonacciSequence.tribonacci(new double[]{1, 1, 1}, 10));
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, TribonacciSequence.tribonacci(new double[]{0, 0, 1}, 10));
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, TribonacciSequence.tribonacci(new double[]{0, 1, 1}, 10));
    }

    private void assertArrayEquals(double[] expected, double[] actual) {
        for (int i = 0; i < actual.length; i++)
            assertEquals(expected[i], actual[i], 1e-10);
    }

}
package kata;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Are they the "same"? - kata/are-they-the-same - 550498447451fbbd7600041c
 */
public class AreSameTest {

    @Test
    public void Should_True_When_CompareTrueScenario() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(AreSame.comp(a, b), true);
    }

    @Test
    public void Should_False_When_CompareFalseScenario() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{122, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(AreSame.comp(a, b), false);
    }

    @Test
    public void Should_False_When_CompareNull() {
        assertEquals(AreSame.comp(null, null), false);
    }

    @Test
    public void Should_True_When_CompareZeroSizeArrays() {
        int[] a = new int[]{};
        int[] b = new int[]{};
        assertEquals(AreSame.comp(a, b), true);
    }

    @Test
    public void Should_False_When_CompareLongerB() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361, 361};
        assertEquals(AreSame.comp(a, b), false);
    }

    @Test
    public void Should_False_When_CompareLongerA() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(AreSame.comp(a, b), false);
    }

    @Test
    public void Should_True_When_CompareNegativeA() {
        int[] a = new int[]{-121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(AreSame.comp(a, b), true);
    }

}
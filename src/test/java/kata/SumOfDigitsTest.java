package kata;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Sum of Digits / Digital Root - /kata/541c8630095125aba6000c00
 */
public class SumOfDigitsTest {
    @Test
    public void Tests() {
        assertEquals(7, SumOfDigits.digital_root(16));
        assertEquals(6, SumOfDigits.digital_root(132189));
    }
}
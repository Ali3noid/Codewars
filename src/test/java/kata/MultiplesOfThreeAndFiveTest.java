package kata;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Multiples of 3 and 5 - /kata/514b92a657cdc65150000006
 */
public class MultiplesOfThreeAndFiveTest {
    @Test
    public void test() {
        assertEquals(23, new MultiplesOfThreeAndFive().solution(10));
    }

}
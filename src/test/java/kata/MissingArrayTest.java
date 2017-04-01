package kata;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Length of missing array - /kata/57b6f5aadb5b3d0ae3000611
 */
public class MissingArrayTest {
    @Test
    public void BasicTests() {
        assertEquals(0, MissingArray.getLengthOfMissingArray(new Object[][] { }));
        assertEquals(3, MissingArray.getLengthOfMissingArray(new Object[][] { new Object[] { 1, 2 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
        assertEquals(2, MissingArray.getLengthOfMissingArray(new Object[][] { new Object[] { 5, 2, 9 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
        assertEquals(2, MissingArray.getLengthOfMissingArray(new Object[][] { new Object[] { null }, new Object[] { null, null, null } } ));
        assertEquals(5, MissingArray.getLengthOfMissingArray(new Object[][] { new Object[] { 'a', 'a', 'a' }, new Object[] { 'a', 'a' }, new Object[] { 'a', 'a', 'a', 'a' }, new Object[] { 'a' }, new Object[] { 'a', 'a', 'a', 'a', 'a', 'a' }} ));
    }
}
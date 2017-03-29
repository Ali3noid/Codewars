package kata;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Build a pile of Cubes - kata/5592e3bd57b64d00f3000047
 */
public class CubePileTest {

    @Test
    public void scenario1() {
        assertEquals(2022, CubePile.findNb(4183059834009L));
    }

    @Test
    public void scenario2() {
        assertEquals(-1, CubePile.findNb(24723578342962L));
    }

    @Test
    public void scenario3() {
        assertEquals(4824, CubePile.findNb(135440716410000L));
    }

    @Test
    public void scenario4() {
        assertEquals(3568, CubePile.findNb(40539911473216L));
    }

}
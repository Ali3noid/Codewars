package kata;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Triple trouble - /kata/55d5434f269c0c3f1b000058
 */
public class TripleDoubleTest {


    @Test
    public void scenario1(){
        assertEquals(1, TripleDouble.TripleDouble(451999277L, 41177722899L));
    }

    @Test
    public void scenario2(){
        assertEquals(0, TripleDouble.TripleDouble(1222345L, 12345L));
    }

    @Test
    public void scenario3(){
        assertEquals(0, TripleDouble.TripleDouble(12345L, 12345L));
    }

    @Test
    public void scenario4(){
        assertEquals(1, TripleDouble.TripleDouble(666789L, 12345667L));
    }


}
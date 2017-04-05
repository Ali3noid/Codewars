package kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Recover a secret string from random triplets - /kata/53f40dff5f9d31b813000774
 */
public class SecretStringTest {

    private SecretString detective;

    @Before
    public void setup() {
        detective = new SecretString();
    }

    @Test
    public void secret1() {
        char[][] triplets = {
            {'t','u','p'},
            {'w','h','i'},
            {'t','s','u'},
            {'a','t','s'},
            {'h','a','p'},
            {'t','i','s'},
            {'w','h','s'}
        };
        assertEquals("whatisup", detective.recoverSecret(triplets));
    }

}
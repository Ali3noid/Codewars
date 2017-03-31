package kata;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * PaginationHelper - kata/515bb423de843ea99400000a
 */
public class PaginationHelperTest {
    PaginationHelper<Character> helper;

    @Before
    public void setUp() {
        helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
    }

    @Test
    public void itemCount() throws Exception {
        assertEquals(6, helper.itemCount());
    }

    @Test
    public void pageCount() throws Exception {
        assertEquals(2, helper.pageCount());
    }

    @Test
    public void pageItemCount() throws Exception {
        assertEquals(2, helper.pageItemCount(1));
        assertEquals(-1, helper.pageItemCount(2));
        assertEquals(4, helper.pageItemCount(0));

    }

    @Test
    public void pageIndex() throws Exception {
        assertEquals(1, helper.pageIndex(5));
        assertEquals(0, helper.pageIndex(2));
        assertEquals(-1, helper.pageIndex(20));
        assertEquals(-1, helper.pageIndex(-10));
    }

}
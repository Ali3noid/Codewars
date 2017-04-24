package kata.kyu5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Help your granny - /kata/5536a85b6ed4ee5a78000035
 */
public class HelpYourGrannyTest {

    @Test
    public void test1() {
        String[] friends1 = new String[]{"A1", "A2", "A3", "A4", "A5"};
        String[][] fTowns1 = {new String[]{"A1", "X1"}, new String[]{"A2", "X2"}, new String[]{"A3", "X3"},
            new String[]{"A4", "X4"}};
        Map<String, Double> distTable1 = new HashMap<>();
        distTable1.put("X1", 100.0);
        distTable1.put("X2", 200.0);
        distTable1.put("X3", 250.0);
        distTable1.put("X4", 300.0);
        assertEquals(889, HelpYourGranny.tour(friends1, fTowns1, distTable1));
    }

}
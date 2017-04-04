package kata;

import java.util.*;
import java.util.function.BiFunction;


/**
 * Weight for weight - kata/55c6126177c9441a570000cc
 */
public class WeightSort {

    public static String orderWeight(String strng) {
        String result;
        String[] strings = strng.split("\\s+");
        Arrays.sort(strings, (e1, e2) -> sortByWeight.apply(e1, e2));
        result = Arrays.toString(strings).replaceAll("[\\,\\[\\]]", "");
        return result;
    }

    private static BiFunction<String, String, Integer> sortByWeight = (e1, e2) -> {
        int firstSum = e1
            .chars()
            .map(Character::getNumericValue)
            .sum();

        int secondSum = e2
            .chars()
            .map(Character::getNumericValue)
            .sum();

        int result = Integer.compare(firstSum, secondSum);

        if (result == 0) {
            result = e1.compareTo(e2);
        }
        return result;
    };
}

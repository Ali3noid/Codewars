package kata.kyu7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Sorting the Odd way! - /kata/57fb79784e2d0639c9000066/
 */
class SortingTheOddWay {
    static Double[] sortItOut(Double[] array) {
        List<Double> odds = Arrays
            .stream(array)
            .filter(value -> Math.floor(value) % 2 != 0)
            .sorted()
            .collect(Collectors.toList());

        List<Double> even = Arrays
            .stream(array)
            .filter(value -> Math.floor(value) % 2 == 0)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        List<Double> resultList = Stream.concat(odds.stream(), even.stream()).collect(Collectors.toList());

        return resultList.toArray(new Double[array.length]);
    }
}

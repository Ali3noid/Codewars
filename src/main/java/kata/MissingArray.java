package kata;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Length of missing array - /kata/57b6f5aadb5b3d0ae3000611
 */
class MissingArray {
    static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) return 0;

        for (Object[] object : arrayOfArrays) {
            if (object == null || object.length == 0) {
                return 0;
            }
        }

        List<Integer> LengthsDifferences = new ArrayList<>();
        List<Integer> lengths = Arrays
            .stream(arrayOfArrays)
            .map(objects -> objects.length)
            .collect(Collectors.toList());

        Collections.sort(lengths);

        IntStream
            .range(0, lengths.size() - 1)
            .forEach(i -> LengthsDifferences.add(lengths.get(i + 1) - lengths.get(i)));

        Integer maxLengthDifference = LengthsDifferences
            .stream()
            .max(Integer::compareTo)
            .orElseThrow(() -> new RuntimeException("There is no maximum value"));

        return lengths.get(LengthsDifferences.indexOf(maxLengthDifference)) + 1;
    }
}

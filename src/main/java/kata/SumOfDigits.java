package kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Sum of Digits / Digital Root - /kata/541c8630095125aba6000c00
 */
public class SumOfDigits {
    public static int digital_root(int n) {
        List<Integer> digitsList = new ArrayList<>();
        int length = (int) (Math.log10(n) + 1);

        IntStream
            .range(0, length)
            .forEach(i -> digitsList.add(getNthDigit(n, i + 1)));

        int result = digitsList
            .stream()
            .mapToInt(Integer::intValue)
            .sum();

        if (Math.floor(Math.log10(result) + 1) > 1) return digital_root(result);
        return result;
    }

    private static int getNthDigit(int number, int n) {
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }
}

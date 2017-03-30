package kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Triple trouble - /kata/55d5434f269c0c3f1b000058
 */
public class TripleDouble {


    public static int TripleDouble(long num1, long num2) {
        List<Integer> sameTriple = new ArrayList<>();
        List<Integer> sameDouble = new ArrayList<>();
        int length1 = (int) (Math.log10(num1) + 1);
        int length2 = (int) (Math.log10(num2) + 1);

        IntStream.range(1, length1 - 1).
            forEach(i -> {
                if (getNthDigit(num1, i) == getNthDigit(num1, i + 1) &&
                    getNthDigit(num1, i) == getNthDigit(num1, i + 2)) {
                    sameTriple.add(getNthDigit(num1, i));
                }
            });
        if (sameTriple.isEmpty()) return 0;

        IntStream.range(1, length2).forEach(i -> {
            if (getNthDigit(num2, i) == getNthDigit(num2, i + 1)) {
                sameDouble.add(getNthDigit(num2, i));
            }
        });

        if (sameDouble.isEmpty()) return 0;

        sameTriple.retainAll(sameDouble);

        if (sameTriple.isEmpty()) return 0;

        return 1;
    }

    private static int getNthDigit(long number, int n) {
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }
}

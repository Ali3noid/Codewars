package kata;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Tribonacci Sequence - /kata/556deca17c58da83c00002db
 */
class TribonacciSequence {

    static double[] tribonacci(double[] s, int n) {
        if (n == 0) {
            return new double[]{};
        }
        double[] tribonacci = Arrays.copyOf(s, n);
        IntStream.range(s.length, n).forEach(i ->
            tribonacci[i] = tribonacci[i - 3] + tribonacci[i - 2] + tribonacci[i - 1]
        );
        return tribonacci;
    }
}

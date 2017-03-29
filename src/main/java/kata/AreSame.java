package kata;

import java.util.Arrays;

/**
 * Are they the "same"? - kata/are-they-the-same - 550498447451fbbd7600041c
 */
class AreSame {

    static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;

        a = Arrays
            .stream(a)
            .map(x -> x * x)
            .toArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}

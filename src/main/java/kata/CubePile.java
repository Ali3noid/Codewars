package kata;

/**
 * Build a pile of Cubes - kata/5592e3bd57b64d00f3000047
 */
class CubePile {

    static long findNb(long m) {
        int result = 1;

        while (m > 0) {
            m -= Math.round(Math.pow(result, 3));
            if (m == 0) return result;
            result++;
        }

        return -1L;
    }
}

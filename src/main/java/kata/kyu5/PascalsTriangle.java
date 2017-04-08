package kata.kyu5;

import java.util.stream.IntStream;

/**
 * Pascal's Triangle #2 - /kata/52945ce49bb38560fe0001d9/
 */
class PascalsTriangle {

    static int[][] pascal(int depth) {
        int[][] result = new int[depth][];
        IntStream.range(0, depth).forEach(i -> {
            int[] tempArray = new int[i + 1];
            tempArray[0] = 1;
            IntStream.range(1, i).forEach(j ->
                tempArray[j] = result[i - 1][j] + result[i - 1][j - 1]
            );
            tempArray[i] = 1;
            result[i] = tempArray;
        });
        return result;
    }
}

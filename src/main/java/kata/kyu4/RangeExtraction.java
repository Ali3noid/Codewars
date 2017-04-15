package kata.kyu4;

import java.util.ArrayList;
import java.util.List;

/**
 * Range Extraction - /kata/51ba717bb08c1cd60f00002f/
 */
class RangeExtraction {
    static String rangeExtraction(int[] arr) {
        List<String> wrappedNumbers = new ArrayList<>();
        List<Integer> numbersToWrap = new ArrayList<>();

        numbersToWrap.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int actualNumber = arr[i];
            if (actualNumber == arr[i - 1] + 1) {
                numbersToWrap.add(actualNumber);
            } else {
                wrappedNumbers.add(wrapNumbers(numbersToWrap));
                numbersToWrap = new ArrayList<>();
                numbersToWrap.add(actualNumber);
            }
        }
        wrappedNumbers.add(wrapNumbers(numbersToWrap));

        return String.join(",", wrappedNumbers);
    }

    private static String wrapNumbers(List<Integer> numbersToWrap) {
        Integer firstElement = numbersToWrap.get(0);
        int size = numbersToWrap.size();

        if (size == 1) {
            return firstElement.toString();
        } else if (size == 2) {
            return firstElement.toString() + "," + numbersToWrap.get(1).toString();
        } else {
            return firstElement.toString() + "-" + numbersToWrap.get(size - 1);
        }
    }
}

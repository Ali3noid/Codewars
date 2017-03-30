package kata;

import java.util.stream.IntStream;

/**
 * Multiples of 3 and 5 - /kata/514b92a657cdc65150000006
 */
class MultiplesOfThreeAndFive {

    int solution(int number) {
        return IntStream
            .range(1, number)
            .filter(i -> i % 3 == 0 || i % 5 == 0)
            .sum();
    }
}

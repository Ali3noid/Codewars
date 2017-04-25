package kata.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Prime number decompositions - /kata/53c93982689f84e321000d62
 */
class PrimeNumberDecompositions {
    /**
     * Return value: List of all prime factors of a given number n
     */
    static Long[] getAllPrimeFactors(long n) {
        List<Long> factors = new ArrayList<>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(Long.valueOf(i));
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors.toArray(new Long[factors.size()]);
    }

    /**
     * Return value: List containing two lists, first containg all prime factors without duplicates,
     * second containing the count, how often each prime factor occured.
     * Return code always contains two lists.
     * <p>
     * e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2 times, prime 2 occurs 5 times,
     */
    static Long[][] getUniquePrimeFactorsWithCount(long n) {
        Map<Long, Long> factorOccurrences =
            Arrays.stream(getAllPrimeFactors(n))
                .collect(Collectors.groupingBy(prime -> prime, Collectors.counting()));
        Long[][] arrayOccurrences = new Long[2][];
        arrayOccurrences[0] = factorOccurrences.keySet().toArray(new Long[factorOccurrences.size()]);
        arrayOccurrences[1] = factorOccurrences.values().toArray(new Long[factorOccurrences.size()]);
        return arrayOccurrences;
    }

    /**
     * Return value: List containing product of same prime factors,
     * e.g.: 45 = 3*3*5 ==>  {3^2,5^1} == {9,5}
     * e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2 times, prime 2 occurs 5 times,
     */
    static Long[] getPrimeFactorPotencies(long n) {
        Long[][] factorsWithCount = getUniquePrimeFactorsWithCount(n);
        List<Long> potentials = new ArrayList<>();

        for (int i = 0; i < factorsWithCount[0].length; i++) {
            potentials.add(Math.round(Math.pow(factorsWithCount[0][i], factorsWithCount[1][i])));
        }
        return potentials.toArray(new Long[potentials.size()]);
    }
}

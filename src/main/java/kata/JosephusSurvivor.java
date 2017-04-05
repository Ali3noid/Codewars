package kata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Josephus Survivor - /kata/555624b601231dc7a400017a
 */
public class JosephusSurvivor {

    public static int josephusSurvivor(final int n, final int k) {
        int manToKill = 0;

        List<Integer> people = IntStream
            .rangeClosed(1, n)
            .boxed()
            .collect(Collectors.toList());

        while (people.size() > 1) {
            manToKill = (manToKill + (k - 1)) % people.size();
            people.remove(manToKill);
        }

        return people.get(0);
    }
}

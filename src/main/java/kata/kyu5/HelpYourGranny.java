package kata.kyu5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Help your granny - /kata/5536a85b6ed4ee5a78000035
 */
class HelpYourGranny {

    static int tour(String[] arrFriends, String[][] ftwns, Map<String, Double> h) {
        Double result = 0.0;

        Map<String, String> friendCity = Arrays.stream(ftwns)
            .collect(Collectors.toMap(connection -> connection[0], connection -> connection[1]));

        List<String> circuit = getCircuit(arrFriends, friendCity);

        for (int i = 0; i < circuit.size() - 1; i++) {
            result += getDistance(circuit.get(i), circuit.get(i + 1), h);
        }

        return result.intValue();
    }

    private static List<String> getCircuit(String[] arrFriends, Map<String, String> friendCity) {
        List<String> circuit = Arrays.stream(arrFriends)
            .map(friendCity::get).filter(Objects::nonNull).collect(Collectors.toList());
        circuit.add(0, "X0");
        circuit.add("X0");
        return circuit;
    }

    private static Double getDistance(String from, String to, Map<String, Double> distances) {
        if (from.equals("X0")) {
            return distances.get(to);
        } else if (to.equals("X0")) {
            return distances.get(from);
        } else {
            return pythagoreanTheorem(distances.get(from), distances.get(to));
        }
    }

    private static Double pythagoreanTheorem(Double leg, Double hypotenuse) {
        return Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(leg, 2));
    }
}

package kata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Recover a secret string from random triplets - /kata/53f40dff5f9d31b813000774
 */
public class SecretString {

    public String recoverSecret(char[][] triplets) {
        Map<Character, LinkedHashSet<Character>> characterMap = new HashMap<>();

        Arrays
            .stream(triplets).forEach(chars -> {
            IntStream.range(0, 3).forEach(i -> characterMap.computeIfAbsent(chars[i], k -> new LinkedHashSet<>()));
            characterMap.get(chars[0]).add(chars[1]);
            characterMap.get(chars[0]).add(chars[2]);
            characterMap.get(chars[1]).add(chars[2]);
        });

        int lastChar = characterMap.size();
        char[] secretWord = new char[lastChar];

        while (!characterMap.isEmpty()) {
            char emptyChar = characterMap.entrySet()
                .stream()
                .filter(charMap -> charMap.getValue().isEmpty())
                .findFirst().map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("No empty charList"));

            characterMap.entrySet().forEach(charMap -> charMap.getValue().remove(emptyChar));

            characterMap.remove(emptyChar);
            secretWord[lastChar - 1] = emptyChar;
            lastChar -= 1;
        }

        return new String(secretWord);
    }
}

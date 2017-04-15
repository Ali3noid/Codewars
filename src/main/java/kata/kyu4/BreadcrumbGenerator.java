package kata.kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Breadcrumb generator - /kata/563fbac924106b8bf7000046/
 */
class BreadcrumbGenerator {
    static String generate_bc(String url, String separator) {
        List<String> parts = getParts(url);
        List<String> strings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("");

        int partsSize = parts.size();
        if (parts.get(partsSize - 1).contains("index")) parts.remove(partsSize - 1);

        partsSize = parts.size();
        if (partStartWithSpecialSign(parts)) parts.remove(partsSize - 1);

        partsSize = parts.size();
        if (partsSize == 1) return "<span class=\"active\">HOME</span>";

        strings.add("<a href=\"/\">HOME</a>");

        if (partsSize == 2) {
            strings.add(getLastElement(parts));
            return String.join(separator, strings);
        }

        IntStream.range(1, parts.size() - 1).forEach(i -> {
            String part = parts.get(i);
            if (part.length() > 30) {
                strings.add("<a href=\"/" + stringBuilder + part + "/\">" + getAcronymPart(part) + "</a>");
            } else {
                strings.add("<a href=\"/" + stringBuilder + part + "/\">" + part.toUpperCase().replaceAll("-", " ") + "</a>");
            }
            stringBuilder.append(part + "/");
        });

        strings.add(getLastElement(parts));

        return String.join(separator, strings);
    }

    private static List<String> getParts(String url) {
        List<String> parts = new LinkedList<>(Arrays.asList(url.split("/")));
        if (url.contains("//")) parts = parts.subList(2, parts.size());
        return parts;
    }

    private static boolean partStartWithSpecialSign(List<String> parts) {
        String lastPart = parts.get(parts.size() - 1);
        return lastPart.startsWith("#") ||
            lastPart.startsWith("?") ||
            lastPart.startsWith(".");
    }

    private static String getAcronymPart(String part) {
        List<String> ignoredWords = Arrays.asList("the", "of", "in", "from", "by", "with", "and", "or", "for", "to", "at", "a");
        List<String> words = new LinkedList<>(Arrays.asList(part.split("-")));
        return words
            .stream()
            .filter(word -> !ignoredWords.contains(word))
            .map(word -> word.substring(0, 1).toUpperCase())
            .collect(Collectors.joining());
    }

    private static String getLastElement(List<String> parts) {
        String lastElement = parts.get(parts.size() - 1)
            .split("\\.")[0]
            .split("\\?")[0]
            .split("#")[0];

        if (lastElement.length() > 30) {
            return "<span class=\"active\">" + getAcronymPart(lastElement) + "</span>";
        } else {
            return "<span class=\"active\">" + lastElement.replaceAll("-", " ").toUpperCase() + "</span>";
        }
    }
}

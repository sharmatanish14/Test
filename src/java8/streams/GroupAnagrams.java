package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class GroupAnagrams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("bat", "tab", "cat", "tac", "act", "dog", "god");

        Map<String, List<String>> groupedAnagrams =
                words.stream().collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars); // sort the word
                    return new String(chars); // use sorted word as key
                }));

        groupedAnagrams.forEach((k, v) -> System.out.println(k + " @@@ " + v));
    }
}
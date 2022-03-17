package PracticTask.ExampleStringsNumbersMath;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
Подсчет повторяющихся символов
 **/

public class FindDublicateChar {

    private static Map<Character, Long> countDuplicateChar(String str) {
        Map<Character, Long> res = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            res.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return res;
    }

    private static Map<Character, Long> countDuplicateCharStream(String str) {
        Map<Character, Long> res = str.chars()
                .mapToObj(c ->(char) c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        return res;
    }

    private static void printStr(Map<Character, Long> map) {
        for (Map.Entry<Character, Long> m: map.entrySet()) {
            System.out.println(m.getKey() + ": " + m.getValue());
        }
    }

    public static void main(String[] args) {
        String str = "aaafffvvvvbbbwwweeerrr@";
        printStr(countDuplicateCharStream(str));
    }
}

package PracticTask.ExampleStringsNumbersMath;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *Отыскание первого неповторяющегося символа
 */

public class FindFirstNotRepeatChar {

    private static Character findFirstChar(String str) {
        Map<Character, Long> result = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (c, v) -> (v == null) ? 1 : ++v);
        }

        for (Map.Entry<Character, Long> entry : result.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }

    public static void main(String[] args) {
        String str = "sdfghgfdshq";
        Character ch = findFirstChar(str);
        System.out.printf("Character ' %s ' is first not duplicate", ch);


    }
}

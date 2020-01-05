package com.lalit.algorithm.pattern.matching;

import java.util.HashMap;
import java.util.Map;

//Boyer Moore Algo
public final class BMPatternMatching {


    private final static Map<Character, Integer> findCharToLastIndexMapper(String pattern) {
        char[] chars = pattern.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = chars.length - 1; i >= 0; --i) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
            }
        }
        return map;
    }


    public static boolean patternMatchingIndex(String text, String pattern) {
        Map<Character, Integer> charToLastIndexMapping = BMPatternMatching.findCharToLastIndexMapper(pattern);
        int textLen = text.length();
        int patternLen = pattern.length();
        char[] textCharArray = text.toCharArray();
        char[] patternCharArray = pattern.toCharArray();
        int i = patternLen - 1;
        int j = patternLen - 1;
        while (i <= textLen - 1) {
            if (textCharArray[i] == patternCharArray[j]) {
                if (j == 0) {
                    return true;
                } else {
                    --j;
                    --i;
                }
            } else {
                Integer integer = charToLastIndexMapping.get(textCharArray[i]);
                i = i + patternLen - Math.min(j, 1 + (integer == null ? -1 : integer));
                j = patternLen - 1;
            }
        }
        return false;
    }

    public static void main(String... s) {
        String text = "abaabbcabababc";
        String pattern = "bbcabab";
        System.out.println(BMPatternMatching.patternMatchingIndex(text, pattern));
    }
}

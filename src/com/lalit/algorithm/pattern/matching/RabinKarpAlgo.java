package com.lalit.algorithm.pattern.matching;

//https://www.youtube.com/watch?v=qQ8vS2btsxI&t=20s
//TODO by 10th JAN 2020 Morning 7 am

import javax.print.attribute.HashAttributeSet;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * hash( txt[s+1 .. s+m] ) = ( d ( hash( txt[s .. s+m-1]) – txt[s]*h ) + txt[s + m] ) mod q
 * <p>
 * hash( txt[s .. s+m-1] ) : Hash value at shift s.
 * hash( txt[s+1 .. s+m] ) : Hash value at next shift (or shift s+1)
 * d: Number of characters in the alphabet
 * q: A prime number
 * h: d^(m-1)
 **/

//TODO  1. Correct value of j 2. Fix current scenario 3. Add support for %(modular) in case pattern length to match is large
public class RabinKarpAlgo {

    static final Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('A', 65);
        map.put('B', 66);
        map.put('C', 67);
        map.put('D', 68);
        map.put('E', 69);
        map.put('F', 70);
        map.put('G', 71);
        map.put('H', 72);
        map.put('I', 73);
        map.put('J', 74);
    }

    private static int rollingHashFunction(int existingHash, int asciiOfCurrentChar, int patternLen, int asciiOfPreChar) {
        int numberOfUniqueCharacters = 10;
        int hash = ((numberOfUniqueCharacters * (existingHash - (asciiOfPreChar * ((int) Math.pow(numberOfUniqueCharacters, patternLen - 1))))) + asciiOfCurrentChar);//% 3232373;
        System.out.println(hash);
        return hash;
    }


    public static void main(String... s) {
        String pattern = "ABDABJDDEF";
        String text = "ABDABJDDEF";
        int numberOfUniqueCharacters = 10;
        char[] chars = pattern.toCharArray();
        double sum = 0;
        int patternHash = getHash(chars, sum, numberOfUniqueCharacters);
        int lenText = text.length();
        int i = 0;
        int hash = 0;
        int j = pattern.length() - 1;
        int patternLen = pattern.length();
        while (i < lenText && j < lenText - 1) {
            if (i == 0) {
                hash = getHash(text.substring(0, patternLen).toCharArray(), 0, numberOfUniqueCharacters);
                System.out.println(hash);
            } else {
                ++j;
                hash = rollingHashFunction(hash, map.get(text.charAt(j)), pattern.length(), map.get(text.charAt(j - patternLen)));
            }
            if (hash == patternHash) {
                System.out.println("Matched");
                break;
            }
            ++i;
        }
    }

    private static int getHash(char[] chars, double sum, int numberOfUniqueCharacters) {
        for (int i = 0, j = chars.length - 1; i < chars.length; ++i, --j)
            sum = sum + map.get(chars[i]) * Math.pow(numberOfUniqueCharacters, j);
        int primeNumber = 3232373;
        return (int) sum; // % primeNumber;
    }


}

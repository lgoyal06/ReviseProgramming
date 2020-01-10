package com.lalit.algorithm.pattern.matching;

//https://www.youtube.com/watch?v=qQ8vS2btsxI&t=20s
//TODO by 10th JAN 2020 Morning 7 am

/**
 * hash( txt[s+1 .. s+m] ) = ( d ( hash( txt[s .. s+m-1]) – txt[s]*h ) + txt[s + m] ) mod q
 * <p>
 * hash( txt[s .. s+m-1] ) : Hash value at shift s.
 * hash( txt[s+1 .. s+m] ) : Hash value at next shift (or shift s+1)
 * d: Number of characters in the alphabet
 * q: A prime number
 * h: d^(m-1)
 **/

//TODO  1. Add support for %(modular) in case pattern length to match is large with d as 128
public class RabinKarpAlgo {

    private static int rollingHashFunction(int existingHash, int asciiOfCurrentChar, int patternLen, int asciiOfPreChar) {
        int numberOfUniqueCharacters = 10;
        int hash = ((numberOfUniqueCharacters * (existingHash - (asciiOfPreChar * ((int) Math.pow(numberOfUniqueCharacters, patternLen - 1))))) + asciiOfCurrentChar);//% 3232373;
        return hash;
    }


    public static void main(String... s) {
        String pattern = "@$%^$^*";
        String text = "ABDAB@$%^$^*JDDEF";
        int numberOfUniqueCharacters = 10;
        char[] chars = pattern.toCharArray();
        double sum = 0;
        int patternHash = getHash(chars, sum, numberOfUniqueCharacters);
        int lenText = text.length();
        int i = 0;
        int hash = 0;
        int j = pattern.length() - 1;
        int patternLen = pattern.length();
        boolean hasMatchFound = false;
        while (i < lenText && j < lenText) {
            if (i == 0) {
                hash = getHash(text.substring(0, patternLen).toCharArray(), 0, numberOfUniqueCharacters);
            } else {
                ++j;
                if (j < lenText) {
                    hash = rollingHashFunction(hash, text.charAt(j), pattern.length(), (text.charAt(j - patternLen)));
                }
            }
            if (hash == patternHash) {
                System.out.println("Matched");
                hasMatchFound = true;
                break;
            }
            ++i;
        }
        if (!hasMatchFound)
            System.out.println("No Match Found");
    }

    private static int getHash(char[] chars, double sum, int numberOfUniqueCharacters) {
        for (int i = 0, j = chars.length - 1; i < chars.length; ++i, --j)
            sum = sum + (chars[i]) * Math.pow(numberOfUniqueCharacters, j);
        int primeNumber = 3232373;
        return (int) sum; // % primeNumber;
    }


}

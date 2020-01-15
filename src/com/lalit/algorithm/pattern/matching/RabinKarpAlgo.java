package com.lalit.algorithm.pattern.matching;

/**
 * hash( txt[s+1 .. s+m] ) = ( d ( hash( txt[s .. s+m-1]) – txt[s]*h ) + txt[s + m] ) mod q
 * <p>
 * hash( txt[s .. s+m-1] ) : Hash value at shift s.
 * hash( txt[s+1 .. s+m] ) : Hash value at next shift (or shift s+1)
 * d: Number of characters in the alphabet
 * q: A prime number
 * h: d^(m-1)
 **/
public class RabinKarpAlgo {

    public static final int NUMBER_OF_UNIQUE_CHARACTERS = 256;

    private static int rollingHashFunction(int textHash, int hash, int asciiOfCurrentChar, int patternLen, int asciiOfPreChar) {
        textHash = ((NUMBER_OF_UNIQUE_CHARACTERS * (textHash - (asciiOfPreChar * hash))) + asciiOfCurrentChar) % 101;
        if (textHash < 0) {
            return textHash + 101;
        }
        return textHash;
    }


    public static void main(String... s) {
        String pattern = "BDABD ";
        String text = "ABABDABDAB";
        char[] chars = pattern.toCharArray();
        double sum = 0;
        int hash = (int) (Math.pow(NUMBER_OF_UNIQUE_CHARACTERS, pattern.length() - 1)) % 101;
        int textHash = 0;
        int patternHash = getHash(chars, sum);
        int lenText = text.length();
        int i = 0;
        int j = pattern.length() - 1;
        int patternLen = pattern.length();
        boolean hasMatchFound = false;
        while (i < lenText && j < lenText) {
            if (i == 0) {
                textHash = getHash(text.substring(0, patternLen).toCharArray(), 0);
            } else {
                ++j;
                if (j < lenText) {
                    textHash = rollingHashFunction(textHash, hash, text.charAt(j), pattern.length(), (text.charAt(j - patternLen)));
                }
            }
            if (textHash == patternHash) {
                System.out.println("Matched");
                hasMatchFound = true;
                break;
            }
            ++i;
        }
        if (!hasMatchFound)
            System.out.println("No Match Found");
    }

    private static int getHash(char[] chars, double sum) {
        for (int i = 0; i < chars.length; ++i)
            sum = (sum * NUMBER_OF_UNIQUE_CHARACTERS + chars[i]) % 101;
        return ((int) sum);
    }


}

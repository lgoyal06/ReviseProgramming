package com.lalit.algorithm.pattern.matching;

//Knuth Morris Pratt
public class KMPAlgo {

    private static int[] resetIndexArray(String pattern) {

        char[] chars = pattern.toCharArray();
        int[] resetVal = new int[chars.length];
        int i = 1, j = 0;
        resetVal[0] = 0;
        while (i < chars.length) {
            if (chars[i] == chars[j]) {
                resetVal[i] = resetVal[i - 1] + 1;
                ++j;
            } else {
                resetVal[i] = 0;
                j = 0;
            }
            ++i;
        }
        return resetVal;
    }

    public static boolean patternMatching(String text, String pattern) {
        int[] failureResetTable = KMPAlgo.resetIndexArray(pattern);

        char[] textCharArray = text.toCharArray();
        char[] patternCharArray = pattern.toCharArray();
        int i = 0;
        int j = 0;
        while (i <= textCharArray.length - 1) {
            if (textCharArray[i] == patternCharArray[j]) {
                if (j == patternCharArray.length - 1) {
                    return true;
                } else {
                    ++i;
                    ++j;
                }
            } else if (j > 0) {
                j = failureResetTable[j - 1];
            } else {
                ++i;
            }
        }
        return false;
    }

    public static void main(String... s) {
        System.out.println(KMPAlgo.patternMatching("abaabbcabab", "bb"));
    }
}

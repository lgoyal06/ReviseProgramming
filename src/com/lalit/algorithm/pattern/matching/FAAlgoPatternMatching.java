package com.lalit.algorithm.pattern.matching;

public class FAAlgoPatternMatching {

    /***
     * TODO Use KMP Algo concept of lps of 17th Jan 2020
     *
     * lps[i] = the longest proper prefix of pat[0..i]
     *               which is also a suffix of pat[0..i].
     *
     * Also calculate its Time complexity
     * @param initialTable
     * @param patternChars
     * @param distinctChars
     * @return
     */
    public static int[][] buildFATable(int[][] initialTable, char[] patternChars, char[] distinctChars) {
        for (char ch1 : patternChars) {
            int i = 0;
            for (char ch2 : distinctChars) {
                int j = 0;
                if (ch1 == ch2 && ch2 == patternChars[0]) {
                    initialTable[i][j] = 0;
                } else if (ch2 == patternChars[i + 1]) {
                    initialTable[i][j] = 0;
                }
                ++j;
            }
        }
        return null;
    }

    //Time complexity o(m+n)  m - total chars , n- distinct chars
    public static char[] distinctChars(String pattern) {
        char[] chars = pattern.toCharArray();
        char[] distinctChars = new char[chars.length];
        int i = 0, k = 0, elementsAlreadyExisted = 0;
        for (char ch : chars) {
            boolean numberAlreadyFound = false;
            int j = 0;
            while (j < i) {
                if (distinctChars[j++] == ch) {
                    numberAlreadyFound = true;
                    ++elementsAlreadyExisted;
                    break;
                }
            }
            if (!numberAlreadyFound)
                distinctChars[k++] = ch;
            ++i;
        }
        int q = 0;
        char[] distinctChars1 = new char[chars.length - elementsAlreadyExisted];
        while (q < distinctChars1.length) {
            distinctChars1[q] = distinctChars[q];
            ++q;
        }
        return distinctChars1;
    }

    public static void main(String... s) {
        String pattern = "ACACAGA";
        char[] distinctChars = distinctChars(pattern);
        int[][] initialTable = new int[pattern.length()][distinctChars.length];
        buildFATable(initialTable, pattern.toCharArray(), distinctChars);
    }
}

package com.lalit.algorithm.pattern.matching;

import com.sun.org.apache.regexp.internal.RE;

public final class FAAlgoPatternMatching {


    /***
     * TODO  Complete Algo with Time complexity by 29th Jan 2020
     * This Algo is used to find all occurrences of pattern in given text
     * Complete Algo on 17th Jan 2020 must
     *
     * lps[i] = the longest proper prefix of pat[0..i]
     *               which is also a suffix of pat[0..i].
     *
     * Also calculate its Time complexity
     * @param initialTable
     * @param distinctChars
     * @return
     */
    public static int[][] buildFATable(int[][] initialTable, char[] distinctChars, int totalStates, String pattern, int[] resetFunctionForPattern) {
        int currentStateIndex = 0;
        while (currentStateIndex < totalStates) {
            String currentPattern = pattern.substring(0, currentStateIndex + 1);
            int currentPatternLength = currentPattern.length();
            int j = 0;
            for (char ch2 : distinctChars) {
                initialTable[currentStateIndex][j] = calculateResetValForCharAtCurrentIndex(ch2, currentPatternLength, resetFunctionForPattern, pattern.toCharArray());
                ++j;
            }
            ++currentStateIndex;
        }
        int j = 0;
        for (char ch2 : distinctChars) {
            initialTable[currentStateIndex][j] = calculateResetValForCharAtCurrentIndex(ch2, pattern.length(), resetFunctionForPattern, pattern.toCharArray());
            ++j;
        }
        return initialTable;
    }

    //TODO Calculate Time complexity
    private static int[] buildResetTableForPattern(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] resetVal = new int[chars.length];
        int i = 1, j = 0;
        resetVal[0] = 0;
        while (i < chars.length) {
            if (chars[i] == chars[j]) {
                resetVal[i] = ++j;
                ++i;
            } else if (j > 0) {
                j = resetVal[j - 1];
            } else {
                resetVal[i] = 0;
                ++i;
            }
        }
        return resetVal;
    }

    //TODO Complete this method
    //TODO Calculate Time complexity
    private static int calculateResetValForCharAtCurrentIndex(char currentChar, int currentIndex, int[] resetFunction, char[] patternChar) {
        if (currentChar == patternChar[currentIndex - 1]) {
            return currentIndex;
        }
        if (currentIndex > 1) {
            int j = resetFunction[currentIndex - 2];
            if (currentChar == patternChar[j]) {
                return ++j;
            } else if (j > 0) {
                return resetFunction[j - 1];
            }
        }
        return 0;
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
        int[] resetFunctionForPattern = FAAlgoPatternMatching.buildResetTableForPattern(pattern);
        int numberOfStates = pattern.length();
        char[] distinctChars = distinctChars(pattern);
        int[][] initialTable = new int[numberOfStates + 1][distinctChars.length];
        buildFATable(initialTable, distinctChars, numberOfStates, pattern, resetFunctionForPattern);
    }
}

package com.lalit.algorithm.pattern.matching;

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

    public static void main(String... s) {
        KMPAlgo.resetIndexArray("ababababab");
    }
}

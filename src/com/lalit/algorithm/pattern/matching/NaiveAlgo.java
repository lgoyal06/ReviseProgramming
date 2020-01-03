package com.lalit.algorithm.pattern.matching;

/*
 * This is Navie algo to perform pattern matching
 * this algo has timne complexity of  O(mn)
 * where m = pattern size
 * n = string size
 * */
public final class NaiveAlgo {

    private NaiveAlgo() {

    }

    public static final boolean patternMatcher(String content, String pattern) {
        int j = 0;
        for (int i = 0; i < content.length()-pattern.length()+1; ++i) {
            for (; j < pattern.length(); ++j) {
                if (content.charAt(i) == pattern.charAt(j)) {
                    ++i;
                } else {
                    break;
                }
            }
            if (j == pattern.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String... s) {
        System.out.println(NaiveAlgo.patternMatcher("ABCDEFGHI", "KI"));
    }
}

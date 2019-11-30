package com.lalit.system.design.tinyurl;

import java.util.HashMap;
import java.util.Map;

public class Base64Mapper {

    private static final Map<Integer, Character> digitToRadix64CharMap = new HashMap<>();
    private static final Map<Character, Integer> radix64CharToDigitMap = new HashMap<>();

    static {
        digitToRadix64CharMap.put(0, '0');
        digitToRadix64CharMap.put(1, '1');
        digitToRadix64CharMap.put(2, '2');
        digitToRadix64CharMap.put(3, '3');
        digitToRadix64CharMap.put(4, '4');
        digitToRadix64CharMap.put(5, '5');
        digitToRadix64CharMap.put(6, '6');
        digitToRadix64CharMap.put(7, '7');
        digitToRadix64CharMap.put(8, '8');
        digitToRadix64CharMap.put(9, '9');
        digitToRadix64CharMap.put(10, 'a');
        digitToRadix64CharMap.put(11, 'b');
        digitToRadix64CharMap.put(12, 'c');
        digitToRadix64CharMap.put(13, 'd');
        digitToRadix64CharMap.put(14, 'f');
        digitToRadix64CharMap.put(15, 'g');
        digitToRadix64CharMap.put(16, 'h');
        digitToRadix64CharMap.put(17, 'i');
        digitToRadix64CharMap.put(18, 'j');
        digitToRadix64CharMap.put(19, 'k');
        digitToRadix64CharMap.put(20, 'l');
        digitToRadix64CharMap.put(21, 'm');
        digitToRadix64CharMap.put(22, 'n');
        digitToRadix64CharMap.put(23, 'o');
        digitToRadix64CharMap.put(24, 'p');
        digitToRadix64CharMap.put(25, 'q');
        digitToRadix64CharMap.put(26, 'r');
        digitToRadix64CharMap.put(27, 's');
        digitToRadix64CharMap.put(28, 't');
        digitToRadix64CharMap.put(29, 'u');
        digitToRadix64CharMap.put(30, 'v');
        digitToRadix64CharMap.put(31, 'w');
        digitToRadix64CharMap.put(32, 'x');
        digitToRadix64CharMap.put(33, 'y');
        digitToRadix64CharMap.put(34, 'z');
        digitToRadix64CharMap.put(35, 'A');
        digitToRadix64CharMap.put(36, 'B');
        digitToRadix64CharMap.put(37, 'C');
        digitToRadix64CharMap.put(38, 'D');
        digitToRadix64CharMap.put(39, 'E');
        digitToRadix64CharMap.put(40, 'F');
        digitToRadix64CharMap.put(41, 'G');
        digitToRadix64CharMap.put(42, 'H');
        digitToRadix64CharMap.put(43, 'I');
        digitToRadix64CharMap.put(44, 'J');
        digitToRadix64CharMap.put(45, 'K');
        digitToRadix64CharMap.put(46, 'L');
        digitToRadix64CharMap.put(47, 'M');
        digitToRadix64CharMap.put(48, 'N');
        digitToRadix64CharMap.put(49, '$');
        digitToRadix64CharMap.put(50, 'O');
        digitToRadix64CharMap.put(51, 'P');
        digitToRadix64CharMap.put(52, 'Q');
        digitToRadix64CharMap.put(53, 'R');
        digitToRadix64CharMap.put(54, 'S');
        digitToRadix64CharMap.put(55, 'T');
        digitToRadix64CharMap.put(56, 'U');
        digitToRadix64CharMap.put(57, 'V');
        digitToRadix64CharMap.put(58, 'W');
        digitToRadix64CharMap.put(59, 'X');
        digitToRadix64CharMap.put(60, 'Y');
        digitToRadix64CharMap.put(61, 'Z');
        digitToRadix64CharMap.put(62, '@');
        digitToRadix64CharMap.put(63, '#');
    }

    static {
        for (Map.Entry<Integer, Character> entry : digitToRadix64CharMap.entrySet()) {
            radix64CharToDigitMap.put(entry.getValue(), entry.getKey());
        }
    }

    public static Character getBase64(int value) {
        return digitToRadix64CharMap.get(value);
    }

    public static int getDigit(Character radix64) {
        return radix64CharToDigitMap.get(radix64);
    }
}

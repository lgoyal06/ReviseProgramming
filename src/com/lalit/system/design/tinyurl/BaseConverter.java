package com.lalit.system.design.tinyurl;

public class BaseConverter {

    public static String fromBase10to64(int id) {
        StringBuilder str = new StringBuilder();
        while (id > 0) {
            int digit = id % 64;
            str = str.insert(0, Base64Mapper.getBase64(digit));
            id = id / 64;
        }
        return str.toString();
    }

    public static int fromBase64to10(String base64Text) {
        StringBuilder binaryString = new StringBuilder();
        for (char character : base64Text.toCharArray()) {
            int digit = Base64Mapper.getDigit(character);
            binaryString = binaryString.append(toBase2(digit));
        }
        return fromBase2To10(binaryString);
    }

    private static int fromBase2To10(StringBuilder binaryString) {
        int id = 0;
        int countLen = binaryString.toString().toCharArray().length;
        for (char ch : binaryString.toString().toCharArray()) {
            if ((ch == '1')) {
                id += Math.pow(2, countLen - 1);
            }
            --countLen;
        }
        return id;
    }

    private static StringBuilder toBase2(int digit) {
        StringBuilder sb = new StringBuilder();
        while (digit > 0) {
            sb.insert(0, digit % 2);
            digit = digit / 2;
        }
        int len = sb.length();
        while (len < 6) {
            sb.insert(0, '0');
            ++len;
        }
        return sb;
    }

}

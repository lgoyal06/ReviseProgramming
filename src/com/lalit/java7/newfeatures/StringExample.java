package com.lalit.java7.newfeatures;

public class StringExample {

    public static void main(String... s) {
        String a = "abc";
        String b = "abc";
        String c = new String("bcd");
        String d = new String("bcd");
        System.out.println(a == b);
        System.out.println(a.equalsIgnoreCase(b));
        System.out.println(c == d);
        System.out.println(c.intern() == d.intern());
        System.out.println(c.equalsIgnoreCase(d));
        System.out.println(c.toString() == d.toString());
        System.out.println(c.substring(1) == d.substring(1));
        System.out.println(a.toString() == b.toString());
        System.out.println(a.substring(1) == b.substring(1));
        System.out.println(a);
        System.out.println(c);
    }
}

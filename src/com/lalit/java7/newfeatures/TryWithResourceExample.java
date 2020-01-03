package com.lalit.java7.newfeatures;

public class TryWithResourceExample {

    public static void main(String... s) {
        try (Lion lion = new Lion(); Tiger tiger = new Tiger()) {
            lion.hunting();
            tiger.hunting();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("In finally");
        }
    }

}

class Lion implements AutoCloseable {


    public void hunting() throws Exception {
        System.out.println("Lion is Hunting Deer");
        throw new Exception("Hunting lion throws exception");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing Lion Resource");
        throw new Exception("Closing is throwing exception");
    }
}

class Tiger implements AutoCloseable {

    public void hunting() throws Exception {
        System.out.println("Tiger is Hunting Deer");
        throw new Exception("Hunting tiger throws exception");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing Tiger Resource");
        throw new Exception("Closing is throwing exception");
    }
}
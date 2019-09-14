package com.lalit.java8.newfeatures.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Lambda can be used only with Functional Interfaces i.e. interfaces containing only one abstract method
 **/
public class LambdaUsageClass {
    interface Button {
        String click();
    }

    public static void main(String... s) {
        Button button = new Button() {
            @Override
            public String click() {
                return "Done";
            }
        };
        TestClass ts = new TestClass() {
            @Override
            public String test(String content) {
                return content + "23";
            }
        };
        Button button1 = () -> "Done with Lambda";
        TestInterface testInterface = (String content) -> content + " Using Lambda ";
        System.out.println(button.click());
        System.out.println(button1.click());
        System.out.println(testInterface.test("Hello"));
        System.out.println(ts.test("Hi!World"));
        //Using Lambda in Collections
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("M", 34));
        personList.add(new Person("F", 3));
        personList.add(new Person("O", 33));
        personList.stream().filter(p -> p.getAge() > 10 || p.getGender().equalsIgnoreCase("M")).map(p -> p.getGender()).forEach(gender -> System.out.println(gender)
        );
    }
}

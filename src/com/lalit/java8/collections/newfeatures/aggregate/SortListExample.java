package com.lalit.java8.collections.newfeatures.aggregate;


//import sun.lwawt.macosx.CSystemTray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee implements Comparable<Employee> {
    private int age;
    private char sex;
    private String name;

    public Employee(int age, char sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName() + "---" + this.getAge() + "----" + this.getSex();
    }

    @Override
    public int compareTo(Employee o) {
        return this.age - o.age;
    }
}

class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getName().compareTo(o1.getName());
    }
}

public class SortListExample {

    public static void main(String... s) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(28, 'M', "Sameer"));
        employees.add(new Employee(24, 'F', "Tanvi"));
        employees.add(new Employee(21, 'M', "Sumit"));
        Collections.sort(employees);
        employees.stream().forEach(e -> System.out.println(e));
        Collections.sort(employees, new NameComparator());
        employees.stream().forEach(e -> System.out.println(e));
        String value = Stream.of("a", "b", "c").collect(Collectors.joining());
        System.out.println(value);
    }
}

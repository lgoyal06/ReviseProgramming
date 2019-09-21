package com.lalit.java8.collections.newfeatures.aggregate;

public class Person implements Comparable {

    int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    String name ;
    String sex;

    public Person(int age, String name, String sex, String birthPlace) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.birthPlace = birthPlace;
    }

    String birthPlace;

    @Override
    public int compareTo(Object o) {
        if(this.getAge()>((Person)o).getAge()){
            return 1;
        } else if(this.getAge()<((Person)o).getAge()){
            return -1;
        }else {
            return 0;
        }
    }
}

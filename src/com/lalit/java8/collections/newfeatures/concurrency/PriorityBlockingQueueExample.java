package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;


class SortBySexComparatorAscending implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSex().compareTo(o2.getSex());
    }
}

class Student implements Comparable<Student> {

    public Student(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    int age;
    String sex;

    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}

public class PriorityBlockingQueueExample {

    public static void main(String... s) {
        PriorityBlockingQueue<Student> pq = new PriorityBlockingQueue<>();
        pq.add(new Student(12, "Male"));
        pq.add(new Student(13, "Male"));
        pq.add(new Student(15, "Female"));
        for (int i = 0; i < 3; ++i) {
            System.out.println(pq.poll().getAge());
        }
        System.out.println("----------------");
        PriorityBlockingQueue<Student> pq1 = new PriorityBlockingQueue<>(12, new SortBySexComparatorAscending());
        pq1.add(new Student(12, "Male"));
        pq1.add(new Student(13, "Male"));
        pq1.add(new Student(15, "Female"));
        for (int i = 0; i < 3; ++i) {
            System.out.println(pq1.poll().getAge());
        }
    }
}

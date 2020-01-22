package com.lalit.java7.newfeatures;

import java.util.*;

public class MainClass {

    public static void main(String... s) {
        Student student = new Student("Lalit", 30);
        Student student1 = new Student("Lalit", 30);
        Student student2 = student;
        /**HashMap<Student, String> hashMap = new HashMap();
         hashMap.put(student, student.getName());
         hashMap.put(student1, student1.getName());
         System.out.println(hashMap.size());
         System.out.println(hashMap.containsKey(student1));
         List<Student> list = new ArrayList<>();
         list.add(student);
         list.add(student1);
         System.out.println(list.contains(student));
         Set<Student> studentSet = new HashSet<>();
         studentSet.add(student);
         //    studentSet.add(student1);
         System.out.println(studentSet.contains(student1));
         System.out.println(student.hashCode());
         System.out.println(student1);*/
        System.out.println(student);
        System.out.println(student1);
        System.out.println(student == student2);
        System.out.println(student.equals(student1));
    }
}

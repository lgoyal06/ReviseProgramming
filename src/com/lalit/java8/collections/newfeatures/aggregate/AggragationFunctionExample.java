package com.lalit.java8.collections.newfeatures.aggregate;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class AggragationFunctionExample {

    static class Shapes {
        String color;
        int edges;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getEdges() {
            return edges;
        }

        public void setEdges(int edges) {
            this.edges = edges;
        }

        public int getVetices() {
            return vetices;
        }

        public void setVetices(int vetices) {
            this.vetices = vetices;
        }

        int vetices;
    }

    public static void main(String... s) {
        List<Shapes> myShapeCollection = new ArrayList<>();
        Shapes shape = new Shapes();
        Shapes shape1 = new Shapes();
        Shapes shape2 = new Shapes();
        shape.color = "Red";
        shape1.color = "White";
        shape2.color = "Green";
        shape.edges = 3;
        shape1.edges = 4;
        shape2.edges = 5;
        shape.vetices = 3;
        shape1.vetices = 4;
        shape2.vetices = 5;
        myShapeCollection.add(shape);
        myShapeCollection.add(shape1);
        myShapeCollection.add(shape2);

        myShapeCollection.stream().filter(e -> !e.getColor().equalsIgnoreCase("Red")).forEach(e -> System.out.println(e.getColor()));
        String joined = myShapeCollection.stream().map(e -> Objects.toString(e)).collect(Collectors.joining(","));
        System.out.println(joined);
        System.out.println("-----------------------------------------------------------");
        myShapeCollection.stream().map(e -> e.getEdges()).forEach(e -> System.out.println(e));
        double double1 = myShapeCollection.stream().mapToInt(e -> e.getEdges()).average().getAsDouble();
        System.out.println(double1);

        Person per = new Person(23, "lalit",  "Male",  "kaithal");
        Person per1 = new Person(34, "lalit1",  "Male",  "kaithal1");
        Person per2 = new Person(33, "lalit2",  "Male",  "kaithal2");
        Person per3 = new Person(22, "lalit3",  "Male",  "kaithal3");
        List<Person> personList = new ArrayList<>();
        personList.add(per);
        personList.add(per1);
        personList.add(per2);
        personList.add(per3);

        //personList.stream().forEach(p->System.out.println(p.getAge()));
         //Collections.sort(personList);
        personList.stream().sorted().filter(p->p.getAge()>22).map(Person::getAge).collect(Collectors.toList()).forEach(p->System.out.println(p));
        personList.parallelStream().sorted().filter(p->p.getAge()>22).map(Person::getAge).collect(Collectors.toList()).forEach(p->System.out.println(p));
        ConcurrentMap map = personList.parallelStream().collect(Collectors.groupingByConcurrent(Person::getSex));
    }
}

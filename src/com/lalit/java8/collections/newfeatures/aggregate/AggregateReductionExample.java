package com.lalit.java8.collections.newfeatures.aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AggregateReductionExample {

    public static void main(String ...s){

        List<Person> listOfPerson = new ArrayList<>();
        listOfPerson.add(new Person(23,"TestA","Male","USA"));
        listOfPerson.add(new Person(24,"TestB","Female","JAPAN"));
        listOfPerson.add(new Person(25,"TestC","Male","RUSSIA"));
        listOfPerson.add(new Person(26,"TestD","Male","INDIA"));
        double average = listOfPerson.stream().filter(e->e.age>23).mapToInt(Person::getAge).average().getAsDouble();
        System.out.println(average);
        Map<String, Integer> totalAgeByGender =
                listOfPerson
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getSex,
                                        Collectors.reducing(
                                                0,
                                                Person::getAge,
                                                Integer::sum)));
        totalAgeByGender.forEach((k,v)->System.out.println(k));
    }

}

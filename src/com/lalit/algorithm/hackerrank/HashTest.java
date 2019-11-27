package com.lalit.algorithm.hackerrank;

import java.util.HashSet;
import java.util.Set;

class Employee {
    private int id = 0;

    public Employee(int id) {
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int hashCode(){
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Employee) {
            return this.getId() == ((Employee) o).getId();
        }
        return false;
    }
}

public class HashTest {

    public static void main(String[] args) {
        Set<Employee> hset = new HashSet<>();
        String[] values = new String[]{"20", "20", "20"};
        for (String v : values) {
            hset.add(new Employee(Integer.parseInt(v)));
        }

        System.out.println(hset.size());
    }

}

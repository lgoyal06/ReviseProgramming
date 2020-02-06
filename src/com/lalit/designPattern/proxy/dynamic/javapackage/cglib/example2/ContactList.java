package com.lalit.designPattern.proxy.dynamic.javapackage.cglib.example2;

import java.util.ArrayList;
import java.util.List;


//We want to defer loading of employee list until required
public class ContactList {

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        if (employees == null) {
            setEmployees();
        }
        return employees;
    }

    private void setEmployees() {
        //Load from DB
        System.out.println("Loading Employee from DB");
        List<Employee> listEmployee = new ArrayList<>();
        listEmployee.add(new Employee(23, "A", "M"));
        listEmployee.add(new Employee(23, "B", "F"));
        listEmployee.add(new Employee(23, "C", "M"));
        listEmployee.add(new Employee(23, "D", "O"));

        this.employees = listEmployee;
    }


}

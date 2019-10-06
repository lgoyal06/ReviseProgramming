package com.lalit.convertors.test;

import java.util.ArrayList;
import java.util.LinkedList;

public class PersonObj {

    public LinkedList<Addresses> getAddressesLinkedList() {
        return addressesLinkedList;
    }

    public ArrayList<String> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<String> education) {
        this.education = education;
    }

    private ArrayList<String> education;

    public void setAddressesLinkedList(LinkedList<Addresses> addressesLinkedList) {
        this.addressesLinkedList = addressesLinkedList;
    }

    private LinkedList<Addresses> addressesLinkedList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Addresses getAddressObj() {
        return addressObj;
    }

    public void setAddressObj(Addresses addressObj) {
        this.addressObj = addressObj;
    }

    public Addresses addressObj;
    String name;
    String age;

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    String[] address;
}

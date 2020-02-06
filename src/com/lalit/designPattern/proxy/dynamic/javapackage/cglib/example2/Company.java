package com.lalit.designPattern.proxy.dynamic.javapackage.cglib.example2;

public class Company {

    String companyName;
    String companyAddress;
    String companyContactNo;
    ContactList contactList;

    public Company() {
    }

    public Company(String companyName, String companyAddress, String companyContactNo, ContactList contactList) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyContactNo = companyContactNo;
        this.contactList = contactList;
    }


}

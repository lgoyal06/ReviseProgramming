package com.lalit.designPattern.proxy.dynamic.javapackage.cglib.example2;

import net.sf.cglib.proxy.Enhancer;

public class ClientClass {

    public static void main(String... s) throws ClassNotFoundException {

        Interceptor interceptor = new Interceptor();
        Enhancer e = new Enhancer();
        e.setSuperclass(Class.forName("com.lalit.designPattern.proxy.dynamic.javapackage.cglib.example2.ContactList"));
        e.setCallback(interceptor);

        ContactList contactList = (ContactList) e.create();
        Company company = new Company("A", "Syndey", "9891237529", contactList);

        System.out.println(company.companyAddress);
        System.out.println(company.contactList);
        System.out.println(company.contactList.getEmployees().get(0).sex);
    }
}

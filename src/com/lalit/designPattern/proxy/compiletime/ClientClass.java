package com.lalit.designPattern.proxy.compiletime;

public class ClientClass {

    public static void main(String... s) {
        Company company = new Company("A", "Syndey", "9891237529", new ContactListProxy());
        System.out.println(company.companyAddress);
        System.out.println(company.contactList);
        System.out.println(company.contactList.getEmployees().get(0).sex);
    }
}

package com.lalit.designPattern.proxy.compiletime;

import java.util.List;

public class ContactListProxy extends ContactList {

    ContactList contactList;

    public List<Employee> getEmployees() {
        if (contactList == null) {
            contactList = new ContactList();
        }
        return contactList.getEmployees();
    }

}

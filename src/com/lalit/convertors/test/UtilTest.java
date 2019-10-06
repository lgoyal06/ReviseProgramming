package com.lalit.convertors.test;

import com.lalit.convertors.ObjectToJsonStringConvertor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UtilTest {

    public static void main(String ...s) throws IllegalAccessException {

        PersonObj obj = new PersonObj();
        obj.setAge("23");
        obj.setName("Name");
        obj.setAddress(new String[]{"a1","s2","d3"});
        Addresses add  = new Addresses();
        add.setLocation("dfd");
        add.setPincode("34340");
        PhoneObj phones = new PhoneObj("fax","modile");
        add.setPhone(phones);
        obj.setAddressObj(add);
        Addresses add1  = new Addresses();
        add1.setLocation("dfd1");
        add1.setPincode("34341");
        add1.setPhone(phones);
        Addresses add2  = new Addresses();
        add2.setLocation("dfd2");
        add2.setPincode("34342");
        add2.setPhone(phones);
        LinkedList<Addresses> addList = new LinkedList<>();
        addList.add(add1);
        addList.add(add2);
        obj.setAddressesLinkedList(addList);

        ArrayList<String> list = new ArrayList<>();
        list.add("higher_education");
        list.add("secondary_education");
        obj.setEducation(list);

        String json = new ObjectToJsonStringConvertor(obj).parse().buildJson().toString();
        System.out.println(json);
    }
}

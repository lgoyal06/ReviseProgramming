package com.lalit.designPattern.proxy.dynamic.javapackage.cglib;

public class Auditor {

    public void audit(String service, String extraData) {
        System.out.println("Service named " + service + " audited with extra data " + extraData);
    }
}

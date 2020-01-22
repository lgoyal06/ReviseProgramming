package com.lalit.designPattern.proxy.dynamic.javapackage;

public class Auditor {

    public void audit(String service, String extraData) {
        System.out.println("Service named " + service + " audited with extra data " + extraData);
    }
}

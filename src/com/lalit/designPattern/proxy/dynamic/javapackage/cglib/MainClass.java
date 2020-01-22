package com.lalit.designPattern.proxy.dynamic.javapackage.cglib;

import net.sf.cglib.proxy.Enhancer;

public class MainClass {

    public static void main(String... s) {
        Auditor auditor = new Auditor();
        AuditInterceptor interceptor = new AuditInterceptor(auditor, "dfddfdf");
        Enhancer e = new Enhancer();
        e.setSuperclass(Calculator.class);
        e.setCallback(interceptor);
        Calculator calc = (Calculator) e.create();
        calc.add(2, 2); // Will be audited
    }
}

package com.lalit.designPattern.proxy.dynamic.javapackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainClass {

    public static void main(String... s) {
        Auditor auditor = new Auditor();
        Calculator calculatorReal = new CalculatorImpl();
        InvocationHandler handler = new AuditInvocationHandler(auditor, calculatorReal);
        Calculator proxy = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Calculator.class}, handler);
        System.out.println(calculatorReal.add(3, 4));
        System.out.println(proxy.add(3, 4));
    }
}

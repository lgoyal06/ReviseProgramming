package com.lalit.designPattern.proxy.dynamic.javapackage.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AuditInterceptor implements MethodInterceptor {

    Auditor auditor;
    String service;

    public AuditInterceptor(Auditor auditor, String service) {
        this.auditor = auditor;
        this.service = service;
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        auditor.audit(target.getClass().getName(), "before" + method.getName());
        Object returnObject = proxy.invokeSuper(target, args);
        auditor.audit(target.getClass().getName(), "after" + method.getName());
        return returnObject;
    }
}

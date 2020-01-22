package com.lalit.designPattern.proxy.dynamic.javapackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AuditInvocationHandler implements InvocationHandler {

    Auditor auditor;
    Object target;

    public AuditInvocationHandler(Auditor auditor, Object target) {
        this.auditor = auditor;
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        auditor.audit(target.getClass().getName(), "before" + method.getName());
        Object returnObject = method.invoke(target, args);
        auditor.audit(target.getClass().getName(), "after" + method.getName());
        return returnObject;
    }
}

package com.lalit.designPattern.proxy.dynamic.javapackage.cglib.example2;

import com.lalit.designPattern.proxy.dynamic.javapackage.cglib.Auditor;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Interceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object returnObject = proxy.invokeSuper(target, args);
        return returnObject;
    }
}

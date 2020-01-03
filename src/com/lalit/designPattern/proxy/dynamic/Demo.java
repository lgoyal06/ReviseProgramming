package com.lalit.designPattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

interface Human {
    void talking();

    void walking();
}

class Person implements Human {

    @Override
    public void talking() {
        System.out.println("I am talking");
    }

    @Override
    public void walking() {
        System.out.println("I am walking");
    }
}

class LoggerHandler implements InvocationHandler {

    Map<String, Integer> calls = new HashMap<>();
    Object target;

    public LoggerHandler(Object target) {
        this.target = target;
    }

    BiFunction<Integer, Integer, Integer> biFunction = new BiFunction<Integer, Integer, Integer>() {
        @Override
        public Integer apply(Integer integer, Integer integer2) {
            return integer + integer2;
        }
    };

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if (name.contains("toString")) {
            return calls.toString();
        }
        calls.merge(name, 1, biFunction::apply);
        return method.invoke(target, args);
    }
}

public class Demo {

    public static <T> T withLogging(T target, Class<T> itf) {
        return (T) Proxy.newProxyInstance(itf.getClassLoader(), new Class<?>[]{itf}, new LoggerHandler(target));
    }

    public static void main(String... s) {

        Person person = new Person();
        Human humanLoggedProxyObj = withLogging(person, Human.class);
        humanLoggedProxyObj.walking();
        humanLoggedProxyObj.talking();
        humanLoggedProxyObj.walking();
        System.out.println(humanLoggedProxyObj);
    }
}

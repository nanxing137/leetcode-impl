package com.acouchis.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyTestHandler implements InvocationHandler {

    private Object o;

    public ProxyTestHandler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy start");
        method.invoke(o, args);
        System.out.println("proxy end");
        return null;
    }
}
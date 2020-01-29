package com.acouchis.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * Created by gaopeng09 on 2020-01-20
 */
public class ProxyJDK implements PrintAble {

    @Override
    public void print() {
        System.out.println("print");
    }

    private void neighborhood() {
        System.out.println("a neighborhood");
        print();
    }



    public static void main(String[] args) {
        ProxyJDK proxyJDK = new ProxyJDK();
        ProxyTestHandler proxyTestHandler = new ProxyTestHandler(proxyJDK);
        PrintAble o = (PrintAble)Proxy.newProxyInstance(proxyTestHandler.getClass().getClassLoader(),
                ProxyJDK.class.getInterfaces(),
                proxyTestHandler);
        System.out.println(o.getClass());
//        o.print();
//        System.out.println("********");
//        proxyJDK.neighborhood();
        proxyJDK.print();
    }

}

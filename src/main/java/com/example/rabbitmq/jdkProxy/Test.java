package com.example.rabbitmq.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @author Chenger
 * @description
 * @date 2022/7/11 上午11:22
 */
public class Test {

    public static void main(String[] args) {
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(new TargetObject());
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(TargetObject.class.getClassLoader(), TargetObject.class.getInterfaces(), invocationHandler);
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        proxy.test();
    }
}

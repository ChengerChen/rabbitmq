package com.example.rabbitmq.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Chenger
 * @description
 * @date 2022/7/11 上午11:23
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private TargetInterface targetObject;

    public InvocationHandlerImpl(TargetInterface targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行目标方法之前操作");
        targetObject.test();
        System.out.println("执行目标方法之后操作");
        return null;
    }
}

package com.example.rabbitmq.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Chenger
 * @description
 * @date 2021/7/14 下午5:11
 */
public class CglibProxyTests implements MethodInterceptor {

    private static Object staticObj;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理方法执行");
        // 被代理对象内部方法互相调用会触发拦截器
        return methodProxy.invokeSuper(o, objects);
        // 被代理对象内部方法互相调用不会触发拦截器
//        return methodProxy.invoke(staticObj, objects);
    }

    public Object createProxyObject(Object obj) {
        staticObj = obj;
        Enhancer enhancer = new Enhancer();
        // 设置需要代理的类
        enhancer.setSuperclass(staticObj.getClass());
        // 设置callback，也就是代理类的方法被调用时会执行的逻辑
        /**
         * callback有几种类型
         * MethodInterceptor
         * NoOp
         * LazyLoader
         * Dispatcher
         * InvocationHandler
         * FixedValue
         * 借鉴 https://blog.csdn.net/qq_28834355/article/details/111410810
         */
        enhancer.setCallback(this);
        // 生成代理对象
        return enhancer.create(new Class[]{String.class, int.class}, new Object[]{"Chenger", 26});
    }
}

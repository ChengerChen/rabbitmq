package com.example.rabbitmq.AnnotationImport;

/**
 * @author Chenger
 * @description
 * @date 2022/5/29 下午4:07
 */
public class ServiceB implements ServiceInterface {

    @Override
    public void test() {
        System.out.println("ServiceB Method");
    }
}

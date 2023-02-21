package com.example.rabbitmq.AnnotationImport;

import javax.annotation.PostConstruct;

/**
 * @author Chenger
 * @description
 * @date 2022/6/22 下午11:45
 */
public class Test {

    public static final String NAME = "my Name Is Chenger";

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("非静态代码块");
    }

    @PostConstruct
    public void test() {
        System.out.println("PostConstruct注解的非bean方法");
    }
}

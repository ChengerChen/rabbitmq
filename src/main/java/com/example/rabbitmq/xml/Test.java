package com.example.rabbitmq.xml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Chenger
 * @description
 * @date 2022/7/4 下午4:36
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        BeanA beanA = classPathXmlApplicationContext.getBean(BeanA.class);
        beanA.test();
        classPathXmlApplicationContext.refresh();
    }
}

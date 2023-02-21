package com.example.rabbitmq.AnnotationImport;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * @author Chenger
 * @description
 * @date 2022/5/29 下午4:08
 */
public class MainTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Scanner input=new Scanner(System.in);
        input.hasNext();
        String str = input.next();


        // 1.A.class 2.object.getClass() 3.Class.forName("类路径")
        Class<?> aClass = Class.forName("com.example.rabbitmq.AnnotationImport.ServiceA");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor((Class[]) null);
        ServiceA o = (ServiceA) declaredConstructor.newInstance();
        o.test();

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigA.class);
        ServiceInterface bean = annotationConfigApplicationContext.getBean(ServiceInterface.class);
        bean.test();

        System.out.println(123);
        // 测试常量 反编译之后是什么样的
        System.out.println(Test.NAME);

        new Thread(() -> {
            bean.a();
        }).start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }
        bean.b();

        new Test();

        Test test = new Test();




    }
}

package com.example.rabbitmq.AnnotationImport;

/**
 * @author Chenger
 * @description
 * @date 2022/5/29 下午4:06
 */
public interface ServiceInterface {

    /**
     * 输出方法
     */
    void test();

    default void a() {

    }

    default void b() {

    }
}

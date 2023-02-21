package com.example.rabbitmq.jdkProxy;

/**
 * @author Chenger
 * @description
 * @date 2022/7/11 上午11:22
 */
public class TargetObject implements TargetInterface {

    @Override
    public void test() {
        System.out.println("目标方法执行");
    }
}

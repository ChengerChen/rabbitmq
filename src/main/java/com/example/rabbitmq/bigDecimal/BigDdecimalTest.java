package com.example.rabbitmq.bigDecimal;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chenger
 * @description
 * @date 2022/6/4 上午11:36
 */
public class BigDdecimalTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        reentrantLock.lock();
        try {
            condition.await(3, TimeUnit.SECONDS);
        } finally {
            reentrantLock.unlock();
        }

        float f = 0.00000000000000000000000000000000000000000001f;

        char a = '9';
        BigDecimal bigDecimal = new BigDecimal("123123456789123456789");
        BigDecimal add = bigDecimal.add(new BigDecimal("1.1"));
        System.out.println(add);
        System.out.println(add.doubleValue());

    }
}

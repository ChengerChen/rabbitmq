package com.example.rabbitmq.AnnotationImport;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chenger
 * @description
 * @date 2022/5/29 下午4:07
 */
public class ServiceA implements ServiceInterface {

//    public ReentrantLock lock = new ReentrantLock();

    @Override
    public void test() {
        System.out.println("ServiceA Method");
    }

    @Override
    public synchronized void a() {
//        lock.lock();
        try {
            System.out.println(LocalDateTime.now() + " 执行a方法");
            // 持有锁进行等待
            Thread.sleep(5000);
            // 释放锁，进行等待
//            wait(5000);
        } catch (Exception e) {

        } finally {
//            lock.unlock();
        }
    }

    @Override
    public synchronized void b() {
//        lock.lock();
        try {
            System.out.println(LocalDateTime.now() + " 执行b方法");
        } catch (Exception e) {

        } finally {
//            lock.unlock();
        }
    }
}

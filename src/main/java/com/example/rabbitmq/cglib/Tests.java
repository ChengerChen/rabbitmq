package com.example.rabbitmq.cglib;

import java.util.Scanner;

/**
 * @author Chenger
 * @description
 * @date 2021/7/14 下午5:16
 */
public class Tests {

    public static void main(String[] args) {
        User proxyObject = (User) new CglibProxyTests().createProxyObject(new User("Chenger", 25));

        new Thread(() -> {
            proxyObject.hello();
        }).start();
//        proxyObject.hello();
//        proxyObject.setName("ChengerChen");
//        proxyObject.setAge(18);
//        proxyObject.hello();
//        test();


        long i = 0;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String next = scanner.next();
            if("abc".equals(next)) {
                i++;
            }
            i++;
            if(i % 500 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }

    }

}

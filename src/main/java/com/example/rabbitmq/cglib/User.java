package com.example.rabbitmq.cglib;

/**
 * @author Chenger
 * @description
 * @date 2021/7/14 下午5:09
 */
public class User {

    private String name;

    private int age;

    public void hello() {
        System.out.println("hhhh");
        test();
    }

    public void test() {
        System.out.println("test方法被执行。");
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

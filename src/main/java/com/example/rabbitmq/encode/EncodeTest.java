package com.example.rabbitmq.encode;

import sun.nio.cs.ext.GBK;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Chenger
 * @description
 * @date 2022/6/28 下午5:23
 */
public class EncodeTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        char a = '中';

        String str = "中";

        String gbk1 = URLEncoder.encode(str, "GBK");

        byte[] bytes = str.getBytes();

        String gbk2 = URLEncoder.encode(new String(bytes, "UTF-8"), "GBK");

        System.out.println(a);

        System.out.println(bytes);



        // 这是"你好"的gbk编码的字符串
        String s = "浣犲ソ";

        String ss = new String(s.getBytes("GBK"), "UTF-8");

        System.out.println(ss);

        String sss = URLEncoder.encode(new String(s.getBytes(), "GBK"), "UTF-8");

        System.out.println(sss);


        String test = "你好";
        String gbk = URLEncoder.encode(test, "GBK");
        System.out.println(gbk);

        gbk = URLEncoder.encode(new String(test.getBytes(), "UTF-8"), "GBK");
        System.out.println(gbk);

        String gbkTest = new String(test.getBytes(), "GBK");
        System.out.println(gbkTest);

    }
}

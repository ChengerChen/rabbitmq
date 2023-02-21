package com.example.rabbitmq.simpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Chenger
 * @description
 * @date 2022/6/27 下午5:42
 */
public class SimpleDateformatTest {

        private static ExecutorService executor = Executors.newCachedThreadPool();

        // 定义SimpleDateFormat为成员变量，不安全
        private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 使用成员变量转换，线程不安全
        public static String unSafeFormatDate(Date date) throws ParseException {
            return sdf.format(date);
        }

        // 使用成员变量转换，线程不安全
        public static Date unSafeParse(String strDate) throws ParseException {
            return sdf.parse(strDate);
        }

        // 每次转换都创建一个SimpleDateFormat，线程安全
        public static String safeFormatDate(Date date) throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }

        // 每次转换都创建一个SimpleDateFormat，线程安全
        public static Date safeParse(String strDate) throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(strDate);
        }

        public static void main(String[] args) {

            for (int i = 0; i < 30; i++) {
                executor.execute(() -> {
                    try {
                        Date date = new Date();
//                        System.out.println(Thread.currentThread().getName() + ":" + unSafeFormatDate(date));
                        System.out.println(Thread.currentThread().getName() + ":" + unSafeParse("2020-01-02 03:04:05"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

}

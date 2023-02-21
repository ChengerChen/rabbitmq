package com.example.rabbitmq;

import com.example.rabbitmq.jpa.JdbcUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chenger
 * @description
 * @date 2021/7/22 下午1:50
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcTests {

    @Test
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("version", "1dd7553e64a04d45bc0fb94edd6d59db");
        System.out.println(JdbcUtils.getSql("sql/healthPlan.ftl", map));
    }
}

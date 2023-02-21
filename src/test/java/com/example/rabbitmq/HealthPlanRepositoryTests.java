package com.example.rabbitmq;

import com.example.rabbitmq.controller.ResponseBodyTest;
import com.example.rabbitmq.jpa.HealthPlan;
import com.example.rabbitmq.jpa.HealthPlanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Chenger
 * @description
 * @date 2021/7/14 上午10:36
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class HealthPlanRepositoryTests {

    @Autowired
    private HealthPlanRepository healthPlanRepository;
    @Autowired
    private ResponseBodyTest responseBodyTest;

    @Test
    public void test() {
        List<HealthPlan> healthPlans = healthPlanRepository.findByVersion("1dd7553e64a04d45bc0fb94edd6d59db");
        System.out.println("test");
    }

}

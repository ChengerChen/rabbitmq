package com.example.rabbitmq.controller;

import com.example.rabbitmq.jpa.HealthPlan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chenger
 * @description
 * @date 2021/8/9 下午4:47
 */
@RestController
public class ResponseBodyTest {

    @GetMapping("response/test")
    public HealthPlan findHealthPlan() {
        return new HealthPlan();
    }
}

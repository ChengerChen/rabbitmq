package com.example.rabbitmq.AnnotationImport;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chenger
 * @description
 * @date 2022/5/29 下午4:07
 */
@Configuration
public class ConfigB {

    @Bean
    @ConditionalOnMissingBean
    public ServiceInterface getService() {
        return new ServiceB();
    }
}

package com.example.rabbitmq.AnnotationImport;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

/**
 * @author Chenger
 * @description
 * @date 2022/5/29 下午4:07
 */
@Configuration
//@Import(ConfigB.class)
// @Import(ServiceB.class)
public class ConfigA {
    @Bean
    @ConditionalOnMissingBean(ServiceInterface.class)

    public ServiceInterface getService() {
        return new ServiceA();
    }

}

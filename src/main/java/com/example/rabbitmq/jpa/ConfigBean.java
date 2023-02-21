package com.example.rabbitmq.jpa;

import com.example.rabbitmq.jpa.template.FreeMarkerLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chenger
 * @description
 * @date 2021/7/22 下午1:37
 */
@Configuration
public class ConfigBean {

    @Autowired
    private freemarker.template.Configuration configuration;

    /**
     * freemaker模板工具类
     *
     * @return
     */
    @Bean(name = "freeMarkerLoader")
    public FreeMarkerLoader freeMarkerLoader() {
        FreeMarkerLoader freeMarkerLoader = new FreeMarkerLoader();
        freeMarkerLoader.setConfiguration(configuration);
        configuration.setNumberFormat("#");
        return freeMarkerLoader;
    }

    @Bean
    public ApplicationContextHolder springContextHolder() {
        return new ApplicationContextHolder();
    }
}

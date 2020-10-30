package com.jk.config;

import org.apache.catalina.ThreadBindingListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {



    // 创建队列
    @Bean
    public Queue queueProjectList() {
        // 指定队列名称
        return new Queue("zf-projectList");
    }

    @Bean
    public Queue queueProject() {
        // 指定队列名称
        return new Queue("zf-project");
    }

    @Bean
    public Queue queueLog() {
        // 指定队列名称
        return new Queue("log-queue");
    }

}

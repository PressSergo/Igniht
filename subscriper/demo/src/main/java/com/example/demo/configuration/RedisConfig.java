package com.example.demo.configuration;

import com.example.demo.redisReceiving.MessageReceiving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.concurrent.Executors;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

    @Autowired
    Environment env;

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic(env.getProperty("topic.name"));
    }

    @Bean
    RedisMessageListenerContainer redisContainer(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(new MessageListenerAdapter(new MessageReceiving()), topic());
        container.setTaskExecutor(Executors.newFixedThreadPool(4));
        return container;
    }
}

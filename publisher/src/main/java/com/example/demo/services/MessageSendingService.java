package com.example.demo.services;

import com.example.demo.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class MessageSendingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSendingService.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ChannelTopic topic;

    public void sendDataToRedisQueue(Message message) {
        redisTemplate.convertAndSend(topic.getTopic(),message);
        LOGGER.info("Data - " + message.toString() + " sent through Redis Topic - " + topic.getTopic());
    }
}

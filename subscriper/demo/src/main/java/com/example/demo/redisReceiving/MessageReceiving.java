package com.example.demo.redisReceiving;

import com.example.demo.domain.BaseEntity;
import com.example.demo.services.ManipulateDomainServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageReceiving implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiving.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    ManipulateDomainServices manipulateDomainServices;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        try {
            manipulateDomainServices.saveDomain(objectMapper.readValue(message.getBody(), BaseEntity.class));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(),e);
        }
        LOGGER.info("save object "+ message.getBody());
    }
}

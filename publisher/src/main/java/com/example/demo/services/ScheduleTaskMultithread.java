package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ScheduleTaskMultithread {

    @Autowired
    RandomServicesGeneration randomServicesGeneration;

    @Autowired
    MessageSendingService messageSendingService;

    public void runTask(){
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);

        for(int i = 0; i< 100; i++){
            ses.schedule(()->messageSendingService.sendDataToRedisQueue(randomServicesGeneration.getRandomMessage()),15, TimeUnit.SECONDS);
        }

        ses.shutdown();
    }
}

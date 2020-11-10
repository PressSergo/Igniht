package com.example.demo.controller;

import com.example.demo.services.MessageSendingService;
import com.example.demo.services.RandomServicesGeneration;
import com.example.demo.services.ScheduleTaskMultithread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedisController {

    @Autowired
    MessageSendingService messageSendingService;

    @Autowired
    RandomServicesGeneration randomServicesGeneration;

    @Autowired
    ScheduleTaskMultithread scheduleTaskMultithread;

    @RequestMapping(method = RequestMethod.GET,value = "/redis")
    public ResponseEntity<String> sendDataToRedisQueue() {
        scheduleTaskMultithread.runTask();
        return ResponseEntity.ok().build();
    }
}

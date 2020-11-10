package com.example.demo.services;

import com.example.demo.domain.Message;
import com.example.demo.domain.actions.Action;
import org.springframework.stereotype.Service;

@Service
public class RandomServicesGeneration {

    private static Long NEXT_ID = 0l;

    public Long getNextId(){
        return NEXT_ID++;
    }

    public Long getRandomMsisdn(Long down, Long upper){
        return upper + (int)Math.random()*down;
    }

    public Action getRandomAction(){
        return Action.values()[(int)(Math.random() * Action.values().length)];
    }

    public Message getRandomMessage(){
        return new Message(getNextId(),getRandomMsisdn(10l,1000l),getRandomAction());
    }
}

package com.example.demo.services;

import com.example.demo.domain.BaseEntity;
import com.example.demo.domain.Purchase;
import com.example.demo.domain.Subscription;
import com.example.demo.domain.actions.Action;
import com.example.demo.repositories.PurchaseRepository;
import com.example.demo.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManipulateDomainServices {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void saveDomain(BaseEntity baseEntity){
        if (baseEntity.getAction().equals(Action.PURCHASE))
            purchaseRepository.save((Purchase) baseEntity);
        else
            subscriptionRepository.save((Subscription) baseEntity);
    }
}

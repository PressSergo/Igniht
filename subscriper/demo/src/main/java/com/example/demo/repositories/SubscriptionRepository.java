package com.example.demo.repositories;

import com.example.demo.domain.Subscription;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends BaseEntityRepository<Subscription,Long> {
}

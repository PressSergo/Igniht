package com.example.demo.repositories;

import com.example.demo.domain.Purchase;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends BaseEntityRepository<Purchase,Long> {
}

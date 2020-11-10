package com.example.demo.repositories;

import com.example.demo.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity, E extends Serializable>  extends JpaRepository<T,E>{
}

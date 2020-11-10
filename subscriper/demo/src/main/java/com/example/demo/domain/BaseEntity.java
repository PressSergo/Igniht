package com.example.demo.domain;

import com.example.demo.domain.actions.Action;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEntity {
    @Id
    private Long id;
    private Long Msisdn;
    @Enumerated(value = EnumType.STRING)
    private Action action;
}

package com.example.demo.domain;

import com.example.demo.domain.actions.Action;
import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
    private Long id;
    private Long Msisdn;
    private Action action;
}
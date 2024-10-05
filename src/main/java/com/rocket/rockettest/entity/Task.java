package com.rocket.rockettest.entity;

import lombok.Data;

@Data
public class Task {
    private Long id;
    private String name;
    private String description;
    private String initialDate;
}

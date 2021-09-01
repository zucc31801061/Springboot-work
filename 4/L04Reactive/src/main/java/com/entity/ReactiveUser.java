package com.entity;

import lombok.Data;

@Data
public class ReactiveUser {
    private long id;
    private String name;

    public ReactiveUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

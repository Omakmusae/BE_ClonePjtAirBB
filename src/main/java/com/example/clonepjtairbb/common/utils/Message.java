package com.example.clonepjtairbb.common.utils;


import lombok.Getter;

@Getter
public class Message {
    private final String msg;

    public Message(String message) {
        this.msg = message;
    }
}
package com.dailycodebuffer.jwt.model;

import lombok.Data;

@Data
public class Session {
    private int code;
    private String msg;
    private String data;
}

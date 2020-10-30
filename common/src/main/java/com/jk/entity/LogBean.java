package com.jk.entity;

import lombok.Data;

/**
 * mongoDB实体类
 * 消息日志
 */
@Data
public class LogBean {
    private String id;
    private String className;
    private String methodName;
    private String requestParam;
    private String responseParam;
}

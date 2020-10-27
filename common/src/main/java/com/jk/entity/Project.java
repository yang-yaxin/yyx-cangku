package com.jk.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Project {
    private Integer id;

    private String projectId;

    private String projectName;

    private String person;

    private String progress;

    private Integer status;

    private Date startDate;


}
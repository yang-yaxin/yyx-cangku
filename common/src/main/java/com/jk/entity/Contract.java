package com.jk.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Contract {
    private Integer id;

    private Integer contractNo;

    private String contractName;

    private Integer contractType;

    private Integer personId;

    private Date effectiveDate;

    private Date expirationDate;

   private String typeName;
   private String sren;
}
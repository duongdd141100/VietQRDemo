package com.example.demo.dto;

import lombok.Data;

@Data
public class BankDto {
    private Integer id;
    private String name;
    private String code;
    private String bin;
    private String shortName;
    private String logo;
    private Integer transferSupported;
    private Integer lookupSupported;
    private String short_name;
    private Integer support;
    private Integer isTransfer;
    private String swift_code;
}

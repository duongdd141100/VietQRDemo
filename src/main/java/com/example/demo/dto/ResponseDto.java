package com.example.demo.dto;

import lombok.Data;

@Data
public class ResponseDto {
    String code;
    String desc;
    Object data;
}

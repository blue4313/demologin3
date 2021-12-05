package com.example.demologin3.dto;

import lombok.Data;

@Data
public class ResponseDataDTO {

    private String code;
    private String status;
    private String message;
    private Object item;

}

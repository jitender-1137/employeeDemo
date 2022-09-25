package com.ms.employeedemo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDto {

    private String code;

    private String message;

    private Object data;
}

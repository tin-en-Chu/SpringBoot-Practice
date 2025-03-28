package com.example.demo.exception;

import com.example.demo.enums.Code;
import lombok.Data;

@Data
public final class APIException extends Exception{

    private Code errorCode;
    private String message;

    public APIException(Code errorCode , String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}

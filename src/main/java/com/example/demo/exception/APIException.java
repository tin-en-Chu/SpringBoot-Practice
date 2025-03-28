package com.example.demo.exception;

import com.example.demo.util.ErrorCode;
import lombok.Data;

@Data
public final class APIException extends Exception{

    private ErrorCode errorCode;
    private String message;

    public APIException(ErrorCode errorCode , String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}

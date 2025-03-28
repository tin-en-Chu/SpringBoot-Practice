package com.example.demo.bean;

import com.example.demo.util.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestResponse {

    private ErrorCode errorCode;
    private String message;
}

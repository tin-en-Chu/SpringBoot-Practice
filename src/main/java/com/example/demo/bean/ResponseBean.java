package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean<T> {

    /**
     *
     */
    private String statusCode;

    /**
     *
     */
    private T datas;

    private String jwtToken;
}

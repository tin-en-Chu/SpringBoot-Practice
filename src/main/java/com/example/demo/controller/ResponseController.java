package com.example.demo.controller;


import com.example.demo.bean.ResponseBean;
import com.example.demo.bean.ResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ResponseController {

//    @PostMapping(value = "Test" , consumes = "application/json" , produces = "application/json")
//    @ExceptionHandler
//    public ResponseBean<ResponseDTO> test(@RequestBody List<ResponseDTO> res) {
//
//        return ResponseBean.<ResponseDTO>builder().statusCode("200").datas(res).build();
//    }
}

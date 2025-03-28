package com.example.demo.handler;

import com.example.demo.enums.Code;
import com.example.demo.exception.APIException;
import com.example.demo.util.Language;
import com.example.demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 400 error : 運行時異常(請看log)
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e) {
        log.error("運行時異常 => {}", e.getMessage());
        return Result.error(Code.CODE_400.getCode(),Language.RUNTIME_ERROR);
    }

    /**
     * 403 error：權限不足
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = AccessDeniedException.class)
    public Result handler(AccessDeniedException e) {
        log.info("權限不足 => {}", e.getMessage());
        return Result.error(Code.CODE_403.getCode() , Language.AUTHENTICATION_ERROR);
    }

    /**
     * 400 error：方法參數不匹配
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e) {
        log.info("方法參數不匹配 => {}", e.getMessage());
        return Result.error(Code.CODE_400.getCode() , Language.ARGUMENT_NO_MATCH);
    }

    /**
     * 400 error : 非法參數
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result handler(IllegalArgumentException e) {
        log.error("非法參數 => {}", e.getMessage());
        return Result.error(Code.CODE_400.getCode() , Language.ARGUMENT_INVALID);
    }

    /**
     * 500 error : 程式錯誤(請看log)
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = ArithmeticException.class)
    public Result handler(ArithmeticException e) {
        log.error("程式錯誤 => {}", e.getMessage());
        return Result.error(Code.CODE_500.getCode() ,"程式錯誤(請看log)");
    }

    /**
     * API error : API各式問題
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = APIException.class)
    public Result handler(APIException e) {
        log.error("API錯誤 => {}", e.getMessage());
        return Result.error(e.getErrorCode().getCode() , e.getMessage());
    }


}



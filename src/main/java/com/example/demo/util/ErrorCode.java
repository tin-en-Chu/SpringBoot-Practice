package com.example.demo.util;

public enum ErrorCode {

    /**
     * CODE : 400
     * DESC : Bad request
     * ROOT : 參數帶錯
     */
    CODE_400(400),
    /**
     * CODE : 401
     * DESC : Unauthorized request
     * ROOT : 身分驗證錯誤，如JWT驗證
     */
    CODE_401(401);


    private final int code;
    ErrorCode(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

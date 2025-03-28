package com.example.demo.enums;

public enum Code {

    CODE_200(200),
    CODE_400(400),
    CODE_401(401),
    CODE_402(402),
    CODE_403(403),
    CODE_404(404),
    CODE_405(405),
    CODE_500(500);


    private int code;
    Code(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

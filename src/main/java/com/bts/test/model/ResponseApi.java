package com.bts.test.model;

import org.springframework.web.bind.annotation.RestController;

public class ResponseApi {

    private String message;

    private DataApi data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataApi getData() {
        return data;
    }

    public void setData(DataApi data) {
        this.data = data;
    }
}

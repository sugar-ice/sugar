package com.sugar.sugar.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RestBean <T>{
    private int status;
    private String message;
    private T data;

    private RestBean(HttpStatus status, String message, T data){
        this.status = status.value();
        this.message = message;
        this.data = data;
    }

    private RestBean(HttpStatus status, String message){
        this.status = status.value();
        this.message = message;
        this.data = null;
    }
    public static <T> RestBean<T> success(HttpStatus status, String message) {
        return new RestBean<T>(status, message, null);
    }

    public static <T> RestBean<T> success(HttpStatus status , String message, T data) {
        return new RestBean<T>(status, message, data);
    }

    public static <T> RestBean<T> failure(HttpStatus status, String message, T data) {
        return new RestBean<T>(status, message, data);
    }

    public static <T> RestBean<T> failure(HttpStatus status, String message) {
        return new RestBean<T>(status, message);
    }
}

package com.prueba.restaurant.error;

import java.util.List;

public class ApiError {

    private Integer status;
    private String message;
    private List<String> errors;

    public ApiError(Integer status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }


}
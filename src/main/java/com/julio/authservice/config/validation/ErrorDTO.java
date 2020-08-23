package com.julio.authservice.config.validation;

public class ErrorDTO {
    private String message;
    private Integer status;

    public ErrorDTO(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }
}

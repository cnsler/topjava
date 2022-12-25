package ru.javawebinar.topjava.util.exception;

public enum ErrorType {
    APP_ERROR("error.app"),
    DATA_NOT_FOUND("error.dataNotFound"),
    DATA_ERROR("error.data"),
    VALIDATION_ERROR("error.validation");

    private String errorCode;

    ErrorType(String s) {
        errorCode = s;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

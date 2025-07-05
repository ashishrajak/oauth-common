package com.shared.oauth.exception;




import com.shared.oauth.enums.ErrorEnum;

import java.util.ArrayList;
import java.util.List;

public class ApiException extends RuntimeException {

    private final int httpStatusCode; // Derived from ErrorEnum
    private final String errorMessage; // Derived from ErrorEnum
    private final String details; // Optional details for debugging
    private final ErrorEnum errorEnum;

    private final List<String> errorList;

    public ApiException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.httpStatusCode = errorEnum.getHttpStatus().getCode();
        this.errorMessage = errorEnum.getMessage();
        this.errorEnum = errorEnum;
        this.details = null; // Default to no additional details
        this.errorList=new ArrayList<>();
    }


    public ApiException(ErrorEnum errorEnum, List<String> errorList) {
        super(errorEnum.getMessage());
        this.httpStatusCode = errorEnum.getHttpStatus().getCode();
        this.errorMessage = errorEnum.getMessage();
        this.errorEnum = errorEnum;
        this.details = null; // Default to no additional details
        this.errorList=errorList;
    }


    public ApiException(ErrorEnum errorEnum, String details) {
        super(errorEnum.getMessage());
        this.httpStatusCode = errorEnum.getHttpStatus().getCode();
        this.errorMessage = errorEnum.getMessage();
        this.errorEnum = errorEnum;
        this.details = details;
        this.errorList=null;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getDetails() {
        return details;
    }
    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }


    public List<String> getErrorList() {
        return this.errorList;
    }


    @Override
    public String toString() {
        return "ApiException{" +
                "httpStatusCode=" + httpStatusCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", details='" + (details != null ? details : "None") + '\'' +
                '}';
    }
}

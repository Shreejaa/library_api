package com.training.libraryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LibraryException extends RuntimeException{
    private String exceptionDetail;
    private Object value;

    public LibraryException(String exceptionDetail, Long value){
        super(exceptionDetail+'-'+value);
        this.exceptionDetail=exceptionDetail;
        this.value=value;
    }

    public LibraryException(String exceptionDetail){
        super(exceptionDetail);
        this.exceptionDetail=exceptionDetail;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public Object getValue() {
        return value;
    }
}
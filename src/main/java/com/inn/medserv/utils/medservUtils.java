package com.inn.medserv.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class medservUtils
{
    private medservUtils(){

    }
    public static ResponseEntity<String> getResponseEntity(String responseMessage,HttpStatus httpStatus)
    {
        return new ResponseEntity<String>(
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

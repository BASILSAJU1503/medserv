package com.inn.medserv.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(path ="/user")
public interface UserRest {

    @PostMapping(path ="/signUp")
    public ResponseEntity<String> signUp(
            @RequestBody (required = true) Map<String,String> requestMap);


    @GetMapping(path ="/signIn")
    public Integer signIn(
            @RequestBody (required = true) Map<String,String> requestMap);

}

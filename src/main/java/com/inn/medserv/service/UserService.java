package com.inn.medserv.service;

import objectFiles.userVo;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<String> signup(Map<String, String> requestMap);

    Integer signIn(userVo requestMap);
}

package com.inn.medserv.restImpl;

import com.inn.medserv.assembler.userAssembler;
import com.inn.medserv.rest.UserRest;
import com.inn.medserv.service.UserService;
import com.inn.medserv.utils.medservUtils;
import objectFiles.userVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {

        try {
            return userService.signup(requestMap);
        } catch (Exception ex) {

        }
        return medservUtils.getResponseEntity("", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public Integer signIn(Map<String, String> requestMap) {
        userVo userVo=userAssembler.signInVo(requestMap);
        return userService.signIn(userVo);
    }
}

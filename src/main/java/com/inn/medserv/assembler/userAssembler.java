package com.inn.medserv.assembler;

import objectFiles.userVo;

import java.util.Map;

public class userAssembler {
    public static userVo signInVo(Map<String, String> requestMap) {
        return userVo.builder()
                .email(requestMap.get("email"))
                .name(requestMap.get("name"))
                .phoneNumber(requestMap.get("mobile_number")).build();
    }
}

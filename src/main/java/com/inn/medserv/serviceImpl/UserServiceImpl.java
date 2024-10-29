package com.inn.medserv.serviceImpl;

import com.inn.medserv.POJO.User;
import com.inn.medserv.dao.UserDao;
import com.inn.medserv.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        if (validateSignupMap(requestMap)) {
            User user = userDao.findByContactNumber(requestMap.get("contactnumber"));
            if(ObjectUtils.isEmpty(user)){

                userDao.save(getUserFromMap(requestMap));
            }
        } else {

        }
        return null;
    }

    private Boolean validateSignupMap(Map<String, String> requestMap) {

        return requestMap.containsKey("name") ? true : false;
    }

    private  User getUserFromMap(Map<String, String> requestMap){
        User user =new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
                return user;

    }
}

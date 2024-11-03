package com.inn.medserv.serviceImpl;

import com.inn.medserv.POJO.userEntity;
import com.inn.medserv.dao.UserDao;
import com.inn.medserv.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        validateRegisterInputs(requestMap);
        userEntity user = new userEntity();
        user = buildUserDetail(requestMap);
        userDao.save(user);

        return null;
    }

    private userEntity buildUserDetail(Map<String, String> requestMap) {
        userEntity user = new userEntity();

        // Set each field of UserEntity based on the values from requestMap
        user.setFirstName(requestMap.get("first_name"));
        user.setLastName(requestMap.getOrDefault("last_name", ""));
        user.setUsername(requestMap.get("username"));
        user.setPassword(requestMap.get("password"));
        user.setUserType(mapUserType(requestMap.get("user_type")));
        user.setEmail(requestMap.get("email"));
        user.setMobileNumber(requestMap.get("mobile_number"));
        user.setAge(requestMap.containsKey("age") ? Integer.parseInt(requestMap.get("age")) : null);
        user.setGender(mapGender(requestMap.get("gender")));
        user.setAddress(requestMap.getOrDefault("address", ""));
        user.setDateOfBirth(requestMap.containsKey("date_of_birth") ? LocalDateTime.parse(requestMap.get("date_of_birth")) : null);
        user.setStatus(1); // Assuming new users are set to 'active' by default

        return user;
    }

    // Helper method to map user type string to Integer value
    private Integer mapUserType(String userType) {
        switch (userType.toLowerCase()) {
            case "doctor":
                return 1;
            case "admin":
                return 2;
            case "patient":
                return 3;
            default:
                throw new IllegalArgumentException("Invalid user type.");
        }
    }

    // Helper method to map gender string to Integer value
    private Integer mapGender(String gender) {
        if (gender == null) {
            return null; // If gender is optional
        }
        switch (gender.toLowerCase()) {
            case "male":
                return 1;
            case "female":
                return 2;
            case "other":
                return 3;
            default:
                throw new IllegalArgumentException("Invalid gender.");
        }
    }


    private void validateRegisterInputs(Map<String, String> requestMap) {
        if (requestMap == null) {
            throw new IllegalArgumentException("Input data cannot be null.");
        }

        // Validate first name
        if (!requestMap.containsKey("first_name") || requestMap.get("first_name").trim().isEmpty()) {
            throw new IllegalArgumentException("First name is required and cannot be empty.");
        }

        // Validate mobile number
        if (!requestMap.containsKey("mobile_number") || requestMap.get("mobile_number").trim().isEmpty()) {
            throw new IllegalArgumentException("Mobile number is required and cannot be empty.");
        } else if (!requestMap.get("mobile_number").matches("\\d{10}")) { // Assuming 10-digit mobile number
            throw new IllegalArgumentException("Mobile number must be a 10-digit number.");
        }

        // Validate user type
        if (!requestMap.containsKey("user_type") || requestMap.get("user_type").trim().isEmpty()) {
            throw new IllegalArgumentException("User type is required and cannot be empty.");
        } else {
            String userType = requestMap.get("user_type").toLowerCase();
            if (!userType.equals("doctor") && !userType.equals("admin") && !userType.equals("patient")) {
                throw new IllegalArgumentException("Invalid user type. Allowed values are 'doctor', 'admin', or 'patient'.");
            }
        }
    }


//    public ResponseEntity<String> signup(Map<String, String> requestMap) {
//        if (validateSignupMap(requestMap)) {
//            userEntity user = userDao.findByContactNumber(requestMap.get("contactnumber"));
//            if(ObjectUtils.isEmpty(user)){
//
//                userDao.save(getUserFromMap(requestMap));
//            }
//        } else {
//
//        }
//        return null;
//    }

//    private Boolean validateSignupMap(Map<String, String> requestMap) {
//        return requestMap.containsKey("name") ? true : false;
//    }

//    private userEntity getUserFromMap(Map<String, String> requestMap) {
//        userEntity user = new userEntity();
//        user.setName(requestMap.get("name"));
//        user.setContactNumber(requestMap.get("contactNumber"));
//        return user;
//
//    }
}

package com.inn.medserv.dao;

import com.inn.medserv.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao  extends JpaRepository<User,Integer> {


    public User findByContactNumber(@Param("contactNumber") String contactNumber);
}

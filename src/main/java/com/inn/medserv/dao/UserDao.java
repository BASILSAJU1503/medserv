package com.inn.medserv.dao;

import com.inn.medserv.POJO.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao  extends JpaRepository<userEntity,Integer> {


    public userEntity findByUserId(@Param("userId") Integer userId);

}
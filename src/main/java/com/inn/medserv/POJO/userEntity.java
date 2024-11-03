package com.inn.medserv.POJO;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@NamedQuery(name = "User.findByUserId", query = "SELECT u FROM userEntity u WHERE u.userId = :userid")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "t_userdetail")
public class userEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_type", nullable = false)
    private Integer userType; // 1 = doctor, 2 = admin, 3 = patient

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private Integer gender; // 1 = male, 2 = female, 3 = other

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @Column(name = "status", nullable = false)
    private Integer status; // 1 = active, 0 = inactive
}

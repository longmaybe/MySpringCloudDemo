package com.nifu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private  Long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerdate;
    private String address;
}

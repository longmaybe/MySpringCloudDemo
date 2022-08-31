package com.nifu.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderUserShowVo {
    private Long id;
    private String menuName;
    private double price;
    private String flavor;
    private Date date;
    private int state;
    private String nickname;
    private String telephone;
    private String address;
}

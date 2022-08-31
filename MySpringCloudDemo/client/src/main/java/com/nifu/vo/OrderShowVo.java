package com.nifu.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderShowVo {
    private Integer id;
    private String menuName;
    private String price;
    private String flavor;
    private Date date;
    private int state;
}

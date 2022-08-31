package com.nifu.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrderVo {
    private int code;
    private String msg;
    private int count;
    private List<OrderShowVo> data;
}

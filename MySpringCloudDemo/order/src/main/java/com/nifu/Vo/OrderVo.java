package com.nifu.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderVo {
    private int code;
    private String msg;
    private int count;
    private List<OrderShowVo> data;
}

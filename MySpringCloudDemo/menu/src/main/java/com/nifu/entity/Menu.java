package com.nifu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

//对应前端用户展示的
@Data
@TableName("t_menu")
@AllArgsConstructor
public class Menu {
    private Integer id;
    private String name;
    private double price;
    private  String flavor;
    private Integer tid;
}

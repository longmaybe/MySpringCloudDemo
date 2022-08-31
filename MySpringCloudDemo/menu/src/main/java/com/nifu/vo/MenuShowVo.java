package com.nifu.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_menu")
public class MenuShowVo {
    private Integer id;
    private String name;
    private double price;
    private  String flavor;
    @TableField(exist = false)
    private  String type;
}

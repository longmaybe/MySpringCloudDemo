package com.nifu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_type")
public class Type {
    private long id;
    @TableField("name")
    private  String type;
}

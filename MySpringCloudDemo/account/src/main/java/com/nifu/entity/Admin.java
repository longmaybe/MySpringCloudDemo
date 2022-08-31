package com.nifu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_admin")
public class Admin {
    private Integer id;
    private String username;
    private String password;
}

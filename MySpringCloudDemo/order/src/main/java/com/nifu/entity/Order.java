package com.nifu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "uid")
    private Integer userId;
    @TableField(value = "mid")
    private Integer menuId;
    @TableField(value = "aid")
    private Integer adminId;
    @TableField(value = "date")
    private Date createTime;
    @TableField(value = "state")
    private Integer state;
}

package com.nifu.vo;

import com.nifu.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserVo {
    private int code;
    private String msg;
    private int count;
    private List<User> data;
}

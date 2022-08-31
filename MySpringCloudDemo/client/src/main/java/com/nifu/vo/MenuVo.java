package com.nifu.vo;

import com.nifu.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MenuVo {
    private int code;
    private String msg;
    private int count;
    private List<MenuShowVo> data;
}

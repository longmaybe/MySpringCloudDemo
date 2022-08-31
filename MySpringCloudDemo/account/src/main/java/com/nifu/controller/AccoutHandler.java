package com.nifu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nifu.mapper.AdminMapper;
import com.nifu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.ObjIntConsumer;

@RequestMapping("/account")
@RestController
public class AccoutHandler {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,
                        @PathVariable("password") String password,
                        @PathVariable("type") String type){
        Object object=null;
        switch (type){
            case "user":
                QueryWrapper wrapper=new QueryWrapper();
                wrapper.eq("username",username);
                wrapper.eq("password",password);
                object=userMapper.selectOne(wrapper);
                break;
            case "admin":
                QueryWrapper wrapper1=new QueryWrapper();
                wrapper1.eq("username",username);
                wrapper1.eq("password",password);
                object=adminMapper.selectOne(wrapper1);
        }
        return object;
    }
}

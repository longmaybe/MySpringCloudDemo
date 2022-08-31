package com.nifu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nifu.entity.User;
import com.nifu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserMapper userMapper;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "当前端口"+this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") Integer index,@PathVariable("limit") Integer limit){
        index=(index-1)*limit;
        return userMapper.findAll(index,limit);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Long id){
        return userMapper.selectById(id);
    }

    @GetMapping("/count")
    public Long count(){
        return userMapper.selectCount(null);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userMapper.insert(user);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("id",user.getId());
        userMapper.update(user,wrapper);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        userMapper.deleteById(id);
    }
}

package com.nifu.controller;

import com.nifu.entity.User;
import com.nifu.feign.UserFeign;
import com.nifu.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "当前端口"+this.port;
    }
    @ResponseBody
    @GetMapping("/findAll")
    public UserVo findAll(@RequestParam("page") Integer index, @RequestParam("limit") Integer limit){
        return new UserVo(0,"",userFeign.count().intValue(), userFeign.findAll(index,limit));
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Long id){
        return userFeign.findById(id);
    }

    @GetMapping("/count")
    public Long count(){
        return userFeign.count();
    }

    @PostMapping("/save")
    public String save( User user){
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @PostMapping("/update")
    public void update( User user){
        userFeign.update(user);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id){
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }
}

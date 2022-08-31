package com.nifu.controller;


import com.nifu.entity.Admin;
import com.nifu.entity.User;
import com.nifu.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type,
                        HttpSession session) {
        Object object = accountFeign.login(username, password, type);
        LinkedHashMap<String,Object> hashMap=(LinkedHashMap) object ;
        String result =null;
        if(object == null){
            result="login";
        }else {
            switch(type){
                case "user":
                    User user=new User();
                    user.setId(Long.parseLong(hashMap.get("id").toString()));
                    user.setNickname((String) hashMap.get("nickname"));
                    session.setAttribute("user",user);
                    result = "index";
                    break;
                case"admin":
                    Admin admin =new Admin();
                    admin.setId(Integer.parseInt(hashMap.get("id").toString()));
                    admin.setUsername((String) hashMap.get("username"));
                    session.setAttribute("user",admin);
                    result = "main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
}
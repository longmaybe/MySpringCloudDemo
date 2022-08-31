package com.nifu.controller;

import com.nifu.entity.User;
import com.nifu.feign.OrderFeign;
import com.nifu.vo.OrderShowVo;
import com.nifu.vo.OrderUserVo;
import com.nifu.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public void save(@PathVariable("mid") Integer mid,HttpSession session){
        User user=new User();
        user=(User) session.getAttribute("user");
        orderFeign.save(mid,Integer.parseInt(user.getId().toString()));
    }

    @GetMapping("/findByUid")
    @ResponseBody
    public OrderVo findByUid(@RequestParam("page") int page,@RequestParam("limit") int limit,HttpSession session){
        User user= new User();
        user=(User) session.getAttribute("user");
        return orderFeign.findByUid(Integer.parseInt(user.getId().toString()),page,limit);
    }
    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderUserVo findAllByState(@RequestParam("page")int page, @RequestParam("limit") int limit){
        return orderFeign.findAllByState(page,limit);
    }
    @GetMapping("/updateState/{id}")
    public String updateState(@PathVariable("id") Long id){
        orderFeign.updateState(id);
        return "redirect:/menu/redirect/order_handler";
    }
}

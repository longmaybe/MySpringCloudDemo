package com.nifu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.nifu.Mapper.OrderMapper;
import com.nifu.Vo.OrderShowVo;
import com.nifu.Vo.OrderUserShowVo;
import com.nifu.Vo.OrderUserVo;
import com.nifu.Vo.OrderVo;
import com.nifu.entity.Order;
import com.nifu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Value("/${server.port}")
    private String port;
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/index")
    public String index(){
        return "order端口"+this.port;
    }

    @GetMapping("/save/{mid}/{uid}")
    public void save(@PathVariable("mid") Integer mid,@PathVariable("uid") Integer uid){
        Order order= new Order();
        order.setMenuId(mid);
        order.setUserId(uid);
        order.setCreateTime(new Date());
        order.setState(0);
        orderMapper.insert(order);
    }

    @GetMapping("/findByUid/{uid}/{page}/{limit}")
    public OrderVo findByUid(@PathVariable("uid") Integer uid,@PathVariable("page") int page,@PathVariable("limit") int limit){
        int index=(page-1)*limit;
        List<OrderShowVo> list=orderMapper.findByUid(uid,index,limit);
        return new OrderVo(0,"",list.size(),list);
    }

    @GetMapping("/findAllByState/{page}/{limit}")
    public OrderUserVo findAllByState(@PathVariable("page") int page, @PathVariable("limit") int limit){
        int index=(page-1)*limit;
        List<OrderUserShowVo> list=orderMapper.findAllByState(index,limit);
        return new OrderUserVo(0,"", list.size(),list);
    }
    @GetMapping("/updateState/{id}")
    public void updateState(@PathVariable("id") Long id){
        UpdateWrapper<Order> wrapper=new UpdateWrapper<>();
        wrapper.eq("id",id).set("state",1);
        orderMapper.update(null,wrapper);
    }
}

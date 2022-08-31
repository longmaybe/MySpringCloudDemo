package com.nifu.feign;

import com.nifu.vo.OrderShowVo;
import com.nifu.vo.OrderUserVo;
import com.nifu.vo.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@FeignClient("order")
public interface OrderFeign {

    @GetMapping("/order/save/{mid}/{uid}")
    public void save(@PathVariable("mid") Integer mid, @PathVariable("uid") Integer uid);

    @GetMapping("/order/findByUid/{uid}/{page}/{limit}")
    public OrderVo findByUid(@PathVariable("uid") Integer uid,@PathVariable("page") int page,@PathVariable("limit") int limit);

    @GetMapping("/order/findAllByState/{page}/{limit}")
    public OrderUserVo findAllByState(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @GetMapping("/order/updateState/{id}")
    public void updateState(@PathVariable("id") Long id);
}

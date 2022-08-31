package com.nifu.feign;

import com.nifu.entity.Menu;
import com.nifu.entity.Type;
import com.nifu.vo.MenuShowVo;
import com.nifu.vo.MenuVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//注册中心的名字
@FeignClient(value = "menu")
public interface MenuFeign {
    @GetMapping("/menu/findAll/{page}/{limit}")
    public MenuVo findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id);

    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    public void save(@RequestBody Menu menu);

    @GetMapping("/menu/findById/{id}")
    public MenuShowVo findById(@PathVariable("id") Long id);

    @PutMapping("/menu/update")
    public void update(@RequestBody MenuShowVo menu);
}

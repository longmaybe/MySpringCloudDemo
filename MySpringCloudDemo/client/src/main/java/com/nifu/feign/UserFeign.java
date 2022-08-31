package com.nifu.feign;

import com.nifu.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user")
public interface UserFeign {

    @GetMapping("/user/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") Integer index,@PathVariable("limit") Integer limit);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") Long id);

    @GetMapping("/user/count")
    public Long count();

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id);

    @PostMapping("/user/update")
    public void update(@RequestBody User user);
}

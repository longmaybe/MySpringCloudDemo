package com.nifu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nifu.entity.Menu;
import com.nifu.entity.Type;
import com.nifu.mapper.MenuMapper;
import com.nifu.mapper.TypeMapper;
import com.nifu.vo.MenuShowVo;
import com.nifu.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private TypeMapper typeMapper;

    @Value("/${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "menu的端口"+this.port;
    }

    @GetMapping("/findAll/{page}/{limit}")
    public MenuVo findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
        int index=(page-1)*limit;
        List<MenuShowVo> list=menuMapper.findAll(index,limit);
        return new MenuVo(0,"",menuMapper.selectCount(null).intValue(),list);
    }


    @GetMapping("/findById/{id}")
    public MenuShowVo findById(@PathVariable("id") Long id){
        return menuMapper.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuMapper.insert(menu);
    }

    @PutMapping("/update")
    public void update(@RequestBody MenuShowVo menuShowVo){
        Menu menu1=new Menu(menuShowVo.getId(),menuShowVo.getName(),menuShowVo.getPrice(),menuShowVo.getFlavor(),typeMapper.getTId(menuShowVo.getType()));
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("id",menu1.getId());
        menuMapper.update(menu1,wrapper);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        menuMapper.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeMapper.selectList(null);
    }

}
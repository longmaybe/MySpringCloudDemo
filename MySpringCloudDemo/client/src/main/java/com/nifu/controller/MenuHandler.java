package com.nifu.controller;


import com.nifu.entity.Menu;
import com.nifu.feign.MenuFeign;
import com.nifu.vo.MenuShowVo;
import com.nifu.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuFeign menuFeign;

    @ResponseBody
    @GetMapping("/findAll")
    public MenuVo findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return menuFeign.findAll(page,limit);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/menu_manage";
    }

    @GetMapping("/addMenu")
    public ModelAndView findTypes(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("types",menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save( Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView finById(@PathVariable("id") Long id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",menuFeign.findById(id));
        modelAndView.addObject("types",menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(MenuShowVo menu){
        menuFeign.update(menu);
        return "redirect:/menu/redirect/menu_manage";
    }




}

package com.nifu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nifu.entity.Menu;
import com.nifu.vo.MenuShowVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("select m.id, m.`name`,m.price,m.flavor,t.name type from t_menu m,t_type t WHERE m.tid=t.id ORDER BY m.id LIMIT #{index},#{limit}")
    public List<MenuShowVo> findAll(int index, int limit);
    @Select("select m.id,m.`name`,m.price,m.flavor,t.name type from t_menu m,t_type t where t.id=m.tid and m.id=#{id}")
    public MenuShowVo findById(Long id);
}

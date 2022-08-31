package com.nifu.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nifu.Vo.OrderShowVo;
import com.nifu.Vo.OrderUserShowVo;
import com.nifu.entity.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

    @Select("select o.id,m.`name` menuName, m.price,m.flavor,o.date,o.state  from t_order o,t_menu m where o.uid=m.id and o.uid=#{uid} limit #{index},#{limit}")
    public List<OrderShowVo> findByUid(Integer uid,int index,int limit);
    @Select("select o.id,m.`name` menuName, m.price,m.flavor,o.date,o.state,u.nickname,u.telephone,u.address from t_order o,t_menu m,t_user u where o.uid=m.id and o.state=0 and o.uid=u.id limit #{index},#{limit}")
    public List<OrderUserShowVo> findAllByState(int index, int limit);
}

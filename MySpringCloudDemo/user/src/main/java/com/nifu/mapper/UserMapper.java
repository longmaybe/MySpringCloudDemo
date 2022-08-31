package com.nifu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nifu.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user limit #{index},#{limit}")
    public List<User> findAll(Integer index,Integer limit);

}

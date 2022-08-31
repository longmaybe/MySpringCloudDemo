package com.nifu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nifu.entity.Type;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface TypeMapper extends BaseMapper<Type> {
    @Select("select id tid from t_type where name=#{type}")
    public Integer getTId(String type);
}

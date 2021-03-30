package com.example.mybatisplusdemo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.dto.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where name like %${name}%")
    public List<User> selectUserByName(String name);
}

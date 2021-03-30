package com.example.mybatisplusdemo.mapper;

import com.example.mybatisplusdemo.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author songxl
 * @since 2021-03-25
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

     List<UserInfo> getUserByName(String name);
}

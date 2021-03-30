package com.example.mybatisplusdemo.service;

import com.example.mybatisplusdemo.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songxl
 * @since 2021-03-25
 */
public interface UserInfoService extends IService<UserInfo> {

    int mapperSave(UserInfo userInfo);
    int delete(UserInfo userInfo);


    List<UserInfo> getByName(UserInfo userInfo);
    List<UserInfo> getUserByNames(UserInfo userInfo);
}

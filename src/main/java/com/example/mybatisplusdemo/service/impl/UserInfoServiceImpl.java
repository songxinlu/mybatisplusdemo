package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplusdemo.entity.UserInfo;
import com.example.mybatisplusdemo.mapper.UserInfoMapper;
import com.example.mybatisplusdemo.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songxl
 * @since 2021-03-25
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int mapperSave(UserInfo userInfo) {
        return baseMapper.insert(userInfo);
    }
    @Override
    public int delete(UserInfo userInfo)
    {
        return baseMapper.deleteById(userInfo.getId());
    }
    @Override
    public List<UserInfo> getUserByNames(UserInfo userInfo) {
        String sql = "select name from user_info where age > $$";
        //对sql进行参数替换
        sql = sqlAddParam(sql,userInfo);
        return baseMapper.selectList(new QueryWrapper<UserInfo>()
                .like("name",userInfo.getName())
                .isNotNull("email")
                .inSql("name",sql)
                .orderByDesc("","","")
        );

    }

    private String sqlAddParam(String sql, UserInfo userInfo) {
        return sql;
    }

    @Override
    public List<UserInfo> getByName(UserInfo userInfo) {
        return userInfoMapper.getUserByName(userInfo.getName());


    }
}

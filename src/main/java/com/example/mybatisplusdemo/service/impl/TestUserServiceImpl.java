package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.entity.TestUser;
import com.example.mybatisplusdemo.mapper.TestUserMapper;
import com.example.mybatisplusdemo.service.TestUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songxl
 * @since 2021-03-25
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements TestUserService {

}

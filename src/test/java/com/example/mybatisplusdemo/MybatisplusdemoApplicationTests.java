package com.example.mybatisplusdemo;

import com.example.mybatisplusdemo.dto.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisplusdemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void testSelectUserByName() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectUserByName("J");
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}

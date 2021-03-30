package com.example.mybatisplusdemo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * @ClassName: User
 * @Description: 用户类
 * @Author songxl
 * @Date 2021/3/23
 * @Version 1.0
 */
//如果表明和类名一致的话可以不用写tablename
@TableName("user_info")
public class User {
    private Long id;
    @TableField("name")
    private String userName;
    @TableField("age")
    private Integer userAge;
    @TableField("email")
    private String userEmail;
}

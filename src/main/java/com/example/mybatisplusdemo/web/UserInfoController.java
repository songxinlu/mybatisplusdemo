package com.example.mybatisplusdemo.web;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.entity.UserInfo;
import com.example.mybatisplusdemo.response.ResponseDate;
import com.example.mybatisplusdemo.service.impl.UserInfoServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songxl
 * @since 2021-03-25
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoServiceImpl userInfoService;

    @PostMapping("/get/id")
    public UserInfo getUserById(@RequestBody String id)
    {
        System.out.println(id);
        return userInfoService.getById(id);
    }
    @PostMapping("/get/name")
    public UserInfo getUserById(@RequestBody UserInfo userInfo)
    {
        System.out.println(userInfo);
        return userInfoService.getOne(new QueryWrapper<UserInfo>().eq("name",userInfo.getName()));
    }

    @PostMapping("/mapper/get/name")
    public List<UserInfo> getUserByMName(@RequestBody UserInfo userInfo)
    {
        System.out.println(userInfo);
        return userInfoService.getByName(userInfo);
    }
    @PostMapping("/mapper/get/byname")
    public List<UserInfo> getUserByName(@RequestBody UserInfo userInfo)
    {
        return userInfoService.getUserByNames(userInfo);
    }

    @PostMapping("/get/getMap")
    public Map<String, Object> getMap(@RequestBody UserInfo userInfo)
    {
        System.out.println(userInfo);
        return userInfoService.getMap(new QueryWrapper<UserInfo>().eq("name",userInfo.getName()));
    }


    @PostMapping("/get/ByMap")
    public List<UserInfo> getMap(@RequestBody Map<String, Object> columnMap)
    {
        return (List<UserInfo>) userInfoService.listByMap(columnMap);
    }
    @PostMapping("/get/listMaps")
    public List<Map<String, Object>> listMaps()
    {
        return userInfoService.listMaps();
    }
    @PostMapping("/get/all")
    public List<UserInfo> getUser()
    {
        return userInfoService.list();
    }
    @PostMapping("/count")
    public int count()
    {
        return userInfoService.count();
    }
    @PostMapping("/get/byAge")
    public List<UserInfo> getByAge(@RequestBody UserInfo userInfo)
    {
        return userInfoService.list(new QueryWrapper<UserInfo>().le("age",userInfo.getAge()));
    }
    @PostMapping("/get/page")
    public IPage<UserInfo> getUserPage(@RequestBody Page<UserInfo> page)
    {
        System.out.println(page);
        return userInfoService.page(page);
    }
    @PostMapping("/save")
    @Transactional
    public ResponseDate<Integer> save(@RequestBody UserInfo userInfo)
    {
        ResponseDate<Integer> out = new ResponseDate<>();
        try {
            if(userInfoService.save(userInfo))
            {
                out.setInfo(0);
            }
            else
            {
                out.setInfo(-3);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            out.setStatus(-3);
            out.setMsg(e.getMessage());
        }
        return out;
    }

    @PostMapping("/mapper/save")
    @Transactional
    public ResponseDate<Integer> mapperSave(@RequestBody UserInfo userInfo)
    {
        ResponseDate<Integer> out = new ResponseDate<>();
        try {
            out.setInfo(userInfoService.mapperSave(userInfo));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            out.setStatus(-3);
            out.setMsg(e.getMessage());
        }
        return out;
    }

    @PostMapping("/saveBatch")
    public ResponseDate<Integer> saveBatch(@RequestBody List<UserInfo> userInfos)
    {
        ResponseDate<Integer> out = new ResponseDate<>();
        try {
            if(userInfoService.saveBatch(userInfos,2))
            {
                out.setInfo(0);
            }
            else
            {
                out.setInfo(-3);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            out.setStatus(-3);
            out.setMsg(e.getMessage());
        }
        return out;
    }
    @PostMapping("/saveOrupdate")
    public ResponseDate<Integer> saveOrupdate(@RequestBody UserInfo userInfo)
    {
        ResponseDate<Integer> out = new ResponseDate<>();
        try {
            if(userInfoService.saveOrUpdate(userInfo))
            {
                out.setInfo(0);
            }
            else
            {
                out.setInfo(-3);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            out.setStatus(-3);
            out.setMsg(e.getMessage());
        }
        return out;
    }
    @PostMapping("/update")
    public ResponseDate<Integer> update(@RequestBody UserInfo userInfo)
    {
        ResponseDate<Integer> out = new ResponseDate<>();
        try {
            if(userInfoService.update(new UpdateWrapper<UserInfo>()
                    .set("name",userInfo.getName())
                    .eq("id",userInfo.getId())))
            {
                out.setInfo(0);
            }
            else
            {
                out.setInfo(-3);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            out.setStatus(-3);
            out.setMsg(e.getMessage());
        }
        return out;
    }
}

package com.example.mybatisplusdemo.response;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName: ResponseDate
 * @Description: http请求返回结果
 * @Author songxl
 * @Date 2021/3/25
 * @Version 1.0
 */
@Getter
@Setter
public class ResponseDate<T> implements Serializable {
    private int status;
    private T info;
    private String msg;
}

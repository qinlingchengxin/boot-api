package net.ys.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Admin implements Serializable {
    private String id;    //主键
    private int magType;    //类型 0-普通管理员/1-超级管理员
    private String username;    //用户名
    private String pwd;    //密码
}
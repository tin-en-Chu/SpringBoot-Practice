package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
//@TableName("user")
public class UserBean {
    //        @TableId(type = IdType.AUTO)
    private Integer id;

    //        @TableField("username")
    private String userName;

    //        @TableField("password")
    private String pwd;

    //        @TableField(exist = false)
//    private Set<String> perms;
}


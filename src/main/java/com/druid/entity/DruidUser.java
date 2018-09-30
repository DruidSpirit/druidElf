package com.druid.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
@Data
@Builder
@Table(name = "druid_user")
public class DruidUser {
    /**
     * id
     */
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
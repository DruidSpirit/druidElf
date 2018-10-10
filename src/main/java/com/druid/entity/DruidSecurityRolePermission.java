package com.druid.entity;

import javax.persistence.*;

@Table(name = "druid_security_role_permission")
public class DruidSecurityRolePermission {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限
     */
    private String permission;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限
     *
     * @return permission - 权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限
     *
     * @param permission 权限
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }
}